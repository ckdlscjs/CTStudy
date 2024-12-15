import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main147  {

    static int[][][] board = new int[31][31][31];
    static int[][][] dist = new int[31][31][31];

    static int[] dz = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dx = {0,0,0,0,1,-1};

    static class Pair{
        int z;
        int y;
        int x;
        Pair(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) 
    throws IOException{


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int[] LRC = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(s->Integer.parseInt(s))
                            .toArray();
            int L = LRC[0];
            int R = LRC[1];
            int C = LRC[2];
            if(L+R+C==0){
                System.out.print(sb);
                return;
            }
            int curL = 0;
            int curR = 0;
            int curC = 0;

            int goalL = 0;
            int goalR = 0;
            int goalC = 0;
            for(int l = 0;l<L;l++){
                for(int i = 0;i<=R;i++){
                    String tmp = bf.readLine();
                    int j = 0;
                    for(char c : tmp.toCharArray()){
                        dist[l][i][j] = 31*31*31;
                        board[l][i][j++] = (c=='.') ? 0 : (c=='#') ? 1 : (c=='S') ? 2 : 3; 
                        if(board[l][i][j-1]==2){
                            curL = l;
                            curR = i;
                            curC = j-1;
                        }
                        else if(board[l][i][j-1]==3){
                            goalL = l;
                            goalR = i;
                            goalC = j-1;
                        }
                    }
                }
            }
            BFS(curL, curR, curC, L, R, C);
            if(dist[goalL][goalR][goalC] == (31*31*31)){
                // System.out.println("Trapped!\n");
                sb.append("Trapped!\n");
            }else{
                // System.out.printf("Escaped in %d minute(s).\n", dist[goalL][goalR][goalC]);
                sb.append(String.format("Escaped in %d minute(s).\n", dist[goalL][goalR][goalC]));
            }
        }
        
    }

    static void BFS(int l, int r, int c, int L, int R, int C){
        ArrayDeque<Pair> deq = new ArrayDeque<>();

        deq.addLast(new Pair(l, r, c));
        dist[l][r][c] = 0;

        while(!deq.isEmpty()){
            Pair cur = deq.pollFirst();
            int z = cur.z;
            int y = cur.y;
            int x = cur.x;

            for(int i = 0;i<6;i++){
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(isOutside(nz, ny, nx, L, R, C)) continue;
                if(board[nz][ny][nx]==1) continue;
                if(dist[nz][ny][nx] > dist[z][y][x]+1){
                    dist[nz][ny][nx] = dist[z][y][x]+1;
                    deq.addLast(new Pair(nz, ny, nx));
                }
            }
        }
    }

    static boolean isOutside(int z, int y, int x, int L, int R, int C){
        return (0>z || 0>y || 0>x || z>=L || y>=R || x>=C);
    }
}

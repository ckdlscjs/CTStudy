import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main133 {

    static int[][] board = new int[50][50];
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    static class Pair{
        int y;
        int x;
        Pair(int y, int x ){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int[] MNK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = MNK[1];
            int M = MNK[0];
            int K = MNK[2];
            for(int i =0;i<N;i++){
                for(int j = 0;j<M;j++){
                    board[i][j] = 0;
                }
            }
            for(int i = 0;i<K;i++){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            int cnt = 0;
            for(int i = 0;i<N;i++){
                
                for(int j = 0;j<M;j++){
                    if(board[i][j]==1){
                        BFS(i, j, N, M);
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }

    static void BFS(int y, int x, int N, int M){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.addLast(new Pair(y, x));

        while(!que.isEmpty()){
            Pair cur = que.pollFirst();
            int cur_y = cur.y;
            int cur_x = cur.x;

            for(int i = 0;i<4;i++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                if(isOutside(ny,nx, N, M)) continue;
                if(board[ny][nx]==1){
                    que.addLast(new Pair(ny, nx));
                    board[ny][nx] = 0;
                }
            }
        }
    }

    static boolean isOutside(int ny, int nx, int N, int M){
        return (0>ny || 0>nx || ny>=N || nx>=M);
    }
}

// 5 3 6 
// 0 0 0 0 1 
// 0 0 0 0 0 
// 1 1 1 1 1 

// 0 0 0 0 1 
// 0 0 0 0 0 
// 1 1 1 1 1 
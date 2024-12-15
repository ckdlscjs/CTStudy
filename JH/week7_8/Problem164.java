import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem164 {


    static boolean isOutside(int y, int x, int M, int N){
        return (0>y || 0>x || y>=M || x>=N);
    }

    static int BFS(int M, int N, int K){
        
        Deque<int[]> que = new ArrayDeque<>();

        que.add(new int[]{0,0,0,0});
        int[] dy_monkey = {0,0,1,-1};
        int[] dx_monkey = {1,-1,0,0};
        int[] dy_horse = {2,-2,2,-2,1,-1,1,-1};
        int[] dx_horse = {1,1,-1,-1,2,2,-2,-2};
        boolean[][][] chk = new boolean[M][N][K+1];
        int ret = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            // System.out.println(1);
            int[] cur = que.poll();
            int cur_y = cur[0];
            int cur_x = cur[1];
            int cur_possible = cur[2];
            int cur_dist = cur[3];
            // System.out.println(cur_y + " " + cur_x + " " + cur_possible + " " + cur_dist);
            if(cur_y==(M-1) && cur_x==(N-1)){
                return cur_dist;
                // ret = Math.min(ret, cur_dist);
            }
            
            if(cur_possible<K){

                for(int i = 0;i<8;i++){
                    int ny = cur_y + dy_horse[i];
                    int nx = cur_x + dx_horse[i];
                    if(isOutside(ny, nx, M, N) || chk[ny][nx][cur_possible+1] || board[ny][nx]==1) continue;
                    chk[ny][nx][cur_possible+1] = true;
                    que.addLast(new int[]{ny,nx,cur_possible+1,cur_dist+1});
                }
            }
            
            for(int i = 0;i<4;i++){
                int ny = cur_y + dy_monkey[i];
                int nx = cur_x + dx_monkey[i];
                if(isOutside(ny, nx, M, N) || chk[ny][nx][cur_possible] || board[ny][nx]==1) continue;
                chk[ny][nx][cur_possible] = true;
                que.addLast(new int[]{ny,nx,cur_possible,cur_dist+1});
            }
            
            
        }
        
        return (ret==Integer.MAX_VALUE) ? -1 : ret;
    }

    static int[][] board;
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        int[] NM = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        int N = NM[0];
        int M = NM[1]; // how many time monkey can ride a horse
        board = new int[M][N];
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(M, N,K));
    }
}

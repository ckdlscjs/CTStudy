package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem303 {

    static int[][] MAP = new int[1001][1001];
    // static int[][][] dist = new int[1001][1001][10];
    static boolean[][][] chk = new boolean[1001][1001][11];
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static final int INF = (1001*1001*13);

    // static class Pair{
    //     int y;
    //     int x;
    //     int possible;
    //     Pair(int y, int x, int possible){
    //         this.y = y;
    //         this.x = x;
    //         this.possible = possible;
    //     }
    // }
    public static void main(String[] args)
            throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NMK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMK[0];
        int M = NMK[1];
        int K = NMK[2];
        for(int i = 0;i<N;i++){
            String tmp = bf.readLine();
            for(int j = 0;j<M;j++){
                // Arrays.fill(dist[i][j], INF);
                char c = tmp.charAt(j);
                MAP[i][j] = (c=='0') ? 0 : 1;
            }
        }

        int ret = BFS(0,0,N, M, K);
        // int ret = Arrays.stream(dist[N-1][M-1]).min().getAsInt();
        System.out.println(ret);

    }

    static int BFS(int y, int x, int N, int M, int possible){

        Deque<int[]> deq = new ArrayDeque<>();
        for(int i = 0;i<possible;i++){
            chk[y][x][i] = true;
        }

        deq.addLast(new int[]{y, x, 0,1}); // y x cur_possible cur_dist

        int ret = INF;

        while(!deq.isEmpty()){
            int[] cur = deq.pollFirst();
            int cur_y = cur[0];
            int cur_x = cur[1];
            int cur_possible = cur[2];
            int cur_dist = cur[3];
            if(cur_y==N-1 && cur_x == M-1){
                // System.out.println(cur_y + " " +  cur_x + " " + cur_dist);
                return cur_dist;
            }

            for(int i = 0;i<4;i++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                if(isOutside(ny, nx, N, M)) continue;

                if (MAP[ny][nx] == 1 && cur_possible < possible) {
                    if (!chk[ny][nx][cur_possible+1]) {
                        chk[ny][nx][cur_possible+1] = true;
                        deq.addLast(new int[]{ny, nx, cur_possible+1, cur_dist+1});
                    }
                }

                if (MAP[ny][nx] == 0) {
                    if(!chk[ny][nx][cur_possible]){
                        chk[ny][nx][cur_possible] = true;
                        deq.addLast(new int[]{ny, nx, cur_possible, cur_dist+1});
                    }
                }

            }
        }

        return ((ret==INF) ? -1 : ret);
    }

    static boolean isOutside(int y, int x, int N, int M){
        return (0>y || 0>x || y>=N || x>=M);
    }
}


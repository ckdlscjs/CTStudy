package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem301 {

    static int[][] board;
    public static void main(String[] args)
            throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NMK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMK[0];
        int M = NMK[1];
        int K = NMK[2];

        board = new int[N][M];

        for(int i = 0;i<N;i++){
            String st = bf.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = (st.charAt(j) == '0') ? 0 : 1;
            }
        }
        System.out.println(BFS(N,M,K));
    }

    static int BFS(int N, int M, int K){

        // day - night
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        boolean[][][] chk = new boolean[N][M][K+1];
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[]{0,0,0}); // cur_y, cur_x, possible, cnt
        chk[0][0][0] = true;
        int day = 0;
        // day? -> night?
        // distance +=1 in que
        // how about
        int distance = 0;
        while(!que.isEmpty()){
            int queSize = que.size();
            for(int k = 0; k<queSize; k++){
                int[] cur = que.poll();
                int y = cur[0];
                int x = cur[1];
                int possible = cur[2];
                if(y==(N-1) && x==(M-1)){
                    return distance+1;
                }

                for(int i = 0;i<4;i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(isOutside(ny, nx, N, M) || chk[ny][nx][possible]) continue;

                    if(board[ny][nx]==0){
                        if(!chk[ny][nx][possible]){
                            chk[ny][nx][possible] = true;
                            que.add(new int[]{ny,nx, possible});
                        }
                    }else{
                        if(day%2==0){ // 1
                            if(possible<K && !chk[ny][nx][possible+1]){
                                chk[ny][nx][possible+1] = true;
                                que.add(new int[]{ny,nx, possible+1});
                            }
                        }else{
                            que.add(new int[]{y,x,possible}); // 추가
                        }
                    }
                }
            }
            day = (day+1)%2;
            distance++;
        }

        // for(int[] tmp : que){
        //     System.out.println(Arrays.toString(tmp));
        // }
        // System.out.println("dis " + distance);
        return -1;
    }


    static boolean isOutside(int y, int x, int N, int M){
        return (0>y || 0>x || y>=N || x>=M);
    }
}


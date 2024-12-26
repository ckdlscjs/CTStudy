package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem289 {
    static int MAP[][];
    static ArrayDeque<int[]> clouds = new ArrayDeque<>();
    static ArrayList<int[]> cloudOrders = new ArrayList<>();
    static int[] dy = { 0,  -1, -1, -1, 0, 1, 1,  1};
    static int[] dx = {-1,  -1,  0,  1, 1, 1, 0, -1};
    static int[] diag = {1, 3, 5, 7};
    static int N;
    static int M;

    public static void main(String[] args)
    throws Exception{
        INPUT();
        DO();
        calcul();
    }

    static void INPUT() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for (int j =0;j<N;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            cloudOrders.add(new int[]{d,s});
        }

    }

    static void DO(){
        // initialize clouds
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        boolean[][] visited = new boolean[N][N];
        // move
        for (int[] order : cloudOrders) {
            for(int i = 0;i<N;i++){
                Arrays.fill(visited[i], false);
            }
            int n = clouds.size();
            int d = order[0];
            int s = order[1];
            for(int j = 0; j<n;j++){
                int[] cloud = clouds.poll();
                int cloudY = cloud[0];
                int cloudX = cloud[1];
                int ny = (cloudY + dy[d] * s) % N;
                if(ny<0) ny += N;
                int nx = (cloudX + dx[d] * s) % N;
                if(nx<0) nx += N; // 음수 예외처리
                MAP[ny][nx]++;
                clouds.add(new int[]{ny,nx});
            } // clouds moves and rains and disappear

            //
            while(!clouds.isEmpty()){ // new place
                int[] cloud = clouds.poll();
                int cloudY = cloud[0];
                int cloudX = cloud[1];
                visited[cloudY][cloudX] = true;
                // 대각선 체크해서
                int cnt = 0;
                for(int j = 0; j<4;j++){ // using diag
                    int ny = (cloudY + dy[diag[j]]);
                    int nx = (cloudX + dx[diag[j]]);
                    if(isOutBound(ny,nx) || MAP[ny][nx]==0) continue;
                    cnt++;
                }
                MAP[cloudY][cloudX] += cnt;
            }

            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    if(visited[i][j]) continue;
                    if (MAP[i][j] >= 2) {
                        MAP[i][j]-=2;
                        clouds.add(new int[]{i,j});
                    }
                }
            }
        }
    }

    static boolean isOutBound(int y, int x){
        return 0>y || y>= N || 0>x || x>= N;
    }

    static void calcul(){
        int ret = 0;
        for (int i = 0;i<N;i++){
            System.out.println(Arrays.toString(MAP[i]));
            for(int j =0;j<N;j++){
                ret+=MAP[i][j];
            }
        }
        System.out.println(ret);
    }

    static void print(){
        for (int i = 0;i<N;i++){
            System.out.println(Arrays.toString(MAP[i]));
        }
    }
}

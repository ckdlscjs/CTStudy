import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem167 { // O(300 * 300 )
    
    static int[][] MAP;
    static int[][] delete;
    static boolean[][] chk;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        int N = NM[0];
        int M = NM[1];

        MAP = new int[N][M];
        delete = new int[N][M];
        chk = new boolean[N][M];

        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 

        // 0 false - true 로 물 잠기게 해서 false를 체크해서 영역이 2개가 되게 하는 
        int time = 0;
        while(true){

            for(int i =0;i<N;i++){
                Arrays.fill(chk[i], false);
            } 
            // water 
            int cnt = 0;
            for(int i = 0;i<N;i++){
                for (int j = 0; j < M; j++) {
                    if(!chk[i][j] && MAP[i][j] >0){
                        DFS(N, M, i,j);
                        cnt++;
                    }
                }
            }
            if(cnt>=2) {
                System.out.println(time);
                break;
            }
            

            if(waterInvade(N, M)){
                System.out.println(0);
                break;
            }
            time++;
            // System.out.println();
            // for(int i=0;i<N;i++){
            //     for(int j = 0;j<M;j++){
            //         System.out.print(MAP[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        return;
    }

    static boolean waterInvade(int N, int M){

        int zeros = 0;
        for(int i = 1;i<N-1;i++){
            for (int j = 1; j < M -1; j++) {
                if(MAP[i][j] == 0) {
                    zeros++;
                }
                int cnt = 0;
                for(int k =0;k<4;k++){
                    int ny = i+dy[k];
                    int nx = j+dx[k];
                    if(MAP[ny][nx]==0){
                        cnt++;
                    }
                }
                delete[i][j] = cnt;
            }
        }

        for(int i = 0;i<N;i++){
            for(int j= 0;j<M;j++){
                if(delete[i][j] >0){
                    MAP[i][j] -= delete[i][j];
                    if(MAP[i][j]<0){
                        MAP[i][j] = 0;
                    }
                }
            }
        }
        int area = (N-2) * (M-2);
 
        if(area == zeros){
            return true;
        }
        return false;
    }

    static void DFS(int N, int M, int i, int j){

        if(isOutside(N, M, i, j) || chk[i][j] || MAP[i][j]<=0){
            return;
        }
        chk[i][j] = true;

        DFS(N, M, i-1,j);
        DFS(N, M, i,j-1);
        DFS(N, M, i+1,j);
        DFS(N, M, i,j+1);
        return;
    }

    static boolean isOutside(int N, int M, int i, int j){
        return (0>i || 0>j || i>=N || j>=M);
    }
}

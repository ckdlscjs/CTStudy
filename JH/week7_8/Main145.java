import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main145  {

    static int[][] board = new int[101][101];
    static boolean[][] chk = new boolean[101][101];
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = -1;
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j= 0 ;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                M = Math.max(board[i][j], M);
            }
        }


        int ret = 0;
        for(int height = 0;height<=M;height++){
            for(int i = 0;i<=N;i++){
                Arrays.fill(chk[i], false);
            }    
            for(int i = 0;i<N;i++){
                for(int j =0;j<N;j++){
                    if(board[i][j]>height){
                        chk[i][j] = true;
                    }
                }
            }

            int cnt = 0; 
            for(int i=0;i<N;i++){
                for(int j= 0;j<N;j++){
                    if(chk[i][j] && board[i][j] > height){
                        cnt++;
                        dfs(i,j, height, N);
                        // print(N);
                    }
                }
            }
            // System.out.println(cnt + " " + height);
            ret = Math.max(ret, cnt);
        }
        System.out.println(ret);
    }

    static void print(int N){
        System.out.println();
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                System.out.print(chk[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void dfs(int i, int j, int height, int N){
        // if (isOutside(i,j, N) || chk[i][j] || board[i][j]>height) return;
        chk[i][j] = false;
        for(int k =0;k<4;k++){
            int ny = i + dy[k];
            int nx = j + dx[k];
            if(isOutside(ny, nx, N)) continue;
            if(!chk[ny][nx]) continue;
            
            if(board[ny][nx]>height){
                dfs(ny,nx,height, N);
            }
        }
    }

    static boolean isOutside(int y, int x, int N){
        return (0>y || 0>x || y>=N || x>=N);
    }
}

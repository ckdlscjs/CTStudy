import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main170 {

    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        dp = new int[N][N];
        for(int i = 0;i<N;i++){
            Arrays.fill(dp[i], 0);
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<=i;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = board[0][0];
        for(int i = 1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][0] = dp[i-1][0] + board[i][0];
                }
                else if(j==i){
                    dp[i][i] = dp[i-1][i-1] + board[i][i];
                }else{
                    int tmp = Math.max(dp[i-1][j-1] + board[i][j], dp[i-1][j] + board[i][j]);
                    dp[i][j] = tmp;
                }
            }
        }

        int M = -1;
        for(int i = 0;i<N;i++){
            M = Math.max(M,dp[N-1][i]);
        }
        System.out.println(M);
    }
}

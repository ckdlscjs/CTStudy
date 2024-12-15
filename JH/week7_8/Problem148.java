import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem148 {

    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dp = new int[N][3];
        board = new int[N][3];

        for(int i = 0;i<N;i++){
            Arrays.fill(dp[i], 1000*1001);
        }

        StringTokenizer st;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<3;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0;i<3;i++){
            dp[0][i] = board[0][i];
        }
        
        // 2번째
        for(int i = 0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j) continue;
                dp[1][i] = Math.min(dp[1][i], dp[0][j] + board[1][i]);
            }
        }



        for(int row = 2; row<N; row++){
            // i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    if(i==j) continue;
                    dp[row][i] = Math.min(  dp[row-1][j] + board[row][i],
                                        dp[row][i]);
                }
            }
        }
        
        int M = 1000*1001;
        for(int i = 0;i<3;i++){
            M = Math.min(dp[N-1][i],M);
        }
        System.out.println(M);
    }
}

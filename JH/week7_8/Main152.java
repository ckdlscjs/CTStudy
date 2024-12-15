import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main152  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int INF = (int) Math.pow(10, 9);

        int[][] dp = new int[N+1][10];

        for(int i = 1;i<10;i++){
            dp[1][i] = 1;
        }

        // dp의 정의 n 길이에서 i로 끝나는 계단수 
        for(int i = 2;i<=N;i++){
            for(int j = 0;j<10;j++){
                if(j==0){
                    dp[i][0] = dp[i-1][1]; 
                }        
                else if(j==9){
                    dp[i][j] = dp[i-1][j-1]; 
                }else{
                    dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % INF;
                }
            }
        }        

        int ret = 0;
        // System.out.println(Arrays.toString(dp[N-1]));
        for(int i = 0;i<10;i++){
            ret = (ret + dp[N][i]) % INF;
        }
        System.out.println(ret);
    }
}

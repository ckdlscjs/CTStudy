package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem293 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 0; i <10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { // 10 10 N = 10^6
            for(int j = 0;j<10;j++){
                for(int k = 0;k<=j;k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k])%10007;
                }
            }
        }
        System.out.println(Arrays.stream(dp[N]).sum()%10007);
    }
}

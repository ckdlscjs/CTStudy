package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem295 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N+1];
        // ?? dp[3] = ?
        if (2>=N) {
            System.out.println((N==1)?  1 : 2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746; // dp[i-1] + "1" + dp[i-2] + "00"
        }
        System.out.println(dp[N]%15746);
    }
}
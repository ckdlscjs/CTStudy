package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem298 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1;i*i<=N; i++) {
            dp[i*i]++;
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i*i <= N; i++) { // O(300)
            for (int j = i*i;j <= N; j++) { // Nlog(N)
                dp[j] = Math.min(dp[j], dp[j-i*i]+1);
            }
        }
        System.out.println(dp[N]);
    }
}

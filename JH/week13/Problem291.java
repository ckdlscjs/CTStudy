package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem291 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N+1];
        int[] dp = new int[N+1];
        // 1 2 3 4 5
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int k = 1;k<=N;k++){
            for (int i = 1; i<= k; i++) { // k = 2, i = 0, i = 1
                dp[k] = Math.max(dp[k], dp[k - i] + nums[i]);
            }
        }
        System.out.println(dp[N]);
    }
}

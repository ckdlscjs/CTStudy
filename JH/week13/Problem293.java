package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Problem293 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[100_000 + 1];
        int[] nums = new int[N + 1];// 필요 없을 수도 있음.
        for (int i = 1; i <= N; i++) {
            int coin = Integer.parseInt(bf.readLine());
            nums[i - 1] = coin;
        }

        dp[0] = 1;


        for (int j = 0; j < N; j++) {
            int coin = nums[j];
            for (int i = coin; i <= M; i++) {
                dp[i] += dp[i-coin];
            }
        }


        System.out.println(dp[M]);
    }
}

package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem312 {
    static int[] nums;
    static int[] dp = new int[10001];
    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int j = nums[0];j<=limit;j++){
            if(dp[j] == 100001 && dp[j-nums[0]] != 100001)dp[j] = dp[j-nums[0]]+1;
            for (int i = 0; i < n; i++) {
                if(j-nums[i]>=0){ dp[j] = Math.min(dp[j-nums[i]]+1, dp[j]);}
                else{ break; }
            }
        }
        System.out.println( (dp[limit]==100001) ? -1 : dp[limit]);
    }
}

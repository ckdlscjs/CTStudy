package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem300 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            int n = Integer.parseInt(bf.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] dp = new int[10_000 + 1];

            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(bf.readLine());
            dp[0] = 1;
            for(int i = 0;i<n;i++){
                for(int j = nums[i];j<=m;j++){
                    dp[j] += dp[j-nums[i]];
                }
            }
            sb.append(dp[m]).append('\n');
        }
        System.out.print(sb);
    }
}

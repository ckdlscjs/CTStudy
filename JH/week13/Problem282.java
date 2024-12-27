package week13;
import java.io.*;
import java.util.*;

public class Problem282 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(bf.readLine());
        long[] prefix = new long[N+1];

        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            prefix[i+1] = prefix[i] + nums[i];
        }


        long[] dp = new long[N+1];
        dp[0] = 0;


        int start = 0;
        for(int end = 1;end<=N;end++){
            dp[end] = Math.max(dp[end - 1], dp[end]);
            while(start<end && ((prefix[end]-prefix[start])>=K)){ // start에는 nums[start]이 빠짐
                long gain = prefix[end] - prefix[start] - K;
                // 만약에 end에 대해서
                // start =0를 한다면 이건 중복해서 계산하는 것
                dp[end] = Math.max(dp[end], dp[start] + gain);
                start++;
            }

            if (end < N) {
                dp[end+1] = Math.max(dp[end], dp[end + 1]);
            }
        }
        System.out.println(dp[N]);


    }
}

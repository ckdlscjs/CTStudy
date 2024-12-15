import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main156 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N+1];
        int[] dp = new int[N+1];

        // 증가하는 부분 수열 중 합 max 
        // dp[i] 정의는 증가하는 부분수열 중 합이 제일 큰 것
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = nums[0];
        for(int i =1;i<N;i++){
            int M = 0;
            // int idx = i;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]>M){
                    M = Math.max(dp[j],M);
 
                    // idx = j;
                }
            }
            dp[i] = M + nums[i];

        }
        int M = -1;
        for(int i = 0;i<N;i++){
            M = Math.max(M, dp[i]);
        }
        System.out.println(M);
    }
}

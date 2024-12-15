import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem144  {
    public static void main(String[] args) 
    throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N+1];
        int[] dp = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -231239213);
        for(int i = 1;i<=N;i++){
            int nxtVal = dp[i-1]+nums[i-1];
            if(nxtVal < nums[i-1]){
                dp[i] = nums[i-1];
            }else{
                dp[i] = nxtVal;
            }
        }

        int M = -231239213; 
        for(int i = 1;i<=N;i++){
            M = Math.max(M, dp[i]);
        }
        System.out.println(M);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem172 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
 
        // dp의 정의는 현재 위치에서 만들 수 있는  
        // 증가하는 수열의 최대길이다. 
        dp[0] = 1; // default값 세팅을 안해서 틀림
        
        for(int i = 1;i<N;i++){
            int M = 0;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]>M){
                    M = dp[j];
                }
            }
            dp[i] = M + 1;
        }

        int M = -1;
        for(int i = 0;i<N;i++){
            M = Math.max(dp[i], M);
        }
 
        System.out.println(M);

    }
}

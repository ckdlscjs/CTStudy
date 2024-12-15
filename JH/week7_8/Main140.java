import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main140{
    static int[] nums = new int[301];
    static int[] dp = new int[301];

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 1;i<=N;i++){
            int T = Integer.parseInt(bf.readLine());
            nums[i] = T;
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = nums[1] + nums[2];

        for(int i =3;i<=N;i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i-1] + nums[i]);
        }
        
        System.out.println(dp[N]);
    }

 
}

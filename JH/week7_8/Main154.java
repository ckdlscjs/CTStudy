import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main154  {
    static final int MOD = 10007;
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=N;i++){
            dp[i] = 2*dp[i-2];
            dp[i] += dp[i-1];
            dp[i] %= MOD;
        }
        System.out.println(dp[N]);
    }
}
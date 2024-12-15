import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main137  {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[1000+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2])%(10007);
        }
        System.out.println(dp[N]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem160 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        long[] dp = new long[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 4;
        dp[7] = 5;
        dp[8] = 7;
        dp[9] = 9;

        for(int i = 10;i<=100;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        while(T-->0){
            int N = Integer.parseInt(bf.readLine());
            System.out.println(dp[N-1]);
        }
    }
}

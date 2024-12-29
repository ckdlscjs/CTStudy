import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem132 {
    
    static int[] dp = new int[1000001];

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Arrays.fill(dp, dp.length);
        dp[0] = 0;
        dp[1] = 0;
        System.out.println(solve(N, dp.length));
    }

    static int solve(int n, int limit){
        
        if(dp[n]!=limit) return dp[n];

        int tmp = 1 + Math.min(solve(n/2, limit)+n%2, solve(n/3, limit)+n%3);
        // log(N)
        dp[n] = tmp;
        return tmp;
    }
}
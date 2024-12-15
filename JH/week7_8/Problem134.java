import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem134 {
    
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[] dp = new int[12+1];
        dp[1]= 1;
        dp[2] = 2; // 1+1
        dp[3]= 4; // 3,2+1,1+2, 1+1+1
        
        for(int i =4;i<=11;i++){
            dp[i] += dp[i-1]; // 1
            dp[i] += dp[i-2]; // 2
            dp[i] += dp[i-3]; // 3
        }
        while(T-->0){
            int N = Integer.parseInt(bf.readLine());
            System.out.println(dp[N]);
        }
    }
}
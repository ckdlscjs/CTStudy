package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem315 {
    static int[] dp;
    static int[] moves = {1, 3, 4};
    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[1000 + 1];
        Arrays.fill(dp, -1);
        dp[1] = 0; // 0 -> 상근
        dp[3] = 0;
        dp[4] = 0;
        int res = DFS(N);
        System.out.println( (res == 0)? "SK" : "CY");
    }

    private static int DFS(int n) {

        if(dp[n]!=-1) return dp[n];

        for (int move : moves) {
            int nxt = n - move;
            if(nxt>=0){
                if(DFS(nxt)==1){
                    dp[n] = 0;
                    return dp[n];
                }
            }
        }
        dp[n] = 1;
        return dp[n];
    }
}

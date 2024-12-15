import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem150  {

    static int[] parent;
    static int[] dp;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        parent = new int[1000000+2];
        dp = new int[1000000+2];
        INF = 2*N;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        dp[1] = 0;
        parent[1] = 0;

        for(int i = 2;i<=N;i++){
            dp[i] = dp[i-1] + 1;
            parent[i] = i-1;
            if(i%3==0){
                if(dp[i]>dp[i/3]+1){
                    dp[i] = dp[i/3] + 1;
                    parent[i] = i/3;
                }
            }
            if(i%2==0){
                if(dp[i]>dp[i/2]+1){
                    dp[i] = dp[i/2] + 1;
                    parent[i] = i/2;
                }
            }

        }


        int cur = N;
        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        while(cur!=0){
            sb.append(cur + " ");
            cur = parent[cur];
        }
        System.out.println(sb);
    }
 
}

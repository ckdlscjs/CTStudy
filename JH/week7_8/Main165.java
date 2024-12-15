import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main165  {
 
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // dp의 정의 : 현재 날까지의 이익의 최댓값 
        int[] dp = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            T[i+1] = Integer.parseInt(st.nextToken());
            P[i+1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;i<=N;i++){
                // 상담을 선택하는 경우, 선택하지 않는 경우 
                dp[i+1] = Math.max(dp[i], dp[i+1]);

                if(i+T[i]<=N+1){ // 선택하는 경우 
                    dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
                }
        }
 
        System.out.println(dp[N+1]);
    }
}

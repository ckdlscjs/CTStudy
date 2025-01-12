package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem316 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N][N];

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][N+1];

        for(int i = 1;i<=N;i++){
            dp[i][1] = MAP[i-1][0];
            for(int j = 2;j<=N;j++){
                dp[i][j] = dp[i][j-1] + MAP[i-1][j-1];
            }
        }

        for (int j = 1; j <=N; j++) {
            for(int i = 2;i<=N;i++){
                dp[i][j] += dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0;j<M;j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sb.append(dp[c][d] - dp[c][b - 1] - dp[a - 1][d] + dp[a - 1][b - 1]).append('\n');
        }

        //
        //
        //  (a-1,b-1)        (a-1, d)
       //            (a,b)
        //  (c,b-1)          (c,d)

        System.out.println(sb);
    }
}

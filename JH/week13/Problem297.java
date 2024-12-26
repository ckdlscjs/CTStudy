package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem297 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while(true){
            int N = Integer.parseInt(bf.readLine());
            if(N==0)break;

            int[][] arr = new int[N][3];
            int[][] dp = new int[N][3];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j = 0;j<3;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0;i<N;i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE/2);
            }

            dp[0][1] = arr[0][1];
            dp[0][2] = dp[0][1] + arr[0][2];

            for (int i = 1;i<N;i++){
                dp[i][0] = Math.min(dp[i-1][0]+arr[i][0],
                        dp[i-1][1]+arr[i][0]);

                int before = Math.min(Math.min(dp[i-1][0], dp[i-1][1]),dp[i-1][2]);
                dp[i][1] = Math.min(before, dp[i][0]) + arr[i][1];


                dp[i][2] = Math.min(
                        Math.min(dp[i - 1][1], dp[i-1][2]),
                        dp[i][1] )
                        + arr[i][2];
            }

            System.out.println(++cnt + ". " + dp[N-1][1]);
        }
    }
}

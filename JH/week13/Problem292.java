package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem292 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-->0) {
            int N = Integer.parseInt(bf.readLine());
            int[][] nums = new int[2][N];
            int[][] dp = new int[2][N];
            for(int i = 0;i<2;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j = 0;j<N;j++){
                    nums[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = nums[0][0];
            dp[1][0] = nums[1][0];
            for(int i = 1;i<N;i++){
                dp[0][i] = Math.max(dp[1][i - 1] + nums[0][i], dp[0][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1] + nums[1][i], dp[1][i - 1]); // 스티커 선택, 선택하지 않음
            }
            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append('\n');
            // 부분 구조가 뭘
        }
        System.out.print(sb);
    }
}

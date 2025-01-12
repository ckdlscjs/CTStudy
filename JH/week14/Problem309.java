package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem309 {
    public static void main(String[] args)
    throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[N][N];
        // dp의 정의 i, j -> makes a palindrome?

        // sequential relation
        // palindrome
        for (int diff = 0;  diff < N; diff++) { // diff
            for (int start = 0; start + diff < N; start++) {
                int end = start + diff;

                if (start == end) {
                    dp[start][end] = 1;
                    continue;
                }

                if (start + 1 == end) {
                    if (nums[start] == nums[end]) {
                        dp[start][end] = 1;
                    }else{
                        dp[start][end] = 0;
                    }
                    continue;
                }

                if (nums[start] == nums[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                } else{
                    dp[start][end] = 0;
                }
            }
        }


        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dp[a-1][b-1]).append('\n');
        }
        System.out.println(sb.toString());
    }
}

//  x 1 2 1 3 1 2 1
//  1 1 1 1 1 1 1 1
//  2 1
//  1 1
//  3 1
//  1 1
//  2 1         2
//  1 1

// 1 2 1 3 1 2 1
//
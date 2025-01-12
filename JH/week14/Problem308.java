package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem308 {
    static int[][] MAP;
    static int[][] DP;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        MAP = new int[n][m];
        DP = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                MAP[i][j] = s.charAt(j) - '0';
                DP[i][j] = s.charAt(j) - '0';
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (MAP[i][j] == 1 && MAP[i][j - 1] == 1 && MAP[i - 1][j] == 1 && MAP[i-1][j-1] == 1) {
                    DP[i][j] = Math.min(Math.min(DP[i-1][j], DP[i][j-1]), DP[i-1][j-1])+1;
                }
            }
        }

        int ret = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ret = Math.max(ret, DP[i][j]);
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ret * ret);
    }
}

// 111
// 11
// 1
//

// 1111
// 111
// 111
// 1
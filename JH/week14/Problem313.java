//package week14;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Problem313 {
//    public static void main(String[] args)
//    throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        long[] dp = new long[30 + 2];
//        dp[0] = 1;
//        dp[2] = 3;
//        long tmp = dp[0];
//        for (int i = 4; i <= N; i+=2) {
//            dp[i] += 3L*dp[i - 2] + 2*tmp;
//            tmp += dp[i-2];
//        }
//        System.out.println(dp[N]);
//    }
//}


package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem313 {
    static long[][] matrix = {{3,2}, {1,1}};
    static long[][] ret = {{1}, {0}};
    static int[] bits = new int[65];
    static int mod = (int) Math.pow(10, 6);

    static void mult(){
        long tmp1, tmp2, tmp3, tmp4;
        tmp1 = matrix[0][0];
        tmp2 = matrix[0][1];
        tmp3 = matrix[1][0];
        tmp4 = matrix[1][1];
        matrix[0][0] = (tmp1 * tmp1 + tmp2 * tmp3);
        matrix[0][1] = (tmp1 * tmp2 + tmp2 * tmp4);
        matrix[1][0] = (tmp3 * tmp1 + tmp4 * tmp3);
        matrix[1][1] = (tmp3 * tmp2 + tmp4 * tmp4);
    }

    static void result(){
        long tmp1, tmp2;
        tmp1 = ret[0][0];
        tmp2 = ret[1][0];
        ret[0][0] = matrix[0][0] * tmp1 + matrix[0][1] * tmp2;
        ret[1][0] = matrix[1][0] * tmp1 + matrix[1][1] * tmp2;
    }

    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int res = Integer.parseInt(bf.readLine());
        int i = 0;
        if (res % 2 == 1) {
            System.out.println(0);
            return;
        }

        res /= 2;
        int cnt = 0;
        while (i <= 64) {
            bits[i] = ((res & (1 << i)) >> i);
            i++;
            if ((1 << i) > res) {
                break;
            }
        }
        for(int j = 0;j<=64;j++){
            if (bits[j] == 1) {
                result();
            }
            mult();
        }
        System.out.println(ret[0][0]);

    }
}
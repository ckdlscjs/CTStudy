package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem295 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // dp[1] - dp[0] = dp[-1]
        long[] dp = new long[1_000_000 + 1];
        // offset 1_000_000
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 1_000_000; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000L;
        }

        int absN = Math.abs(N);
        if(N<0){
            if(absN%2==0){
                System.out.println(-1);
                System.out.println(dp[-N]);
            }else{
                System.out.println(1);
                System.out.println(dp[-N]);
            }
        }else if(N==0){
            System.out.println(0);
            System.out.println(dp[N]);
        }
        else{ // N>0
            System.out.println(1);
            System.out.println(dp[N]);
        }
    }
    // 증명 f(-1) = f(1) - f(0) , f(1) > f(0) => f(-1) >0
    // f(-2) = f(0) - f(-1) = -f(-1) < 0  f(0) = f(-1) + f(-2)
    // f(-1) = f(-2) + f(-3) => f(-3) = f(-1) - f(-2) > 0
    // f(-2) = f(-3) + f(-4) => f(-4) = f(-2) - f(-3) < 0
    // if N % 2 ==0 -> by assumption hypothesis
    // f(0) = 1>0, f(1) > 1 ..
    // f(-N) < 0
    // f(-N+1) = f(-N) + f(-N-1)
    // <=> f(-N-1) = f(-N+1) - f(-N)
    // by assumption hypothesis N-1%2==1 -> f(-N+1) > 0, f(-N) < 0
    // f(-N-1) > 0
    // likewise every odd N, f(-N-1) < 0
}

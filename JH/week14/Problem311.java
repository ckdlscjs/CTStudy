package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem311 {
    private static final int mod = 1000000;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine(); // 암호 숫자로 제공되는데 a -> 1, z -> 26

        if (s.length() == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[s.length()+1];

        dp[0] = 1; // 암호 길이에 따른 경우의 수
        dp[1] = 1; // 암호 길이에 따른 경우의 수
        for(int i = 2;i<=s.length();i++) {
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            int currentDigit = s.charAt(i-1) - '0';
            if(currentDigit > 0) dp[i] = (dp[i] + dp[i-1] ) % mod;
            if(10 <= twoDigit && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
            // dp : ?
        }

        System.out.println(dp[s.length()] % mod);
    }
}

// 25 114
// 123

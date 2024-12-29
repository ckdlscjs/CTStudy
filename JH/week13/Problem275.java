package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem275 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bf.readLine());
        long K = Long.parseLong(bf.readLine());
        long left = 1;
        long right = N * N;
        long ans = 0;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count >= K) {
                right = mid;
            } else {
                left = mid;
            }
        }

        long count = 0;
        for (long i = 1; i <= N; i++) {
            count += Math.min(left / i, N);
        }
        if (count >= K) {
            System.out.println(left);
        }else{
            System.out.println(right);
        }
    }
}

// 4
// 1 2 3 4
// 2 4 6 8
// 3 6 9 12
// 4 8 12 16
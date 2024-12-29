package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem247 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] nums =  new long[N];

        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(bf.readLine());
        }

        Arrays.sort(nums);

        long left = 1;
        long right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long t = 0;
            for (int i = 0; i < N; i++) {
                t +=  (nums[i]/mid);
            }
            if (t >= K) { // 초과이므로 줄여야 함 ->
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
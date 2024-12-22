
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem252{
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[m];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Arrays.sort(nums);

        long left = 0;
        long right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(mid==0) {
                System.out.println(0);
                return;
            }
            long cnt = 0;
            for (int i = 0; i < m; i++) {
                 cnt += nums[i] / mid;
            }

            if (cnt >= n) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(right == Integer.MAX_VALUE ? 0 : right);
    }
}
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem267 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int left = 0, right = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right && right < n) {
            sum += nums[right++];
            while (sum >= m && left <n) {
                min = Math.min(min, right-left);
                // 여기서 원래 [left, right]는 right - left + 1인데
                // right-left+1가 아니라 right-left인 이유는
                // 앞서 증감연산에 의해 right+1가 되었기 때문에 right - left가 사실은 right+1 - left다.
                sum -= nums[left++];
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
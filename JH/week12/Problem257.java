
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem257 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int M = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int val = leftBinarySearch(nums, -num);
            int[] candidates = {val - 1, val};
            for(int idx : candidates) {
                if (0 <= idx && idx < n && idx != i) {
                    int k = Math.abs(nums[idx] + num);
                    int sum = nums[idx] + num;
                    if (k < M) {
                        M = k;
                        ret = sum;
                    }
                }
            }
        }
        System.out.println(ret);
    }

    private static int leftBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
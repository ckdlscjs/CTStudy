
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem253 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int ret = Integer.MAX_VALUE;
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE/2;
        ans[1] = Integer.MAX_VALUE/2;

        for (int i = 0; i < N; i++) {
            int a = nums[i];
            int idx = leftBinarySearch(nums, a * (-1));

            int[] candidates = {idx - 1, idx};

            for (int index : candidates) {
                if (index >= 0 && index < N && index != i) {
                    int b = nums[index];
                    int sum = a + b;
                    if (Math.abs(sum) < ret) {
                        ret = Math.abs(sum);
                        if (a < b) {
                            ans[0]= a;
                            ans[1]= b;
                        }
                        else{
                            ans[0] = b;
                            ans[1] = a;
                        }
                    }

                }
            }


        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int leftBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
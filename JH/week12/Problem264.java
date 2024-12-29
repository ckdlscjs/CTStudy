package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem264 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int ret = Integer.MAX_VALUE;
        while (left<=right && right < N) {
            int diff = nums[right] - nums[left];
            if (diff >= M) {
                ret = Math.min(ret, diff);
                left++;
            }else{
                right++;
            }
        }
        System.out.println(ret);

    }
}
package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem276 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            right += nums[i];
            left = Math.max(left, nums[i]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, m)) {
                right = mid -1; // 참인 것 중 가장 오른쪽에 해당하는 값
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
    /**
     * 배열을 m개의 부분 배열로 분할할 때, 각 부분 배열의 합이 maxSum을 초과하지 않는지 확인하는 함수
     *
     * @param nums    배열
     * @param maxSum  각 부분 배열의 최대 합
     * @param m       분할의 개수
     * @return        분할 가능 여부
     */

    private static boolean check(int[] nums, int maxSum, int m) {

        int count = 1;
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if(score + nums[i] >= maxSum) {
                count++;
                score = 0;
                if (count >  m) {
                    return false;
                }
            }
            else{
                score += nums[i];
            }
        }
        return true;
    }
}

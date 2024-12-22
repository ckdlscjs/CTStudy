
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem258 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i <N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int cnt = 0;
        for(int i = 0;i<N;i++){
            int k = nums[i];
            int left = 0;
            int right = N-1;
            while (left < right) {

                if (left == i) {
                    left++;
                    continue;
                }
                else if (right == i) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == k) {
                    System.out.println(left +   " " +  right);
                    cnt++;
                    break;
                }
                else if (sum < k) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
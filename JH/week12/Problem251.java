
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem251 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int [N];
        int left = 0;
        int right = Integer.MIN_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, nums[i]);
        }


        while(left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                if(nums[i]>mid) cnt += (nums[i] - mid);
            }

            if (cnt >= K) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);



    }
}
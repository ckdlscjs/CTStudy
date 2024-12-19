package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem269 {
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

        int sum = 0, right = 0, cnt = 0;
        for(int left = 0;left<n;left++){

            while (sum < m && right< n) {
                sum += nums[right++];
            }

            if (sum == m) {
                cnt++;
            }
            sum-=nums[left];
        }

        System.out.println(cnt);

    }
}
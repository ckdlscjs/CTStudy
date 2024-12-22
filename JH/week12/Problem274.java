package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem274 {
    public static void main(String[] args)
            throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int left = 0; left < N; left++) { // 0 1 2 3
            for (int right = left+1; right < N; right++) {
                int firstSnow = nums[right] + nums[left];
                if (right - left >= 3) {
                    int l = left + 1;
                    int r = right - 1;
                    while (l < r) {
                        int secondSnow = nums[r] + nums[l];
                        minDiff = Math.min(minDiff, Math.abs(secondSnow - firstSnow));
                        if (secondSnow > firstSnow) {
                            r--;
                        } else {
                            if(secondSnow==firstSnow){
                                System.out.println(0);
                                return;
                            }
                            l++;
                        }
                    }
                    minDiff = Math.min(minDiff, (nums[right] - nums[left]));
                }
            }
        }
        System.out.println(minDiff);
        
    }
}
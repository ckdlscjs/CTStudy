package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Problem264 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());

        int left = 1;
        int right = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        int ret = 0;
        while(left<=right){
            int mid = left + (right - left)/2;
            int cnt = 0;
            for (int i = 0;i<N;i++){
                if (mid >= nums[i]) {
                    cnt+=nums[i];
                }else{
                    cnt+=mid;
                }
            }

            if (cnt > T) {
                right = mid - 1;
            }else{ //
                ret = Math.max(ret, mid);
                left = mid + 1;
            }
        }
        System.out.println(ret);
    }
}
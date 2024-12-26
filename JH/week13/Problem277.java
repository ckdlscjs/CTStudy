package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem277 {

    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] nums = new int[K+2];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        nums[K] = 0;
        nums[K+1] = L;
        Arrays.sort(nums);
        int left = 0;
        int right = L;
        int result = L;
        int answerPlace = 0;
        while(left <= right) {
            int firstPlace =  0;
            int mid = (left + right) / 2;

            int cnt = 0;
            int sum = 0;

            for(int i = K; i>=0; i--) {
                sum += nums[i+1]- nums[i];
                if(sum > mid) {
                    sum = nums[i+1] - nums[i];
                    cnt++;
                    firstPlace = nums[i + 1];
                    if(sum>mid) {
                        cnt = C+1;
                        break;
                    }
                }

            }

            if (cnt<=C) {
                result = Math.min(result,mid);
                answerPlace = (cnt < C) ? nums[1] : firstPlace;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(result + " " + answerPlace);
    }
}
// 0 1 2 5
//  1 1 3

//2 2 10000
//1 1000000000
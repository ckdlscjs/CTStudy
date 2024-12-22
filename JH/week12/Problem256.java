package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem256 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i+1;
            int right = N-1;
            while (left < right) {
                long sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    if (nums[left] == nums[right]) {
                        long c = right - left+1;
                        count += (c * (c - 1)) / 2;
                        break;
                    }else{
                        int leftVal = nums[left];
                        int rightVal = nums[right];
                        int leftConunt = 0;
                        int rightCont = 0;

                        while(left < right && nums[left] == leftVal){
                            leftConunt++;
                            left++;
                        }
                        while(left <= right && nums[right] == rightVal){
                            rightCont++;
                            right--;
                        }
                        count += (leftConunt * rightCont);
                    }
                } else if (sum > 0) {
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        System.out.println(count);
    }


}
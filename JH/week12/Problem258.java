
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem258 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        long M = Integer.MAX_VALUE*3L;
        long[] ret = {0, 0, 0};
        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;
            if(M==0) break;
            while (left < right) {
                long sum = nums[left] + nums[right] + nums[i];
                long abs = Math.abs(nums[left]+nums[right] + nums[i]);
                if (abs < M) {
                    M = abs;
                    ret[0] = nums[left];
                    ret[1] = nums[right];
                    ret[2] = nums[i];
                }
                if(sum==0) break;
                if(sum>0){
                    right--;
                }else{
                    left++;
                }

            }
        }
        Arrays.sort(ret);
        System.out.println(Arrays.stream(ret).mapToObj(s -> s + " ").collect(Collectors.joining()));
    }

    private static int leftBinarySearch(long[] nums, long target, int low, int high) {
        int start = low;
        int end = high;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}
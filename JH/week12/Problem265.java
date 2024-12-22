package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem265 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+2];
        st = new StringTokenizer(bf.readLine());
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        nums[n+1] = k;
        Arrays.sort(nums);
        // 휴게소의 위치 1<= x <= k-1
        // n+m < k
        int left = 1;
        int right = k;

        int ans = k;


        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i = 1;i<=n+1;i++){
                int gap = nums[i] - nums[i-1];
                if(gap >mid){
                    cnt+=(gap-1)/mid;
                    // 1을 빼는 이유는 dist([a,b]) = b -a - 1
                    // [2,1] 2-1-1 = 0
                }
            }

            if (cnt <= m) { // 부족해서 더 크게
                ans = mid; // 조건에 맞는 경우
                right = mid - 1;
            }else{ // cnt > m := 이 경우는 해당사항 없음
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
    // 첫째 줄에 M개의 휴게소를 짓고 난 후에 휴게소가 없는 구간의 최댓값의 최솟값을 출력한다.

}
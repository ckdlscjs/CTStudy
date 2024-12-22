package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem261 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 공유기의 개수
        int[] nums = new int[n];
        int left = 1;
        int right = 0;
        for (int i = 0;i<n;i++){
            nums[i] = Integer.parseInt(bf.readLine());
            right = Math.max(right,nums[i]);
        }
        Arrays.sort(nums);

        int answer = 0;
        while (left<=right){ // upper binary search 그 조건에서 가장 오른쪽에 해당하는 값 출력
            int mid = left + (right-left)/2; // 현재 거리
            if (canInstall(nums, n, m, mid)) { // 너무 많이 -> 거리 길게 -> left 큰값을
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
        //
    }

    private static boolean canInstall(int[] nums, int n, int m, int dist) {
        int cnt = 1;
        int lastInstall = nums[0];
        for (int i = 1;i<n;i++){
            int distance = nums[i] - lastInstall;
            if (distance >= dist) {
                cnt++;
                lastInstall = nums[i];
            }
        }
        return cnt>=m;
    }
}
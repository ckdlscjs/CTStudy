package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem271 {
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

        int left = 0;
        int right = 0;
        int oddCnt = 0, evenCnt = 0;
        int ret = 0;
        while (right < n) {
            // 현재 숫자가 홀수인 경우 홀수 개수 증가
            if (nums[right] % 2 != 0) {
                oddCnt++;
            }else{
                evenCnt++;
            }

            // 홀수 개수가 K를 초과하면 left를 이동하며 조정
            while (oddCnt > m) {
                if (nums[left] % 2 != 0) {
                    oddCnt--;
                }else{
                    evenCnt--;
                }
                left++;
            }

            // 현재 윈도우 내 짝수 부분 길이 계산
            ret = Math.max(ret, evenCnt);
            right++;
        }
        System.out.println(ret);
    }
}
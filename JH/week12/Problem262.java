
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem262 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] nums = new int[4][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 4; j++) {
                nums[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {
            Arrays.sort(nums[i]);
        }

        int[] arr1 = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr1[idx++] = nums[0][i] + nums[1][j];
            }
        }

        int[] arr2 = new int[N * N];
        int idx2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2[idx2++] = nums[2][i] + nums[3][j];
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long cnt = 0;
        int left = 0;
        int right = arr1.length - 1;

        while (left < arr1.length && right >= 0) {
            long sum = arr1[left] + arr2[right];
            if(sum==0){
                int leftCnt = 0;
                int rightCnt = 0;
                int leftVal = arr1[left];
                while (left < arr1.length && arr1[left] == leftVal) {
                    left++;
                    leftCnt++;
                }

                int rightVal = arr2[right];
                while (right>=0 && arr2[right] == rightVal) {
                    right--;
                    rightCnt++;
                }
                cnt += ((long) leftCnt * rightCnt);
            } else if (sum < 0) {
                left++;
            }else{
                right--;
            }
        }
        System.out.println(cnt);
    }
}

package week12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Problem246 {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write((1+binaryRightSearch(nums, target) - binaryLeftSearch(nums, target)) + " ");
        } // [a,b] := b-a+1, [1,2] := 2-1 + 1
        bw.newLine();
        bw.flush();
        bw.close();
        bf.close();
    }


    static int binaryLeftSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 1 1 2 2 2 2
        //     2
        return left; // 왼쪽 경계
    }


    static int binaryRightSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 1 1 2 2 2 2
        // 0  2->3   5
        //        4->5
        //           5->6 end
        return right; // 오른쪽 경계
    }
}
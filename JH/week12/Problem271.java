
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem271 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] chk = new int[100001];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int currentLen = 0;
        while (right < n) {

            if (chk[nums[right]] < m) {
                chk[nums[right]]++;
                currentLen++;
            }
            else{
                while ((chk[nums[right]] >=m) && (left < n)) {
                    chk[nums[left++]]--;
                    currentLen--;
                }
                chk[nums[right]]++;
                currentLen++;
            }
            maxLen = Math.max(maxLen, currentLen);
            right++;
        }
        System.out.println(maxLen);
    }
}

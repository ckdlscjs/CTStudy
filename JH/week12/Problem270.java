
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem270 {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int cnt = 0;
        for (int left = 0; left < N; left++) {

            while (right < N && !set.contains(nums[right])) {
                set.add(nums[right++]);
            }

            cnt += set.size();
            set.remove(nums[left]);
        }
        System.out.println(cnt);

    }
}
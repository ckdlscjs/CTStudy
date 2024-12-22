package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Problem246 {
    public static void main(String[] args)
            throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashSet<Integer> set = new HashSet<>();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(nums);

        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(nums[i]+nums[j]);
            }
        }
        System.out.println(set);

        outer:
        for (int i = N-1; i >=0; i--) {
            int k = nums[i];
            for (int j = 0; j <N; j++) {
                int target = k - nums[j];
                if (set.contains(target)) {
                    System.out.println(k);
                    break outer;
                }
            }
        }
    }
}
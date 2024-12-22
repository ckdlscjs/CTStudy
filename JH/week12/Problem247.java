package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Problem247 {
    static HashSet<Integer> set = new HashSet<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    static ArrayList<Integer> lst = new ArrayList<>();

    public static void main(String[] args)
            throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                lst.add(nums[i]);
            }
        }

        lst.sort(Integer::compareTo);

        for (int i = 0; i < lst.size(); i++) {
            map.put(lst.get(i), Collections.binarySearch(lst, lst.get(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }
        System.out.println(sb);

    }
}
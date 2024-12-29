package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem270 {
    static int[] dishes = new int[3001];

    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        int currentLen = 0;
        for (int i = 0; i < k; i++) {
            if (dishes[nums[i]] == 0) {
                currentLen++;
            }
            dishes[nums[i]]++;
        }
        int maxLen = currentLen;

        for (int i = 0; i < n; i++) {
            int remove = nums[i];
            int addIdx = nums[(i + k) % n];

            dishes[remove]--;
            if (dishes[remove] == 0) {
                currentLen--;
            }

            if(dishes[addIdx] == 0) {
                currentLen++;
            }

            dishes[addIdx]++;
            maxLen = Math.max(maxLen, currentLen + (dishes[c]>0 ? 0 : 1));
        }

        System.out.println(maxLen);

    }
}
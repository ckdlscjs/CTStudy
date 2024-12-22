import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem181 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] nums = new int[10];
    static boolean[] chk = new boolean[10];
    static int ret = 0;

    public static void main(String[] args)
            throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, 0, n);
        // System.out.println(Arrays.toString(nums));
        solve(0, n, m, 0);
        // System.out.print(sb.toString());
        System.out.println(ret);
    }

    private static void solve(int i, int n, int m, int cnt) {

        // System.out.println(list + " " + cnt);
        if (m == cnt) {
            // for (int num : list) {
            // sb.append(num).append(" ");
            // }
            // sb.append("\n");
            ret++;
            return;
        }

        if (i == n) {
            return;
        }

        for (int k = 0; k < n; k++) {
            if (chk[k])
                continue;
            chk[k] = true;
            list.add(nums[k]);
            solve(k, n, m, cnt + 1);
            list.remove(list.size() - 1);
            chk[k] = false;
        }
    }
}

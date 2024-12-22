import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem186 {
    static int[] nums = new int[9];
    static int[] temps = new int[9];
    static StringBuilder sb = new StringBuilder();
    static boolean[] chk = new boolean[9];
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
        solve(0,  n, m, 0);
        // System.out.print(sb.toString());
		System.out.println(ret);
    }

    private static void solve(int i, int n, int m, int depth) {

//        System.out.println(i + " " + cnt);
        if (m == depth) {
            // for (int k = 0; k < m; k++) {
            //    sb.append(temps[k]).append(" ");
            // }
            // sb.append("\n");
            ret++;
			return;
        }

        for (int j = i; j < n; j++) {
            // 같은 depth에서 같은 숫자 X
            if(j>0 && nums[j] == nums[j-1] && !chk[j-1]) continue;

            if(!chk[j]){
                chk[j] = true;
                temps[depth] = nums[j];
                solve(j+1, n, m, depth+1);
                chk[j] = false;
            }
        }
    }
}


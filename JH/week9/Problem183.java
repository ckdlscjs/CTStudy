import static javax.swing.text.html.HTML.Attribute.N;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem183 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums = new int[10];
    static int[] temps = new int[10];
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
        solve(0, n, m, 0);
        // System.out.println(sb.toString());
		System.out.println(ret);
    }

    private static void solve(int i, int n, int m, int cnt) {
        if(cnt == m){
            // for(int j = 0 ;j<m;j++){
            //    sb.append(temps[j]).append(" ");
            // }
            // sb.append("\n");
            ret++;
			return;
        }
        if(i==n){
            return;
        }

        for (int k = 0; k < n; k++) {
            temps[cnt] = nums[k];
            solve(k, n,m, cnt+1);
//            temps[cnt] = 0;
        }
    }
}


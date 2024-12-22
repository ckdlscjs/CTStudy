import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem184 {
    static int[] nums = new int[9];
    static int[] temps = new int[9];
    static StringBuilder sb = new StringBuilder();
	static int ret = 0;
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, 0, n);
        solve(0, n, m, 0);
        // System.out.print(sb.toString());
    	System.out.println(ret);
	}

    private static void solve(int i, int n, int m, int cnt) {
        if(cnt == m){
            // for (int k = 0; k < m; k++) {
            //    sb.append(temps[k]).append(" ");
            // }
            // sb.append("\n");
            ret++;
			return;
        }
        if(n==i) return;

        for (int t = 0; t < n; t++) {
            if(cnt == 0){
                temps[cnt] = nums[t];
                solve(t, n, m, cnt+1);
            }else{ // cnt >= 1
                if(temps[cnt-1]<= nums[t]){
                    temps[cnt] = nums[t];
                    solve(t, n, m, cnt+1);
                }
            }
        }
    }
}


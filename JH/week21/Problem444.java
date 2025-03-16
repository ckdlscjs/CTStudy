import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem444 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0) {
            st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] res = solve(H,W,N);
            sb.append(res[0] + "" + (res[1] < 10 ? "0" + res[1] : res[1])).append('\n');
        }
        System.out.print(sb);
    }

    static int[] solve(int H, int W, int N){
        int inx = 0;
        for(int j =0;j<W;j++){
            for(int i = 0;i<H;i++){ // 거꾸로
                if(++inx == N){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{H, W};
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main146 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];
        int[] nums = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // LFD longest fold distance 

        int[] acc = new int[N+2];
        acc[1] = nums[0];

        for(int i = 2;i<=N;i++){
            acc[i] = acc[i-1] + nums[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            l--;  

            sb.append((acc[r]-acc[l])+"\n");
        }
        System.out.print(sb);
    }
}

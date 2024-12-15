import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem153 {

    static boolean[] chk; // = new int[100001];
    static boolean[] isCycle; // = new boolean[100001];
    static int[] nums;
    static int cnt = 0;

 
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());


        while(T-->0){
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            chk = new boolean[N+1];
            nums = new int[N+1];
            for(int i = 0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken())-1;
            }

            cnt = 0;
            isCycle = new boolean[N+1];
  

            for(int i = 0;i<N;i++){
                if(!chk[i]){
                    dfs(i,-1);
                }
            }
            bw.write(N-cnt + "\n");     
        }

        // System.out.print(sb);
        bw.flush();
    }

    static void dfs(int cur, int prev){
        
        chk[cur] = true;
 
        int nxt = nums[cur];
        if(!chk[nxt]){
            dfs(nxt,cur);
        }
        else if(!isCycle[nxt]){
            markCycle(nxt, cur);
        }
 
        isCycle[cur] = true; // dfs end 
    }

    static void markCycle(int start, int cur){
 
        do{
 
            isCycle[cur] = true; 
            cur = nums[cur];
            cnt++;
        }while(!isCycle[cur]);
    }
 
}
 

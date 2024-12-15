import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main158  { // BFS 0-1
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];
        BFS(N, K);
    }

    static void BFS(int k, int target){

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{k,0});

        boolean[] chk = new boolean[200002];
        chk[k] = true;

        int M = Integer.MAX_VALUE;

        while(!que.isEmpty()){
            int[] cur = que.pollFirst();

            int cur_pos = cur[0];
            int cur_dist = cur[1];
 
            if(cur_pos == target){
                System.out.println(cur_dist);
                return;
            }
            // if(isOutside(cur_dist,))
            if(!isOutside(2*cur_pos, 200000) && !chk[2*cur_pos]){
                chk[2*cur_pos] = true;
                que.addFirst(new int[]{2*cur_pos, cur_dist});
            }
            
            if(!isOutside(cur_pos-1, 200000) && !chk[cur_pos-1]){
                chk[cur_pos-1] = true;
                que.addLast(new int[]{cur_pos-1, cur_dist+1});
                // System.out.println(cur_pos + " 11" + cur_dist);
            }

            if(!isOutside(cur_pos+1, 200000) && !chk[cur_pos+1]){
                chk[cur_pos+1] = true;
                que.addLast(new int[]{cur_pos+1, cur_dist+1});
            }
            
        }
 
        return;
    }

    static boolean isOutside(int cur_pos, int N){
        return (0>cur_pos || cur_pos >= (N+1));
    }
}

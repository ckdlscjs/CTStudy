import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem126  {

    static class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx; 
        }
    }
    public static void main(String[] args) 
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt( (s) -> Integer.parseInt(s))
                            .toArray();
        int N = NK[0];
        int K = NK[1];

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Pair> que = new ArrayDeque<Pair>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<N;i++){
            if(!que.isEmpty()){
                while(!que.isEmpty() && (i-K+1>que.peekLast().idx) ){
                    que.pollLast();
                }
                while(!que.isEmpty() && nums[que.peekFirst().idx]>=nums[i]){
                    que.pollFirst();
                }

                que.addFirst(new Pair(nums[i], i));
                // if(que.isEmpty()){
                // }else{
                //     if(que.peekFirst().val>nums[i]){
                //         que.addFirst(new Pair(nums[i], i));
                //     }
                //     // 
                // }
            }
            else{
                que.addFirst(new Pair(nums[i], i));
            }
            sb.append(que.peekLast().val + " ");
        }
        System.out.println(sb);
    }
}

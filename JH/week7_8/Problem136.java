import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Problem136{
    static int N;
    static int K;
    static int[] D = new int[200000];

    public static void main(String[] args) 
    throws IOException{
        INPUT();
        BFS();
    }

    private static void BFS() {
        // TODO (BFS for searching from N, finding K)
        ArrayDeque<Integer> que = new ArrayDeque<>();
        Arrays.fill(D, 1131001);
        que.add(N);
        D[N]=0;
        while(!que.isEmpty()){
            Integer cur = que.pollFirst();
            Integer Right = cur+1;
            Integer Left = cur-1;
            Integer twice = cur*2;
            if(cur==K){
                System.out.println(D[K]);
                return;
            }
            if(!isOutside(Right)){
                if(D[Right]>D[cur]+1){
                    D[Right] = D[cur] + 1;
                    que.addLast(Right);
                }
            }

            if(!isOutside(Left)){
                if(D[Left]>D[cur]+1){
                    que.addLast(Left);
                    D[Left] = D[cur] + 1;
                }
            }

            if(!isOutside(twice)){
                if(D[twice]>D[cur]+1){
                    que.addLast(twice);
                    D[twice] = D[cur] + 1;
                }
            }
        }
        System.out.println(D[K]);
    }

    private static void INPUT() 
    throws IOException{
        // TODO (INPUT METHOD)
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nums[0];
        K = nums[1];
    }

    private static boolean isOutside(Integer nxt){
        return (0>nxt || nxt>=100001);
    }   
    
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class problem116 {

    static class Pair{
        int val;
        long idx;
        Pair(int val, long idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // int[] res = new int[N];
        long res = 0;
        ArrayDeque<Pair> st = new ArrayDeque<>();

        for(long i = 0; i < N; i++){
            int tmp = Integer.parseInt(bf.readLine());
            while(!st.isEmpty() && st.peekLast().val <= tmp){
                res += i - st.pollLast().idx - 1;
                // (st.pollLast().idx, i-1] <=> res += i-1 - st.pollLast().idx; 
            }

            st.addLast(new Pair(tmp, i));
        }

        while(!st.isEmpty()){
            res += N - 1 - st.pollLast().idx;
        }
        System.out.println(res);
    }
}

// 10
// 5 1 4 1 3 1 2 1 1 1
//   0   0   0   0 0 0  
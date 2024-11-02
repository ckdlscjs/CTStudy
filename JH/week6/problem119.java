import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class problem119  {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            long[] nums = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            ArrayList<Long> st = new ArrayList<>();
            if(nums[0]==0) break;

            for(int i = 1;i<=nums[0];i++){
                st.add(nums[i]);
            }
            st.add(0L);
            long maxArea = SOLVE(st);
            System.out.println(maxArea);
        }
    }

    static long SOLVE(ArrayList<Long> nums){
        int N = nums.size();
        // System.out.println(nums);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        long M = 0;
        for(int i = 0;i< N;i++){
            while(!st.isEmpty() && nums.get(st.peekLast()) > nums.get(i)){
                // System.out.println(st);
                int nxt = st.pollLast();
                long width = (st.isEmpty()) ? i : i - st.peekLast() - 1;
                // -- st.peekLast() -- nxt -- i 
                //            k        j
                //            ----------
                //             (k,i)
                //  i - k - 1 , k = 2, i = 4,  [3]  
                // <=> (k, i-1] = 길이 i-1 - k 
                // st : current min compare to i, monotone min stack at i 
                M = Math.max(M, width * nums.get(nxt));
            }
            st.add(i);
        }

       
        return M;
    }
}
// 2 0 4 5 0 3 3 
//   

// 3 2 1 1 1
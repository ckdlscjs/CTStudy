import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;



public class problem117 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] res = new int[N];

        for(int i = 0; i<N;i++){

            while(!st.isEmpty() && nums[st.peekLast()]<nums[i]){
                res[st.pollLast()] = nums[i];
            } 
            // monotone stack at from 0 to i-1 : monotone decreasing stack, 
            // nums[idx1] > nums[idx2] ... > nums[last element] 
            st.addLast(i);
        }

        while(!st.isEmpty()){
            res[st.pollLast()] = -1;
        }
        
        System.out.println(Arrays.stream(res).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

    }
}

// 4
// 3 5 2 7
// 5 7 7 -1 
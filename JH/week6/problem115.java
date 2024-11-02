import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class problem115  {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" "))    
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int[] res = new int[N];
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i = 0;i<N;i++){
            while(!st.isEmpty() && nums[st.peekLast()] < nums[i]){
                st.pollLast();
            }
            res[i] = (st.isEmpty()) ? 0 : st.peekLast() + 1;
            st.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            sb.append(res[i] + " ");
        }
        
        System.out.println(sb);
    }
}

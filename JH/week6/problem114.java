import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class problem114 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int num = 0;
        for(int i = 0;i<N;i++){
            // 1 2 3 4 
            int tmp = Integer.parseInt(bf.readLine());
            while(num < tmp){
                sb.append('+' + "\n");
                num++;
                nums.addLast(num);
            }
            if(nums.peekLast()==tmp){
                nums.pollLast();
                sb.append('-' + "\n");
            }
        }

        if(nums.size()>0){
            System.out.println("NO");
        }
        else{
            System.out.print(sb);
        }
        return;
    }
}

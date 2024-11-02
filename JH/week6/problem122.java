import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class problem122  {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());    
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for(int i = 0;i<N;i++){
            que.addLast(i+1);
        }

        while(que.size()>1){
            que.pollFirst();
            que.addLast(que.pollFirst());
        }
        System.out.println(que.peek());
    }
}

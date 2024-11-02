import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class problem125  {

    
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0){
            String ords = bf.readLine();
            int N = Integer.parseInt(bf.readLine());
            String nums_str = bf.readLine();
            ArrayDeque<Integer> que = new ArrayDeque<>();

            int dir = 0;
            int[] nums = new int[N];
            if(N>0){
                String temp = nums_str.substring(1, nums_str.length()-1);
                nums = Arrays.stream(temp.split(",")).mapToInt(Integer::parseInt).toArray();
            }
            for(int i = 0;i<N;i++){
                que.addLast(nums[i]);
            }

            boolean flag = false;
            for(char c : ords.toCharArray()){
                if(c=='D'){
                    if(que.isEmpty()){
                        flag = true;
                        break;
                    }
                    if(dir==0){
                        que.pollFirst();
                    }else{
                        que.pollLast();
                    }
                }else{
                    dir = (dir+1)%2;
                }
            }

            if(flag) {
                System.out.println("error");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(que.size()>0){
                if(dir==0){
                    while(que.size()>1){
                        sb.append(que.pollFirst() +",");
                    }
                }else{
                    while(que.size()>1){
                        sb.append(que.pollLast() +",");
                    }
                }
                if(que.size()==1){
                    sb.append(que.pollFirst());
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}

import java.io.*;
import java.util.*;

public class problem112 {

    static int INF = 1000001;
    public static void main(String[] args) 
    throws IOException{
        int[] nums = new int[10001];
        int idx = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        Arrays.fill(nums, INF);

        for(int i = 0;i<N;i++){
            String[] ords = bf.readLine().split(" ");
            if(ords[0].equals("push")){
                nums[idx++] = Integer.parseInt(ords[1]);
            }
            else if(ords[0].equals("pop")){
                if(idx==0){
                    bw.write(-1 + "\n");
                }else{
                    bw.write(nums[--idx] + "\n");
                }
            }
            else if(ords[0].equals("size")){
                bw.write(idx + "\n");
            }
            else if(ords[0].equals("empty")){
                bw.write(((idx==0)? 1 : 0) + "\n");
            }else{ // top 
                bw.write(((idx==0)? -1 : nums[idx-1]) + "\n");
            }
        }
        bw.flush();
    }
}

 
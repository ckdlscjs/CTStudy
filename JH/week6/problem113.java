import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem113  {
    static int[] nums = new int[1000001];
    static int idx = 0; 
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0;i<N;i++){
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp==0){
                if(idx>0){
                    nums[--idx] = 0;
                }
            }else{
                nums[idx++] = tmp;
            }
        }
        int sum = 0;
        for(int i = 0;i < N; i++){
            sum += nums[i];
        }
        System.out.println(sum);
    }
}

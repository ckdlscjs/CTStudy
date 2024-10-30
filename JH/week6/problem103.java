
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem103{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[10];

        while(N>0){
            nums[N%10]++;
            N/=10;
        }
        
        int ret = (nums[6] + nums[9]);
        if(ret%2==1){
            ret = (ret/2) + 1;
        }else{
            ret/=2;
        }

        for(int i = 0;i<10;i++){
            if(i == 6 || i==9) continue;
            ret = Math.max(ret, nums[i]);
        }
        System.out.println(ret);
    }
}
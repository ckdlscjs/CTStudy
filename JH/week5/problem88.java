import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem88{
    public static void main(String[] args) 
        throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Y 
        // M 
        int N = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int y = cal(30, nums, N, 10);
        int m = cal(60, nums, N, 15);
        // System.out.println(y + " " + m);
        if(y==m){
            System.out.println("Y M " + m);
        }else{
            if(m>y){
                System.out.println("Y " + y);
            }else{
                System.out.println("M " + m);
            }
        }
    }

    static int cal(int div, int[] nums, int n, int cost){
        
        int cnt = 0;
        for (int num : nums) {
            int quo = num/div;
            int rem = num%div;
            // if(rem!=0){
                cnt += (cost * (++quo));
            // }else{
                // cnt += (cost * (++quo));
            // }
        }
        return cnt;
    }
 
}
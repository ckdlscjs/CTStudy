import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem442 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = new String[3];
        for(int i = 0;i<3;i++){
            nums[i] = bf.readLine();
        }
        int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) - Integer.parseInt(nums[2]);
        int sum1 = Integer.parseInt(nums[0] + nums[1]) - Integer.parseInt(nums[2]);
        System.out.println(sum);
        System.out.println(sum1);
    }
}

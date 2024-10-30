
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;



public class problem102{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        int T = (N*M*K);

        int[] nums = new int[10];

        while(T>0){
            nums[T%10]++;
            T/=10;
        }
        String res = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
        
        System.out.println(res);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class problem85{
   
    public static void main(String[] args) 
        throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = sizes[0];
        int M = sizes[1];
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            if(num < M){
                arr.add(num);
            }
        }
        String res = arr.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));

        System.out.println(res);
    }
}
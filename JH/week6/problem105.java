
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class problem105{

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bf.readLine());
        Collections.frequency(new ArrayList<>(),x);
        long count = Arrays.stream(nums)
              .boxed()
              .filter(s -> s == x)
              .count();
              
        System.out.println(count);
    }
}
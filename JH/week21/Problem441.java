import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem441 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        String s = bf.readLine();
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += (c-48);
        }
        System.out.println(sum);
    }
}

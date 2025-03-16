import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem431 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 1;i<=9;i++){
            System.out.println(N + " * " + i + " = " + (N*i));
        }
    }
}

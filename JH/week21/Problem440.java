import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem440 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int idx = Integer.parseInt(bf.readLine());
        System.out.println(s.charAt(idx-1));
    }
}

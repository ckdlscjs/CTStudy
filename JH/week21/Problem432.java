import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem432 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=N;i++){
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}

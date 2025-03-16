import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem430 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0;
        for(int i = 0;i<5;i++){
            int a = Integer.parseInt(st.nextToken());
            sum += (a*a);
        }
        System.out.println(sum % 10);
    }
}

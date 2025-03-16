import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem445 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = -100_000_00;
        int m = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(M<num){
                M = num;
            }
            if(m>num){
                m = num;
            }
        }
        System.out.println(m + " " + M);
    }
}
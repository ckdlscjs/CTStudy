import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem450 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            String s = bf.readLine(); // ignoreLF?

            int cnt = 1;
            int res = 0;
            for(char c : s.toCharArray()){
                if(c == 'O'){
                    res += (cnt++);
                }else{
                    cnt = 1;
                }
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}

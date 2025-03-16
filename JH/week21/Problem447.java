import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem447 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            String target = st.nextToken();
            char[] res = new char[n * target.length()];
            for(int j = 0;j<target.length();j++){
                for(int k=0;k<n;k++){
                    sb.append(target.charAt(j));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

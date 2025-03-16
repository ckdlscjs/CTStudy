import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem446 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        // System.out.println(st.countTokens());
        String s = bf.readLine();
        int idx = 0;

        // 
        char[] chars =  s.toCharArray();
        int n = chars.length;
        int cnt = 0;
        for(int i = 0;i<chars.length;i++){
            if(i>0 && i+1<n && chars[i-1]!=' ' && chars[i] == ' ' && chars[i+1]!=' '){
                cnt++;
            }
        }
        if(chars.length==1){
            if(chars[0] != ' ') System.out.println(1);
            else{
                System.out.println(0);
            }
        }else if(chars.length==0){
            System.out.println(0);
        }
        else{
            System.out.println(cnt+1);
        }
    }
}

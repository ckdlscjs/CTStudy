import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem451 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        int idx = 0;
        for(char c : s.toCharArray()){
            if(chars[c-97]==-1) chars[c-97] = idx;
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int n : chars){
            sb.append(n).append(" ");    
        }
        System.out.println(sb);
    }
}

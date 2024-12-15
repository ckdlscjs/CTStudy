import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main129 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String tmp = bf.readLine();
            ArrayDeque<Character> st = new ArrayDeque<>();
            boolean flag = false;

            for(char c : tmp.toCharArray()){
                if(c==')'){
                    if(st.isEmpty()) {
                        // System.out.println("NO");
                        flag = true;
                        break;
                    }
                    if(!st.isEmpty() && st.peekLast() == '('){
                        st.pollLast();
                    }
                }
                else{
                    st.addLast(c);
                }
            }
            // System.out.println(st);
            String tmp_str = ((!flag && st.isEmpty()) ? "YES" : "NO");
            sb.append(tmp_str +"\n");
        }    
        System.out.print(sb);   
    }
}

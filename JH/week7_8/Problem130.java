import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.io.BufferedReader;

public class Main130 {

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();

        ArrayDeque<Character> st = new ArrayDeque<>();
        int N = tmp.length();
        int ret = 0;
 
        for(int i = 0;i<N;i++){
            char c = tmp.charAt(i);
            if(c=='('){
                st.addLast(c);
            }else{
                st.pollLast();
                if(tmp.charAt(i-1) == '('){ // 레이저 
                    ret += st.size();
                }else{ // 막대끝 
                    ret += 1; // 
                }
            }
        }
        System.out.println(ret);
    }
}

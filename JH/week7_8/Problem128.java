import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main128  {

    static class Pair{
        Character data;
        int idx;
        Pair(char data, int idx){
            this.data = data;
            this.idx = idx;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int ret = 0;
        for(int i = 0;i<N;i++){
            String tmp = bf.readLine();
            ArrayDeque<Character> st = new ArrayDeque<>();
            for(int j = 0;j<tmp.length();j++){
                Character tmp_char = tmp.charAt(j);
                if(st.isEmpty()){
                    st.addLast(tmp_char);
                }else{
                    if(st.peekLast() == tmp_char){
                        st.pollLast();
                    }
                    else{
                        st.addLast(tmp_char);
                    }
                }
            }
            if(st.isEmpty()){ret++;}
        }
        System.out.println(ret);
    }
}

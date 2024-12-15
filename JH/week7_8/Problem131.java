import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem131 {
    public static void main(String[] args) 
    throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        ArrayDeque<String> st = new ArrayDeque<>();
        // ArrayDeque<Integer> nums = new ArrayDeque<>();
        int cnt = 0;
        for(Character c : tmp.toCharArray()){   

            String nxt = c.toString();
            // System.out.println(st + " " + c + " " + (++cnt));
            if(st.isEmpty() && (c==']' || c==')') ) {
                // System.out.println("AV");
                System.out.println(0);
                return;
            }

            if(c=='(' || c=='['){
                st.addLast(nxt);
                continue;
            }
            else{ // c == ')' || c == ']'
                // if(!st.isEmpty()){ ..  주석을 친 이유 위에서 이미 처리함 
                    String back = st.peekLast();
                    int cur = 0;
                    while(!st.isEmpty()){ // 뒤에 숫자가 있을 경우 전부 더하기 
                        back = st.peekLast();
                        if(back.equals("(") || back.equals("[")){
                            break;
                        }
                        cur += Integer.parseInt(back);
                        st.pollLast();
                    }   

                    if(st.isEmpty()){ // 숫자만 뺐는데 스택이 빌 경우 
                        System.out.println(0);
                        return;
                    }

                    String new_nxt = st.peekLast();
                    
                    if( (new_nxt.equals("(") && nxt.equals("]")) || (new_nxt.equals("[") && nxt.equals(")")) ){
                        System.out.println(0);
                        // System.out.println(st +  " !#@");
                        return;
                    }

                    if(new_nxt.equals("(") && nxt.equals(")")){
                        if(cur == 0){
                            cur = 2;
                        }
                        else{
                            cur *= 2;
                        }
                        st.pollLast();
                        st.addLast(Integer.toString(cur));
                    }
                    else if(new_nxt.equals("[") && nxt.equals("]")){
                        if(cur == 0){
                            cur = 3;
                        }
                        else{
                            cur *= 3;
                        }
                        st.pollLast();
                        st.addLast(Integer.toString(cur));
                    }
                    // System.out.println(st +  " !#@");
                // }
                // else{ // (를 찾아야 하는데 스택이 빈 경우 
                //     System.out.println(0);
                //     return;
                // }
            }

        }
        // System.out.println(st);
        try {
            int ret = 0;
            while(!st.isEmpty()){
                ret += Integer.parseInt(st.pollLast());
            }
            // System.out.println(st);
            System.out.println(ret);
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }
}

// (()[[]])([])
//   2*(2 + 3*3) = 22 + 
//   3* 2 = 6 
// st : ['(', 2]
// st : ['(', '[','[']
// st : ['(', 2, '[', 3]
// st : [28]
// ---
// st : ['(']
// nums : [2]
// st : ['(', '[']
// nums : [2]
// 

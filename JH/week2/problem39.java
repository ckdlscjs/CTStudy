package week2;

import java.util.Stack;

public class problem39 {
    class Solution {
        public String solution(String new_id) {
            // 소문자, '.', '-' '_' '.' 를 제외하고 나머지문자는 전부 제거 
            String answer = "";
            new_id = new_id.toLowerCase();
            
            // 2
            new_id = second(new_id);
            // System.out.println(new_id);
            // 3 
            new_id = third(new_id);
            // System.out.println(new_id);
            // String tmp = se;
            // 4
            new_id = fourth(new_id);
            // System.out.println(new_id);
            
            // 5
            if(new_id.isEmpty()){
                new_id = "a";
            }
            // System.out.println(new_id);

            // 6 
            if(new_id.length()>=16){
                new_id = new_id.substring(0,15);
                
            }
            char t = new_id.charAt(new_id.length()-1);
            if(t=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
            t = new_id.charAt(0);
            if(t=='.'){
                new_id = new_id.substring(1);
            }

            if(new_id.length()<=2){
                Character tmp = new_id.charAt(new_id.length()-1);
                while(new_id.length()<=2){
                    new_id += tmp;
                    
                }
            }
            // System.out.println(new_id);
            return new_id;
        }
        
        public String second(String s){
            String tmp = "";
            for(int i = 0;i<s.length();i++){
                char cha = s.charAt(i);
                // 대소문자 치환 
                if ((48<= cha && cha <= 57) || (97<= cha && cha <= 122) || cha=='_' || cha=='.' || cha =='-' || cha =='.'){
                    tmp += cha;
                }
            }
            return tmp;
        }
        
        public String third(String s){
            Stack<Character> st = new Stack<>();

            int cnt = 0;
            for(int i = 0;i<s.length();i++){
                char tmp = s.charAt(i);
                st.push(tmp);
                if(tmp == '.'){
                    cnt+=1;
                    if(st.size()>=2 && cnt>=2){
                        while(cnt>1){
                            st.pop();
                            cnt-=1;
                        }
                    }
                }else{
                    cnt = 0;
                }
            }
            
            String ret = "";
            while(!st.empty()){
                ret = st.peek() + ret;
                st.pop();
            }
            
            return ret;
        }
        
        public String fourth(String s){
            String ret = "";
            if(s.charAt(0) =='.'){
                int i = 0;
                while (i<s.length()){
                    if(s.charAt(i)!='.'){
                        break;
                    }
                    i++;
                }
                
                Stack<Character> st = new Stack<>();
                
                for(int j =i;j<s.length();j++){
                    st.push(s.charAt(j));        
                }
                
                while(!st.empty()){
                    ret = st.peek() + ret;
                    st.pop();
                }
                return ret;
            }else{
                return s;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}

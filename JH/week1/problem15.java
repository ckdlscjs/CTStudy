package week1;

public class problem15 {

    static class Solution {
    
        public char calcul(char s, String skip, int index){
            // s + 1;

            int i = 0;
            String cur = Character.toString(s);

            while(i<index){
                cur = Character.toString(s);
                boolean flag = false;

                if(cur.equals("{")){
                    s = 'a';
                    cur = "a";
                }

                while(skip.contains(cur)){
                    s++;
                    cur = Character.toString(s);
                    flag = true;
                }
                if(!flag) s++;
                i++;
                
            }
            
            String ret = Character.toString(s);
            if(ret.equals("{")){
                ret = "a";
            }
  
            return ret.charAt(0);
        }
        
        public String solution(String s, String skip, int index) {
            String answer = "";
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                answer += calcul(c,skip,index);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.solution("a", "z", 1));

 
 
   }    
}

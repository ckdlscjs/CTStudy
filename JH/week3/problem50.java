import java.util.ArrayList;

class Solution {
    
    static int prev = 0;
    public int solution(String dartResult) {
        int answer = 0;
        
        char[] chars = dartResult.toCharArray();
        ArrayList<String> st = new ArrayList<String>();
        
        
        for(int i = 0;i<chars.length;i++){
            String a = "";
            char c = chars[i];
            a+=c;
            if(48 <= c && c <= 57){
                if(st.size()>=2){
                    answer = addAnswer(answer, st);
                } 
                
                if(i+1<chars.length && (48<=chars[i+1] && chars[i+1]<=57)){
                    a+=chars[i+1];
                    i++;
                }
                st.add(a);
            }else{
                st.add(a);
            }
        }
        
        
        if(st.size()>=2){
            answer = addAnswer(answer, st);
        } 
        return answer;
    }
    
     static int addAnswer(int answer, ArrayList<String> st){
 
        // at least size()>=2
        int first = Integer.parseInt(st.get(0));
        String second = st.get(1);
        String third = "";
        // System.out.println(String.join(" ", st) + " " + st.size());
        if(st.size()==3){
            third += st.get(2);
            st.remove(st.size()-1);
        }
        st.remove(st.size()-1);
        st.remove(st.size()-1);
        
        int sum = 0;
        if(second.equals("S")){
            sum += (int) Math.pow(first, 1);
        }else if(second.equals("D")){
            sum += (int) Math.pow(first, 2);
        }
        else if(second.equals("T")){
            sum += (int) Math.pow(first, 3);
        }
        // System.out.println(sum + " " + " sum");
        if(!third.isEmpty()){
            if(third.equals("*")){
                sum *= 2;
                answer = answer + sum + prev;
            }else{
                sum *= -1;
                answer += sum;
            }
        }else{
            answer += sum;
        }
     prev = sum;
     // System.out.println(answer+ " " + " answer");

        return answer;
    }
}
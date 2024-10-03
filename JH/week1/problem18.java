package week1;

public class problem18 {    
    class Solution {
        public int[] solution(String s) {
            int[] chk = new int[27];
            
            for(int i = 0;i<26;i++){
                chk[i]=-1;
            }
            
            int[] answer = new int[s.length()];
            
            for(int i =0;i<s.length();i++){
                if (chk[s.charAt(i)-'a'] == -1){
                    answer[i] = -1;
                    chk[s.charAt(i)-'a'] = i; // 위치 
                }else{
                    answer[i] = i - chk[s.charAt(i)-'a'];
                    chk[s.charAt(i)-'a'] = i;
                }
                
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

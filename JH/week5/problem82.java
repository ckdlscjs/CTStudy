public class problem82 {
    static class Solution {
        public String solution(String s) {
            int n = s.length();
            String answer;
            if(n%2==0){
                n= (n/2)-1;
                answer = s.substring(n, n+2);
            }else{
                answer = s.substring(n/2, (n/2)+1);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

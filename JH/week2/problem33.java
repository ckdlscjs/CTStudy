package week2;

public class problem33 {
    class Solution {
        public int solution(int[] numbers) {
            
            boolean[] chk = new boolean[10];
            for(int i = 0;i<numbers.length;i++){
                if(!chk[numbers[i]]){
                    chk[numbers[i]] = true;
                }
            }
            
            int answer = 0;
            for(int i=0;i<10;i++){
                if(!chk[i]){
                    answer+= i;
                }   
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

package week2;

public class problem38 {

    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i = 0;i<signs.length;i++){
                if(signs[i]){ // 양수 
                    answer += absolutes[i];
                }else{
                    answer -= absolutes[i];
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

package week2;

public class problem27 {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;
            int n = number.length;
            for(int i = 0;i<n;i++){
                for(int j = i+1;j<n;j++){
                    for(int l =j+1;l<n;l++){
                        int sum = number[i] + number[j] + number[l];
                        if(sum == 0){
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }    
}

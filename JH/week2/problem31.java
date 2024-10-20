package week2;

import java.util.Arrays;
import java.util.Comparator;

public class problem31 {
    
    static class Solution {
        public int solution(int n) {
    
            
            // n에서 1을 뺀 값의 1보다 큰 약수의 최솟값을 찾기 
            
            int answer = Integer.MAX_VALUE;
            
            for(int i = 2;i<=n;i++){
                if(n%i==1){
                    answer = (answer > i) ? i : answer;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        
    }
}

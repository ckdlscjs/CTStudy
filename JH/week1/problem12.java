package week1;

public class problem12 {
    class Solution {
        // greedy 
        public int solution(int n, int m, int[] section) {
            int answer = 0;
        
            int i = 0;
            int len = section.length;
            int sum = 0;
            int prev = 0;
     
                System.out.println(n);
                while(i<len){
                    
                    int cur_start = section[i];
                    int cur_end = section[i] + m-1;
                    System.out.println(cur_end);
                    if(cur_end >= n){
                        answer++;
                        return answer;
                    }
                    while(i<len && cur_start <= section[i] && section[i] <= cur_end){
                        i++;
                    }
                    // System.out.println(answer);
                    answer++;
                }
           
            
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

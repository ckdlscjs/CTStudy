package week2;

public class problem26 {
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
        
            while(n>=a){
                int incre = b*(n/a);
                int remain = n%a;
                answer += incre;
                n = incre + remain;
                remain = 0;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

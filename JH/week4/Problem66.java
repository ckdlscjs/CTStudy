package week4;

public class Problem66 {
    public int[] solution(long n) {
        int cnt = 0;
        long m = n;
        while(m>0){
            m/=10;
            cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        
        boolean flag = false;
        long ten = 10;
        while(n>0){
            int cur = (int) (n%ten);
       
            answer[idx++] = cur;
            n/=10;
            
        }

        return answer;
    }
}
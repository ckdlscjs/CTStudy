package week4;

public class Problem79 {
    public long solution(int a, int b) {
        long two = 2L;
        long A = a;
        long B = b;
        if(A>B){
            long tmp = A;
            A = B;
            B = tmp;
        }
        
        long answer = (B+A)*(B-A+1);
        return answer/two;
    }
}
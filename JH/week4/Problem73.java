package week4;

public class Problem73 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2;i<=n;i++){
            if(isPrime(i)){
 
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isPrime(int n){
        if(n==2){return true;}
        int sqrtn = (int) Math.ceil(Math.sqrt(n));
        
        for(int i = 2;i<=sqrtn;i++){
            if(n%i==0){
                return false;
            }   
        }
        
        return true;
    }
}
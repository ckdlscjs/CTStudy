package week4;

public class Problem69 {
    public int solution(int n) {
        int answer = 0;
        int sqrtn = (int) Math.ceil(Math.sqrt(n));
        System.out.println(sqrtn);
        for(int i = 1;i<=sqrtn;i++){
            if(n%i==0){
                int other = n/i;
                if(other<i){
                    break;
                }
                if(n/i == i){
                    answer+= other;
                    // System.out.println(other);
                }else{
                    answer+= i;
                    answer+= (n/i);
                    // System.out.println(other);
                    // System.out.println(i);
                }
                // System.out.println();
            }
        }// 1 2 3 4 6 12  
        return answer;
    }
}
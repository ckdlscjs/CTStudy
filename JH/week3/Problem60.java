public class Problem60 {
    public int solution(int num) {
        int answer = 0;
        int n = num;
        while(answer<500 && n!=1){
            answer++;
            System.out.println(n);
            if(n%2==0){
                n/=2;
            }else{
                n *=3;
                n +=1;
            }
        }
        
        if(answer==500){
            return -1;
        }else{
            return answer;
        }
    }
}
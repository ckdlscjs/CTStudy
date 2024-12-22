package week4;

public class Problem72 {
    public String solution(int n) {
        String answer = "";
        String odd = "박";
        String even = "수";
        for(int i =0;i<n;i++){
            if(i%2==0){
                answer += even;
            }
            else{
                answer += odd;
            }
        }
        return answer;
    }
}
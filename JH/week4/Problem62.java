package week4;

public class Problem62 {
    public String solution(int num) {
        String odd = "Odd";
        String even = "Even";
        if(num%2==0){
            return even;
        }else{
            return odd;
        }
    }
}
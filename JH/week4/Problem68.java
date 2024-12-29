package week4;

public class Problem68 {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(isCharacter(c)){
                if(cnt%2==0){ // 
                    answer += toUpper(c);
                }else{
                    answer += toLower(c);
                } 
            }else{
                answer+=c;
             }
            cnt++;
            if(c == ' '){
                cnt = 0;
            }
        }
        System.out.println(answer);
        return answer;
    }
    
    public char toUpper(char a){
        boolean isUpper = (65<= a && a<=90);
        if(isUpper){
            return a;
        }
        return  (char) ( (a-'a') + 'A');
    }
    public char toLower(char A){
        boolean isLower = (97<= A && A<=122);
        if(isLower){
            return A;
        }
        return (char) ((A-'A') + 'a');
    }
    
    public boolean isCharacter(char a){
        boolean isUpper = (65<= a && a<=90);
        boolean isLower = (97<= a && a<=122);
        return (isUpper || isLower);
    }
}
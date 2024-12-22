package week4;

public class Problem75 {
    public boolean solution(String s) {
        boolean answer = true;
        
        // length chk 
        int len = s.length();
        boolean lengthchk = (len == 4 || len == 6);
        if(!lengthchk){
            return false;
        }
        
        // digit chk 
        for(char c : s.toCharArray()){
            if(!isDigit(c)){
                return false;
            }
        }
        return answer;
    }
    
    private boolean isDigit(char c){
        return (48 <= c && c <= 57);
    }
}
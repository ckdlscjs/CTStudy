class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()){
            if(c==' '){
                answer+=c;
            }else if(isUpper(c)){
                answer += charChiper(c, n, 65);
            }else{ // small 
                answer += charChiper(c, n, 97);
            }
        }
        
        return answer;
    }
    
    private char charChiper(char c, int encoding, int start){
        int idx = (26 + c - start + encoding)%26;
        return (char) (idx + start) ; 
    }
    
    private boolean isUpper(char a){
        return (65 <= a && a <= 90);
    }
    
    private boolean isLower(char a){
        return (97 <= a && a <= 122);
    }
}
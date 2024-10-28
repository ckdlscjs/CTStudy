import java.util.Arrays;
    
class Solution {
    public String solution(String s) {
        int[] Big = new int[26];
        int[] small = new int[26];
        String answer = "";
        for(char c : s.toCharArray()){
            if(isUpper(c)){
                Big[c-65]++;
            }else{
                small[c-97]++;
            }
        }
        
       for(int i = 25;i>=0;i--){
            for(int k = 0;k<small[i];k++){
                answer+=(char)(97 + i);
            }
        }
        
        
        for(int i = 25;i>=0;i--){
            for(int k = 0;k<Big[i];k++){
                answer+=(char)(65 + i);
            }
        }
        
      
        
        System.out.println(Arrays.toString(Big));
        System.out.println(Arrays.toString(small));
 
        return answer;
    }
    
    private boolean isUpper(char c){
        return (65 <= c && c <= 90);
    }
    
    private boolean isLower(char c){
        return (97 <= c && c <= 122);
    }
}
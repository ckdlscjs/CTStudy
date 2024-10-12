package week2;

import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<Character, Integer> XX = new HashMap<>();
        HashMap<Character, Integer> YY = new HashMap<>();
        HashMap<Character, Integer> common = new HashMap<>();
        
        for(int i =0;i<X.length();i++){
            int cnt = XX.getOrDefault(X.charAt(i),0);
            XX.put(X.charAt(i), ++cnt);
        }
        
        for(int i =0;i<Y.length();i++){
            int cnt = YY.getOrDefault(Y.charAt(i),0);
            YY.put(Y.charAt(i), ++cnt);
        }
        StringBuilder sb = new StringBuilder();
        
        boolean flag = false; 
        for(int i = 9;i>=0;i--){
            char tmp = (char) (i + '0');
            int XX_cnt = XX.getOrDefault(tmp,0);
            int YY_cnt = YY.getOrDefault(tmp,0);
            int min_val = (XX_cnt > YY_cnt) ? YY_cnt : XX_cnt;
            if(tmp>='1' && min_val>0){
                flag = true;
            }
            
            if(tmp =='0' && min_val>0 && !flag){
                sb.append('0');
                continue;
            }
            for(int j =0;j<min_val;j++){
                sb.append(tmp);        
            }
        }
        String answer = sb.toString();
        
        return (answer.equals("")) ? "-1" : answer;
    }
    public static void main(String[] args) {
        
    }
}
import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        String[] arrStr = String.valueOf(n).split("");
        
        Arrays.sort(arrStr);
        for(int i = arrStr.length-1; i >= 0; i-=1){
            sb.append(arrStr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}

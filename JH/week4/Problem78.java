package week4;

import java.util.Arrays;
import java.util.Comparator;

public class Problem78 {
    public String[] solution(String[] strings, int n) {
 
        
        Arrays.sort(strings, new Comparator<String>(){
            @Override 
            public int compare(String a, String b){
                if(a.charAt(n) == b.charAt(n)){
                    return a.compareTo(b);
                }else{
                    return Character.compare(a.charAt(n),b.charAt(n));
                }
            }
        });
        
        return strings;
    }
    
}
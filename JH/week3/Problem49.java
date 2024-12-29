package week3;

import java.util.HashMap;

public class Problem49 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> chk = new HashMap<String, Integer>();
        
        for(String name : participant){
            int cur = chk.getOrDefault(name,0);
            if(cur==0){
                chk.put(name,1);
            }else{
                chk.put(name,cur+1);
            }
            Character b = '1';
            String a = b.toString(0);
            // The static method toString(int) from the type Character should be accessed in a static wayJava(603979893)

            a+='1';

            // Character.toString(c)
            // a.toCharArray()
        }
        
        for(String name : completion){
            int cur = chk.getOrDefault(name,0);
            if(cur!=0){
                chk.put(name,cur-1);
            }
        }
        
      for(String name : participant){
            int cur = chk.getOrDefault(name,0);
            if(cur!=0){
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}
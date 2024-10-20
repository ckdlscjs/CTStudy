import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : completion){// 완주자 해시맵 해시맵에 없으면 1 있으면 1+1 = 2
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(String str : participant){// 참가자 순회하면서 체크
            if(map.getOrDefault(str, 0) == 0){// 이부분이 직관적이지 않다
                return str;
            }
            map.put(str, map.get(str) - 1);// 완주한 사람 1씩 감소 
        }
        return null;
    }
}

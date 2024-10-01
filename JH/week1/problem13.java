package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class problem13 {

    static class Solution {
        public int min(int a, int b){
            return (a>b) ? b : a;
        }
        
        public int[] solution(String[] keymap, String[] targets) {
            // HashMap<Character, Integer> firstKey = new HashMap<>();
            ArrayList<HashMap<Character, Integer>> keys = new ArrayList<>();
            int[] answer = new int[targets.length];
            
            for(int i = 0;i<keymap.length;i++){
                keys.add(new HashMap<>());
                for(int j= 0;j<keymap[i].length();j++){
                    if(keys.get(i).getOrDefault(keymap[i].charAt(j),0)==0){
                        keys.get(i).put(keymap[i].charAt(j), j+1);
                    }
                }
            }
            
            
            for(int i = 0;i<targets.length;i++){
                int cnt = 0;
                for(int j = 0;j<targets[i].length();j++){
                    char cur = targets[i].charAt(j);
                    int tmp = Integer.MAX_VALUE;
                    for(int k = 0;k<keymap.length;k++){
                        tmp = min(tmp, keys.get(k).getOrDefault(cur, Integer.MAX_VALUE));
                    }
                    
                    if(tmp == Integer.MAX_VALUE){
                        cnt = Integer.MAX_VALUE;
                        break;
                    }
                    cnt += tmp;
                }
                System.out.println(cnt);
                answer[i] = (cnt==Integer.MAX_VALUE)? -1 : cnt;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution ss = new Solution();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        // ["ABACD", "BCEFD"]	["ABCD","AABB"]
        System.out.println(Arrays.toString(ss.solution(keymap, targets)));
        HashMap<Character, Integer> firstKey = new HashMap<>();
        firstKey.put('A', 1);
        
    }
}

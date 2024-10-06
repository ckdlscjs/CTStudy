package week1;

import java.util.HashMap;

public class problem9 {
    
    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i = 0 ;i<name.length;i++){
                map.put(name[i], yearning[i]);
            }
            
            int[] answer = new int[photo.length];
            
            for(int i = 0;i<photo.length;i++){    
                String[] names = photo[i];
                int cnt = 0;
                for(String person : names){
                    if(map.getOrDefault(person,0)>0){
                        cnt += map.get(person);
                    }
                }
                answer[i] = cnt;
            }
            return answer;
        }
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> M = new HashMap<>();
        System.out.println(M.getOrDefault("ss", 0) > 0);

    }
}

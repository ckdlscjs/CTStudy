package week2;

import java.util.HashMap;

public class problem30 {
    
    class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        boolean[][] bean = new boolean[id_list.length][id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<id_list.length;i++){
            map.put(id_list[i],i);
        }
        
        int[] cnts = new int[id_list.length+1];
                
        for(int i = 0;i<report.length;i++){
            String[] names = report[i].split(" ");
            String who = names[0];
            String whom = names[1];
            int who_idx = map.get(who);
            int whom_idx = map.get(whom);
            if(!bean[who_idx][whom_idx]){ // -> 
                bean[who_idx][whom_idx] = true;
                cnts[whom_idx]++; // 신고당한 횟수 적기 
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0;i<id_list.length;i++){
            
            int cnt = 0;
            for(int j = 0;j<id_list.length;j++){
                if(bean[i][j] && cnts[j]>=k){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}

    public static void main(String[] args) {
        
    }
}

package week1;

import java.util.LinkedList;
import java.util.HashMap;

public class problem8 {

    class Solution {
        public String[] solution(String[] players, String[] callings) {
            LinkedList<String> play = new LinkedList<>();
            HashMap<String, Integer> playersIndex = new HashMap<>();
            
            for(int i = 0;i<players.length;i++){
                play.addLast(players[i]);
                playersIndex.put(players[i], i);
            }
            
            for(String playerCall : callings){
                int idx1 = playersIndex.get(playerCall);
                int idx2 = idx1-1; // 1등인 선수는 부르지 않는다. 
                
                // swap idx1 <-> idx2 <=> tmp1 <-> tmp2 
                String tmp1 = play.get(idx1);
                String tmp2 = play.get(idx2); 
                
                playersIndex.put(tmp2, idx1); // tmp2 : idx1 
                playersIndex.put(tmp1, idx2); // tmp1 : idx2
                
                // in List 
                // idx2 idx1 
                // idx1 idx2 idx1 
                play.add(idx2, tmp1);
                // idx2 idx1 idx1 + 1
                play.remove(idx1); 
            }
            
            String[] answer = new String[play.size()];
            for(int i = 0 ;i<play.size();i++){
                answer[i] = play.get(i);
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> L = new LinkedList<>();

        for(int i= 0 ;i<10;i++){
            L.addLast(i);
        }
        L.add(1,32);
        
        System.out.println(L.toString());
    }
}

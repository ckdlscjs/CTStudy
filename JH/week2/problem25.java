package week2;

import java.util.HashSet;

public class problem25 {
    
    static class Solution{
        public boolean isValidBabble(String babble, HashSet<String> knowns){
            int idx = 0;
            int n = babble.length();
            String prev = "";
            while(idx <  n){
                boolean found = false;
                for(String known : knowns){
                    if(babble.startsWith(known,idx)){
                        if(prev == known){
                            return false;
                        }
                        idx += known.length();
                        found = true;
                        prev = known;
                        break;
                    }
                }
                if(!found){
                    return false;
                }
            }
            return true;
        }
        
        public int solution(String[] babbling){
            int answer = 0;
            HashSet<String> knowns = new HashSet<>();
            knowns.add("aya");
            knowns.add("ye");
            knowns.add("woo");
            knowns.add("ma");
            
            for(String babble : babbling){
                if(isValidBabble(babble, knowns)){
                    answer++;
                }
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {
        
    }
}

// import java.util.HashMap;
            // import java.util.ArrayList;
            
            // class Solution {
               
            
            //         public void Combis(HashMap<String,Integer> M, ArrayList<String> ret, String[] knowns, int idx, String cur) {
            //         if (cur.length() > 30) return;
            
            //         for (int i = 0; i < knowns.length; i++) {
            //             if (i == idx) continue;
            //             String next = cur + knowns[i];
            //             ret.add(next);
            //             M.put(next,1);
            //             Combis(M, ret, knowns, i, next);
            //         }
            //     }
               
            //     public int solution(String[] babbling) {
            //         int answer = 0;
            //         HashMap<String, Integer> map = new HashMap<>();
            //         ArrayList<String> ret = new ArrayList<String>();
            //         String[] knowns = {"aya","ye", "woo", "ma"};
                   
            //         Combis(map, ret, knowns, -1, "");
                   
            //         for(String babble : babbling){
            //              if(map.getOrDefault(babble,0)>0){
            //                  answer++;
            //              }
            //         }
            //         return answer;
            //     }
            // }


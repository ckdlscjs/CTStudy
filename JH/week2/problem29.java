package week2;
import java.util.HashMap;

public class problem29 {
    class Solution {
        
        static class Pair{
            int y;
            int x;
            Pair(int y, int x){
                this.y = y;
                this.x = x;
            }
        }
        public String solution(String[] survey, int[] choices) {
            
            HashMap<Character,Pair> map = new HashMap<>();
            String[] tmp = {"RT", "CF", "JM", "AN"};
            int[][] chrs = new int[4][2];
            
            for(int i = 0;i<4;i++){
                for(int j = 0;j<2;j++){
                    chrs[i][j] = 0;
                    map.put(tmp[i].charAt(j), (new Pair(i,j)));
                }
            }
            
            int n = survey.length;
            
            for(int i = 0;i<n;i++){
                Character L = survey[i].charAt(0);
                Character R = survey[i].charAt(1);
                Pair L_pair = map.get(L);
                Pair R_pair = map.get(R);
                int num = choices[i];
                if(num>4){ // 오른쪽 5 6 7 
                    chrs[R_pair.y][R_pair.x] += (num - 4);  
                }else if(num<4){ // 왼쪽 1 2 3 
                    chrs[L_pair.y][L_pair.x] += (4-num);  
                }
                // Pair L_idx = 
            }
            
            String answer = "";
            for(int i = 0;i<4;i++){
                if(chrs[i][0] == chrs[i][1]){
                    if(tmp[i].charAt(0) > tmp[i].charAt(1)){
                        answer += tmp[i].charAt(1);
                    }else{
                        answer += tmp[i].charAt(0);
                    }
                }else{
                    if(chrs[i][0] > chrs[i][1]){
                        answer += tmp[i].charAt(0);
                    }else{
                        answer += tmp[i].charAt(1);
                    }
                }
            }
            
            return answer;
        }

    }
    public static void main(String[] args) {
        
    }
}
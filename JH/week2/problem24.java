package week2;

import java.util.ArrayList;
public class problem24 {

    static class Solution {
        public int solution(int[] ingredient) {
            // 1,2,3 빵 야채 고기
            ArrayList<Integer> st = new ArrayList<Integer>();
            int n = ingredient.length;
            int answer = 0;
            for(int i = 0;i<n;i++){
                st.add(ingredient[i]);
                if(!st.isEmpty() && st.size()>=4){
                    int m = st.size();
                    if(st.get(m-1) == 1 && st.get(m-2) == 3 
                    && st.get(m-3) == 2 && st.get(m-4) == 1){
                        for(int j= 0;j<4;j++){
                            st.remove(st.size()-1);
                        }
                        answer++;
                    }
                }    
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        
    }
}

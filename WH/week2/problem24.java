import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0; i < ingredient.length; i++){
            list.add(ingredient[i]);
            while(list.size() >= 4){
                int n = list.size();
                if(!(list.get(n - 1) == 1
                    && list.get(n - 2) == 3
                    && list.get(n - 3) == 2
                    && list.get(n - 4) == 1))break;
                for(int j = 0; j < 4; j++){
                    list.remove(list.size() - 1);
                }
                answer++;
            }
        }
        return answer;
    }
}

두번째 풀이 배열 인덱스를 활용한 풀이 시간복잡도 O(n)
  class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int answer = 0;
        int idx = 0;
        
        for(int i : ingredient){
            stack[idx++] = i;
            if(idx >= 4 && stack[idx -1] == 1
              && stack[idx - 2] == 3
              && stack[idx - 3] == 2
              && stack[idx - 4] == 1){
                answer++;
                idx -= 4;
            }
        }
        return answer;
    }
}

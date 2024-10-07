package week2;

import java.util.Deque;
import java.util.ArrayDeque;

public class problem23 {

    static class Solution {
        public String solution(int[] food) {
            Deque<Integer> deq = new ArrayDeque<Integer>();

            deq.addLast(0);
            for (int i = food.length-1;i>-1;i--){
                int cnt = food[i]/2;
                while(cnt-- >0){
                    deq.addLast(i);
                    deq.addFirst(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!deq.isEmpty()){
                sb.append(deq.pollFirst());
            }
            String result = sb.toString();
            return result;
        }
    }

    public static void main(String[] args) {
        
    }
}



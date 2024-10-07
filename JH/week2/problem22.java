
package week2;

import java.util.PriorityQueue;

public class problem22 {

    static class Solution {
        public int solution(int k, int m, int[] score) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    
            for(int i = 0;i<score.length;i++){
                pq.add(score[i]);
            }
            
            int answer = 0;
            while(!pq.isEmpty() && pq.size() % m !=0){
                pq.poll();
            }
            
            while(!pq.isEmpty() && pq.size() >= m){
                int cur = pq.peek();
                for(int i = 0;i<m;i++){
                    pq.poll();
                }
                answer += cur * m;
            }
            
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }

}

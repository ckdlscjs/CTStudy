package week1;

import java.util.PriorityQueue;

public class problem20 {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            for(int i = 0;i<score.length;i++){
                answer[i] = 0 ; // initialization
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0;i<score.length;i++){
                
                if(pq.size()<k){
                    pq.add(score[i]);
                }else{
                    if(pq.peek() < score[i]){
                        pq.add(score[i]);    
                        pq.poll();
                    }
                    
                }
                
                if(pq.size()>k){
                    answer[i] = pq.poll();
                }else{
                    answer[i] = pq.peek();
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

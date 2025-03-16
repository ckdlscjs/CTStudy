package week20;

import java.util.PriorityQueue;

public class Problem413 {
    static PriorityQueue<Integer> que = new PriorityQueue<>();
    public static void main(String[] args) {

    }
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int time = 0;
        for(int player : players){

            while(!que.isEmpty() && que.peek()<=(time)){
                que.poll();
            }
            int size = que.size();
            if(size == 0){
                if(m <= player){
                    int times = (int) Math.ceil( player/m);

                    for(int j = 0;j<times;j++){
                        que.offer(time+k);
                    }
                    answer+=times;
                }
            }else{
                int diff = player - m * size;
                if(diff>0){
                    int times = (int) Math.ceil( diff / m);

                    answer+=times;
                    for(int j = 0;j<times;j++){
                        que.offer(time+k);
                    }
                }
            }
            // System.out.println(answer);
            time++;
        }
        return answer;
    }
}

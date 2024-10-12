package week2;

public class problem37 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            
            // 0의 개수 파악 
            // int cnt = 0;
            // for(int i = 0;i<6;i++){
            //     if(lottos[i]==0){
            //         cnt++;
            //     }
            // }
            
            int m = 0;
            int M = 0;
            for(int i = 0;i<6;i++){
                if(lottos[i]==0){
                    M+=1;
                    continue;
                }
                
                boolean flag = false;
                for(int j = 0;j<6;j++){
                    if(lottos[i] == win_nums[j]){
                        m+=1;
                        M+=1;
                        break;
                    }
                }
                
            }
            
            int[][] tears =  {{6,1},{5,2},{4,3},{3,4},{2,5},{1,6}};
            int M_tear = 0;
            int m_tear = 0;
            for(int i =0;i<6;i++){
                if(tears[i][0]==M){
                    M_tear = tears[i][1];
                }
                
                if(tears[i][0]==m){
                    m_tear = tears[i][1];
                }
            }
    
            answer[0] = (M_tear == 0) ? 6 : M_tear;
            answer[1] = (m_tear == 0) ? 6 : m_tear;
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

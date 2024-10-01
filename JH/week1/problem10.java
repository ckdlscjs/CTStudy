package week1;

// import java.util..;

public class problem10 {
    
        class Solution {
        
            public enum DIRECTION{
                    E, W, S, N
            }

            public int[] solution(String[] park, String[] routes) {
                
                int[] dy = {0,0,1,-1};
                int[] dx = {1,-1,0,0};

                int n = park.length;
                int m = park[0].length();
                
                int s_y = -1;
                int s_x = -1;
                for(int i = 0;i<n;i++){
                    for(int j =0;j<m;j++){
                        if(park[i].charAt(j) == 'S'){
                            s_y = i;
                            s_x = j;
                        }
                    }
                    if(s_y!=-1) break;
                }
                int[] answer = {s_y, s_x};


                for(String order : routes){
                    String[] dire_dist = order.split(" ");
                    int dist = Integer.parseInt(dire_dist[1]);
                    int dire = DIRECTION.valueOf(dire_dist[0]).ordinal();
                    
                    boolean flag = false; // 1. park 바깥으로 나가거나 도중에 'X'를 만나는 경우 

                    int[] tmp = {s_y, s_x};
                    for(int i = 0;i<dist;i++){
                        tmp[0] = tmp[0] + dy[dire];
                        tmp[1] = tmp[1] + dx[dire];
                        if(tmp[0] <0 || tmp[0] >=n || tmp[1] < 0 || tmp[1] >= m){
                            flag = true;
                            break;
                        }
                        if(park[tmp[0]].charAt(tmp[1]) == 'X'){
                            flag = true;
                            break;
                        }
                    }

                    if(flag){
                        tmp[0] = s_y;
                        tmp[1] = s_x;
                        continue;
                    }else{
                        answer[0] = tmp[0];
                        answer[1] = tmp[1];
                        s_y = tmp[0];
                        s_x = tmp[1];
                    }
                }

                return answer;
        }
    }
   
    public static void main(String[] args) {
        
    }
}

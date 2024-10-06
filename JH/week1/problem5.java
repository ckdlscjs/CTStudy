package week1;

public class problem5 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            
            int cur_health = health;
            int cur_time = 0;
            int t = bandage[0];
            int x = bandage[1];
            int y = bandage[2];
            
            for(int[] attack : attacks){
                int attack_time = attack[0];
                int attack_damage = attack[1];
                
                int differ_time =  attack_time - cur_time -1;
                
                if(differ_time >= t){
                    cur_health += y * (differ_time /t); 
                    System.out.println(y*differ_time/t + " " + y*(differ_time/t));
                    // 유의할 점 똑바로 괄호 치자. 
                    // y*differ_time 이 먼저 계산될 수도 있다.
                    // 그것과 differ_time/t이 먼저 계산되는 게 다르다.
                    // 6 5 <- case 1에서부터 다르다.
                }
                cur_health += x * differ_time;
                
                if(cur_health>=health){
                    cur_health = health;
                }
                
                cur_health -= attack_damage;
                if(cur_health<=0){
                    break;
                }
                cur_time = attack_time;
            }
            return (cur_health > 0) ? cur_health : -1;
        }
    }
    
    public static void main(String[] args) {
        
    }    
}

// 구현 문제
import java.util.Arrays;

public class Problem43 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 1 4 7 -> 왼
        // 3 6 9 -> 오
        // 2 5 8 0은 거리 -> 어떻게 구함? -> 맨해튼 거리 
        // 
        int L = 10;
        int R = 12;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<numbers.length;i++){ // O(|numbers|)
            // O(1) 
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                L = numbers[i];
                sb.append("L");
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                R = numbers[i];
                sb.append("R");
            }
            else{
                
                int[] L_place = findPlace(L);
                int[] R_place = findPlace(R);
                int[] cur_place = findPlace(numbers[i]);

                int L_dist = findDist(L_place, cur_place);
                int R_dist = findDist(R_place, cur_place);

                if(L_dist == R_dist){
                    if(hand.equals("right")){
                        R = numbers[i];
                        sb.append("R");
                    }else{
                        L = numbers[i];
                        sb.append("L");
                    }
                }else{
                    if(L_dist>R_dist){
                        R = numbers[i];
                        sb.append("R");
                    }else{
                        L = numbers[i];
                        sb.append("L");
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
    
    public int[] findPlace(int num){
        int[] ret = new int[2];
  
        if (num == 0){
            ret[0] = 3; ret[1] = 1;
            return ret;
        } // num > 0
        if(num%3==0){
            ret[0] = (num/3)-1;
        }else{
            ret[0] = (num/3);
        }

        if(num%3==0){
            ret[1] = 2;
        }else if(num%3==1){
            ret[1] = 0;
        }else{ // num%3==2
            ret[1] = 1;
        }
        return ret;
    }
    
    public int findDist(int[] curPlace, int[] targetPlace){

        return Math.abs(curPlace[0]-targetPlace[0]) + Math.abs(curPlace[1]-targetPlace[1]);
    }
    
}
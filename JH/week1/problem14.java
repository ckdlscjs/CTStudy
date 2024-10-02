package week1;

import java.util.Queue;
public class problem14 {

    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            int i = 0;
            int j = 0;
            int k = 0;
            int n = goal.length;

            while(k < n){
                if(i < cards1.length && cards1[i].equals(goal[k])){
                    i++;
                }
                else if(j < cards2.length && cards2[j].equals(goal[k])){
                    j++;
                }else{
                    // System.out.println( )
                    return "No";
                }
                k++;
                
            }
            return "Yes";
        }
    }
    public static void main(String[] args) {
        
    }
}

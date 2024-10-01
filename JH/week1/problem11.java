package week1;

public class problem11 {
    class Solution {
        public int[] solution(String[] wallpaper) {
             int y_min = wallpaper.length;
            int y_max = 0;
            int x_min = wallpaper[0].length();
            int x_max = 0;
            
            for(int i = 0;i<wallpaper.length;i++){
                for(int j = 0;j<wallpaper[0].length();j++){
                    if(wallpaper[i].charAt(j) == '#'){
                            y_min = (i > y_min)? y_min : i;
                            y_max = (i > y_max)? i : y_max;
                            x_min = (j > x_min)? x_min : j;
                            x_max = (j > x_max)? j : x_max; 
                    }       
                }
            }
            // System.out.println(y_min + " " + x_min + " " + (y_max+1)   + " " + (x_max+1));
            int[] answer = {y_min, x_min, (y_max+1), (x_max+1)};
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

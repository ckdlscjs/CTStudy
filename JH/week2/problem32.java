package week2;
import java.util.Arrays;
import java.util.Comparator;

public class problem32 {
    
    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int width = (int) -0xffffff;
            int height = (int ) -0xffffff;
            
            for (int i = 0 ;i<sizes.length;i++){
                Integer[] tmp = new Integer[sizes[i].length];
                for(int j = 0;j<tmp.length;j++){
                    tmp[j] = (Integer) sizes[i][j];
                }

                Arrays.sort(tmp, Comparator.reverseOrder());
                height = (height > tmp[0])?  height : tmp[0];
                width = (width > tmp[1]) ? width : tmp[1];
                for(int j = 0;j<tmp.length;j++){
                    sizes[i][j] = tmp[j].intValue();
                }
                // System.out.println(Arrays.deepToString(tmp));

            }
            // System.out.println(height * width + " " + width);
            // System.out.println(height * width + " " + height);
            return height * width;
        }    
    }
    public static void main(String[] args) {
        
    }
}

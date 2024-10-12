package week2;

import java.util.Arrays;
import java.util.Comparator;

public class problem31 {
    
    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            for (int[] size : sizes) {
                Integer[] tmp = new Integer[size.length];
                for (int j = 0; j<tmp.length; j++) {
                    tmp[j] = (Integer) size[j];
                }
                Arrays.sort(tmp, Comparator.reverseOrder());
                for (int j = 0; j<tmp.length; j++) {
                    size[j] = tmp[j].intValue();
                }
                System.out.println(Arrays.deepToString(tmp));
            }

            return answer;
        }    
    }

    public static void main(String[] args) {
        Solution  ss = new Solution();
        int[][] sizes = new int[10][2];
        for (int i = 0;i<10;i++){
            for(int j =0;j<2;j++){
                sizes[i][j] = (i+j);
            }
        }
        ss.solution(sizes);
    }
}

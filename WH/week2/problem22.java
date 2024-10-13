import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Arrays.sort(score);
        int n = score.length;
        
        for(int i = n - m; i >= 0; i-=m){
            sum += score[i] * m;
        }
        return sum;
    }
}

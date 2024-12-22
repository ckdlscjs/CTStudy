package week4;

import java.util.Collections;

public class Problem64 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int idx = 0;
        int M = 231323;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<M){
                M = arr[i];
                idx = i; 
            }
        }
        
        int k = 0;
        int w = 0;
        while(k<arr.length){
            if(idx == k){
                k++;
                continue;
            }
            answer[w++] = arr[k++];
        }
        if(answer.length==0){
            return new int[]{-1};
        }
        return answer;
    }
}
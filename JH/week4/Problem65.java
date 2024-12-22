package week4;

import java.util.Arrays;

public class Problem65 {
    public long solution(long n) {
        int[] cnts = new int[10];
        long answer = 0;
        long tmp_ten = 10L;
        
        while(n>0){
            
            int cur = (int) (n % tmp_ten);
            cnts[cur]++;
            n/=tmp_ten;
        }
        
        long tmp = 1;
        for(int i = 0;i<10;i++){
            for(int k = 0;k<cnts[i];k++){
                answer = answer + (tmp) * (i);
                tmp *=(tmp_ten);
            } 
           
        }

        System.out.println(Arrays.toString(cnts));
        return answer;
    }
}
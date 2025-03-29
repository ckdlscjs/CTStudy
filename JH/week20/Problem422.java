package week20;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem422 {
    public static void main(String[] args) throws Exception{
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        return;
    }

    static int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[]{0, n+1};
        // System.out.println(Arrays.toString(sequence));
        // System.out.println(sequence[6]);
        int i = 0; // left pointer
        int j = 0; // right pointer

        int sum = 0;
        while(i<n){
            //System.out.println(i +  " " + (j) + " " + sum );
            if(sum >= k){
                if(sum == k){
                    if(answer[1] - answer[0] + 1 > (j-i)){
                        answer[0] = i;
                        answer[1] = j-1;
                    }
                }
                sum -= sequence[i++];
            }else{
                if(j<n)sum += sequence[j++];
            }

        }
        return answer;
    }
}

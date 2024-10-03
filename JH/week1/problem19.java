package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem19 {
    static class Solution {
        public int solution(String s) {
            int answer = 0;
            int n = s.length();
            int i = 0;
            int same = 0;
            int notSame = 0;
            // banana 
            while (i<n ) {
                char cur = s.charAt(i++);
                same = 1;
                notSame = 0;
                while(i<n){
                    if(cur == s.charAt(i)){
                        same++;
                    }else{
                        notSame++;
                    }
                    i++;
                    if(same == notSame){
                        answer++;
                        break;
                    }
                }
            }
            if(same > 0 && same!=notSame){
                answer++;
            }
            return answer;
        }
    }
    public static void main(String[] args) throws IOException {
        Solution ss = new Solution();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String in = bf.readLine();
        System.out.println(ss.solution(in));
    }
}
// abracadabra
//  ab ra ca da br a
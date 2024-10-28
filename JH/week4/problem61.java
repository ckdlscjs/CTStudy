 
import java.util.Arrays;
 
class Solution {
       public int[] solution(int n, int m) {
           int[] answer = new int[2];
           
           int gcd = euclid(n, m);
           int lcm = (n*m)/gcd;
           answer[0] = gcd;
           answer[1] = lcm;
           return answer;
       }

       private int euclid(int a, int b) {
           if(a==0){
               return b;
           }
           return euclid(b%a,a);
       }
   }



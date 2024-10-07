package week2;

import java.util.ArrayList;

public class problem21 {

    static class Solution {
        public ArrayList<Integer> sieve(int n){ // make sieve array from 1 to n 
            
            n = (int) Math.ceil(n);
            
            boolean[] flag = new boolean[n+1];

            for(int i = 0;i <=n;i++){
                flag[i]=false;
            }
            
            flag[0] = true; flag[1] = true;
            for(int i = 2;i<=n;i++){
                if(!flag[i]){
                    for(int j =2*i;j<=n;j+=i){
                        flag[j] = true;        
                    }
                }
            }

            ArrayList<Integer> ret = new ArrayList<>();

            for(int i = 2;i<=n;i++){
                if(!flag[i]){
                    ret.add(i);
                }
            }

            return ret;
        }

        public int solution(int number, int limit, int power) {
            int answer = 1;
            ArrayList<Integer> primes = sieve((int) Math.sqrt(number)); // O(317*2)

            for(int i = 2;i<=number;i++){ // pow(10,5)

                int cur_num = i;
                
                int factors = 1;
                
                for(int prime : primes){ // 최대 66 
                    int cnt = 1;
                    while (cur_num > 1 && cur_num % prime ==0) { // O(log(100000)) = 11
                        cur_num /= prime;
                        cnt++;
                    }
                    factors *= cnt;
                    if(cur_num==1){
                        break;
                    }
                }
                
                if(cur_num >1){ // 소수 체크 
                    factors*=2;
                }
                
                if(factors > limit){
                    answer+= power;
                }
                else{
                    answer += factors;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;;
/**
 * problem2
 */
public class problem2 {
    
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            return answer;
        }
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] wallet = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int [] bill = Arrays.stream(bf.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        int answer = 0;
                        
        while (max(wallet[0], wallet[1]) < max(bill[0], bill[1]) || (min(wallet[0], wallet[1]) < min(bill[0], bill[1]))){
            if (bill[0] > bill[1]){
                bill[0]/=2;
            }
            else{
                bill[1]/=2;
            }
            answer +=1;
        }
        System.out.println(answer);
    }    

    static int max(int a, int b){
        return (a>b) ? a : b;
    }

    static int min(int a, int b){
        return (a<b) ? a : b;
    }
}
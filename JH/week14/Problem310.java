package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem310 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        // 상근 -> 창영 -> 상근 -> 창영 ////
        // dp의 정의는 ?
        // 2 = 1 + 1 , 4 = 1 + 3 = 3 + 1, 6 = 3 + 3
        // 3 -> 상근
        // 4 -> 창영
        if(n%2==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}

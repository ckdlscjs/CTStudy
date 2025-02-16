package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem380 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // 보수
        // 2 -> 30 ??
        int complement = (~N + 1);
        System.out.println(Integer.bitCount(complement ^ N));
    }

}

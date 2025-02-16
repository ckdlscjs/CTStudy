package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem386 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = (~N) + 1;
        int count = Integer.bitCount(N ^ M);
        System.out.println(count);
    }

}

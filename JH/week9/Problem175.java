package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem175 {
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        solve(N, 1,3);
    }

    private static void solve(int N, int from, int to){

        if(N==0){
            return;
        }

        System.out.println(from + " " + to);
        solve(N-1, 1, 2);
        solve(N-1, 2, 3);
    }
    // 
    // 
    //  1    2     3 
}

package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

public class Problem275 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        int l = 1;
        int r = N*N;

        // N = 4
        // 1 2 3 4
        // 2 4 6 8
        // 3 6 9 12
        // 4 8 12 16
        while(l<=r){
            int mid = l+(r-l)/2;
        }
    }
}

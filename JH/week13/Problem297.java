//package week13;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//
//public class Problem297 {
//    public static void main(String[] args)
//    throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String A = bf.readLine();
//        String B = bf.readLine();
//        char[] A_chars = A.toCharArray();
//        char[] B_chars = B.toCharArray();
//
//        int N = A.length();
//        int M = B.length();
//
//        int[][] dp = new int[N + 1][M + 1];
//
//        for(int i = 1;i<=N;i++){
//            for(int j = 1;j<=M;j++){
//                if(A_chars[i-1] == B_chars[j-1]){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }
//                else{
//                    if(dp[i-1][j]>dp[i][j-1]){
//                        dp[i][j] = dp[i-1][j];
//                    }else{
//                        dp[i][j] = dp[i][j-1];
//                    }
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int i = N, j = M;
//
//        while (i > 0 && j > 0) {
//            if (A_chars[i - 1] == B_chars[j - 1]) {
//                sb.append(A_chars[i - 1]);
//                i--;
//                j--;
//            } else if (dp[i - 1][j] > dp[i][j - 1]) {
//                i--;
//            } else {
//                j--;
//            }
//        }
//
//        bw.write(dp[N][M] + "\n");
//        bw.write(sb.reverse().toString());
//        bw.newLine();
//        bw.flush();
//        bw.close();
//        bf.close();
//    }
//}
//package week13;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class Problem297 {
//    public static void main(String[] args)
//            throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String A = bf.readLine();
//        String B = bf.readLine();
//
//        int N = A.length();
//        int M = B.length();
//
//        char[] A_chars = A.toCharArray();
//        char[] B_chars = B.toCharArray();
//        int[][] dp = new int[N + 1][M + 1];
//
//        for(int i = 1;i<=N;i++){
//            for(int j = 1;j<=M;j++){
//                if(A_chars[i-1] == B_chars[j-1]){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }
//                else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                    // if(dp[i-1][j] > dp[i][j-1]){
//                    //    dp[i][j] = dp[i-1][j];
//                    //}else{
//                    //    dp[i][j] = dp[i][j - 1];
//                    //}
//                }
//            }
//        }
//
//        int i = N;
//        int j = M;
//        StringBuilder sb = new StringBuilder();
//        while(i>0 && j>0){
//            if(A_chars[i-1] == B_chars[j-1]){
//                sb.append(A.charAt(i-1));
//                i--;
//                j--;
//            }
//            else if(dp[i-1][j]>dp[i][j-1]){
//                i--;
//            }
//            else{
//                j--;
//            }
//        }
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        bw.write(dp[N][M] + "\n");
//        bw.write(sb.reverse() +"\n");
//        bw.flush();
//    }
//}

package week13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem297 {
    // Function to compute LCS length using 1D DP
    static int[] computeLCSLength(char[] A, char[] B, int N, int M) {
        int[] prev = new int[M + 1];
        int[] curr = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i - 1] == B[j - 1]) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap prev and curr
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // Hirschberg's Algorithm to find LCS
    static String hirschberg(char[] A, char[] B, int N, int M) {
        if (N == 0) return "";
        if (N == 1) {
            for (int j = 1; j <= M; j++) {
                if (A[0] == B[j - 1]) return String.valueOf(A[0]);
            }
            return "";
        }

        int mid = N / 2;

        // Compute LCS lengths from start to mid
        int[] l1 = computeLCSLength(slice(A, 0, mid), B, mid, M);

        // Compute LCS lengths from end to mid
        int[] l2 = computeLCSLength(reverse(slice(A, mid, N)), reverse(B), N - mid, M);

        // Find the partition point
        int max = -1;
        int partition = 0;
        for (int j = 0; j <= M; j++) {
            if (l1[j] + l2[M - j] > max) {
                max = l1[j] + l2[M - j];
                partition = j;
            }
        }

        // Recursively find LCS
        String lcs1 = hirschberg(slice(A, 0, mid), slice(B, 0, partition), mid, partition);
        String lcs2 = hirschberg(slice(A, mid, N), slice(B, partition, M), N - mid, M - partition);

        return lcs1 + lcs2;
    }

    // Helper function to slice a char array
    static char[] slice(char[] arr, int start, int end) {
        char[] sliced = new char[end - start];
        System.arraycopy(arr, start, sliced, 0, end - start);
        return sliced;
    }

    // Helper function to reverse a char array
    static char[] reverse(char[] arr) {
        int n = arr.length;
        char[] rev = new char[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - i - 1];
        }
        return rev;
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader bf = new BufferedReader(new FileReader("/Users/jinhojeon/codingtest_javafactory/JH/week13/2.in"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String A_str = bf.readLine();
        String B_str = bf.readLine();

        char[] A = A_str.toCharArray();
        char[] B = B_str.toCharArray();

        int N = A.length;
        int M = B.length;

        // Compute LCS string using Hirschberg's algorithm
        String lcs = hirschberg(A, B, N, M);

        // 결과 출력
        bw.write(String.valueOf(lcs.length()));
        bw.newLine();
        bw.write(lcs);
        bw.newLine();

        // 버퍼 비우기
        bw.flush();
    }
}

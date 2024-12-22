/*
    1. this is written by JIN HO JEON
    2. this problem is from BOJ 1920
 */

package week12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem245 {


    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> A = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            A.add(i, Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(bf.readLine());
        ArrayList<Integer> B = new ArrayList<>(M);

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            B.add(i, Integer.parseInt(st.nextToken()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A.sort(Comparator.comparingInt(o -> o));
        for (Integer num : B) {
            if (binarySearch(A, num)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
//        Collections.binarySearch()
    }

    static boolean binarySearch(ArrayList<Integer> A, int num) {
        int start = 0;
        int end = A.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid) == num) {
                return true;
            }
            else if (A.get(mid) < num) {
                start = mid + 1;
            }
            else if (A.get(mid) > num) {
                end = mid - 1;
            }
        }
        return false;
    }
}
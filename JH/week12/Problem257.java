
package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem257 {
    static ArrayList<Integer> sum2 = new ArrayList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        //  + N^2 + N^2 + N^2 logN

        for (int i = 0; i < N; i++) {
            int tmp = A[i];
            map.put(A[i], map.getOrDefault(tmp, 0) + 1);
            for (int j = i + 1; j < N; j++) {
                tmp += A[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        for (int i = 0; i < M; i++) {
            int tmp = B[i];
            sum2.add(tmp);
            for (int j = i + 1; j < M; j++) {
                tmp = tmp + B[j];
                sum2.add(tmp);
            }
        }

        long ret = 0;
        for (Integer sum : sum2) {
            if (map.getOrDefault(T-sum, 0)>0) {
                ret+=map.get(T-sum);
            }
        }
        System.out.println(ret);

    }
}
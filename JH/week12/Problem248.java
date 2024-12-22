
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem248 {
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int m = Integer.parseInt(bf.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            int idx = Arrays.binarySearch(arr1, Integer.parseInt(st.nextToken()));
            arr2[i] = (n > idx && idx >= 0) ? 1 : 0;
        }
        System.out.println(Arrays.stream(arr2).mapToObj(s -> s + " ").collect(Collectors.joining()));

    }
}
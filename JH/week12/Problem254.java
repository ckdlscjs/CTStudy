
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem254 {
    static int nums[][];
    static HashMap<ArrayKey, Integer> map = new HashMap<>();
    static class ArrayKey{
        int[] arr;
        int hash;

        ArrayKey(int[] arr){
            this.arr = arr;
            this.hash = Arrays.hashCode(this.arr);
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ArrayKey)) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(arr, arrayKey.arr);
        }
    }
    public static void main(String[] args)
            throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            int[] arr = nums[i];
            int[] arr_tmp = new int[N];
            for (int j = 0; j < N; j++) {
                arr_tmp[j] = arr[j];
            }

            Arrays.sort(arr_tmp);

            int[] rankVal = new int[N];
            rankVal[0] = 1;
            for (int j = 1; j < N; j++) {
                rankVal[j] = (arr_tmp[j] == arr_tmp[j - 1]) ? rankVal[j - 1] : rankVal[j - 1] + 1;
            }

            int rank = 1;
            int[] ranks = new int[N];
            for (int j = 0; j < N; j++) {
                int val = arr[j];
                int idx = Arrays.binarySearch(arr_tmp, val);
                ranks[j] = rankVal[idx];
            }

            ArrayKey key = new ArrayKey(ranks);
            map.put(key, map.getOrDefault(key, 0) + 1);

        }

        long ans = 0;
        for (int val : map.values()) {
            ans += (val - 1) * (val) / 2;
        }
        System.out.println(ans);
    }
}
package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem378 {

    static int[] dims = new int[11];

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int total = 1;
        for (int i = 0; i < 11; i++) {
            dims[i] = Integer.parseInt(st.nextToken());
            total *= dims[i];
        }

        int[] tomatoes = new int[total];

        int rows = total / dims[0]; // 가로로 전체를 나누기
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<dims[0];j++){
                tomatoes[dims[0]*i + j] = Integer.parseInt(st.nextToken());
            }
        }

        // 토근 별로 이동

        int days = 0;
        boolean[] visited = new boolean[total];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            if (tomatoes[i] == 1) {
                q.add(i);
                visited[i] = true;
            }
        }

        int[] coords = new int[11]; // temporary coords
        while (!q.isEmpty()) {
            boolean isRipened = false;
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                indexToCoord(cur, coords, dims);

                for (int dim = 0; dim < 11; dim++) {

                    if (coords[dim] + 1 < dims[dim]) {
                        coords[dim] ++;
                        int nxt = toIndext(coords, dims);
                        if(!visited[nxt] && tomatoes[nxt] == 0) {
                            tomatoes[nxt] = 1;
                            q.add(nxt);
                            visited[nxt] = true;
                            isRipened = true;
                        }
                        coords[dim]--; // return like backtracking
                    }

                    if (coords[dim] - 1 >= 0) {
                        coords[dim] --;
                        int nxt = toIndext(coords, dims);
                        if(!visited[nxt] && tomatoes[nxt] == 0) {
                            tomatoes[nxt] = 1;
                            q.add(nxt);
                            visited[nxt] = true;
                            isRipened = true;
                        }
                        coords[dim]++;
                    }
                }
            }

            if (isRipened) {
                days++;
            }
        }

        for (int i = 0; i < total; i++) {
            if (tomatoes[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(days);
        //

    }

    private static int toIndext(int[] coords, int[] dim) {
        int idx = 0;
        int mul = 1;
        for (int i = 0; i < 11; i++) {
            idx += mul * coords[i];
            mul *= dim[i];
        }
        return idx;
    }

    private static void indexToCoord(int cur, int[] coords, int[] dims) {
        for (int i = 0; i < 11; i++) {
            coords[i] = cur%dims[i];
            cur/=dims[i];
        }
    }

}

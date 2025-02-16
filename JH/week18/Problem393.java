package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem393 {
    static int[][] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        parents = new int[20][N+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            parents[0][i] = Integer.parseInt(st.nextToken());
        }

        preprocessing(N);


        int q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int query = 0; query < q; query++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    private static void preprocessing(int N) {

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
        return;
    }

    private static int findLCA(int n, int x) {

        for(int i = 0;n>0; i++) {
            if ( (n & 1)!=0) {
                x = parents[i][x];
            }
            n>>=1;
        }
        return x;
    }
}

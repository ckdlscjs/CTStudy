package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem394 {

    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    static int[] depth;
    static int[][] parents;
    static final int LOG = 19;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }
        parents = new int[LOG+1][N+1];
        depth = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a).add(b);
            G.get(b).add(a);
        }

        Arrays.fill(depth, -1);
        calculDepth(1, 0, -1);
        preprocessing(N);

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append('\n');
        }
        System.out.print(sb);

    }

    private static void calculDepth(int cur, int prev, int dist) {

        parents[0][cur] = prev;
        depth[cur] = dist + 1;

        for(int nxt : G.get(cur)) {
            if (depth[nxt] == -1) {
                calculDepth(nxt, cur, depth[cur]);
            }
        }

    }

    private static void preprocessing(int n) {

        for(int depth = 1; depth < LOG; depth++) {
            for (int i = 1; i <= n; i++) {
                parents[depth][i] = parents[depth-1][parents[depth-1][i]];
            }
        }
    }

    private static int findLCA(int a, int b) {

        // depth가 같을 때까지

        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int diff = depth[b] - depth[a];
        for (int i = 0; diff > 0; i++) {
            if ((diff & 1) > 0) {
                b = parents[i][b];
            }
            diff >>= 1;
        }

        // 같다면 리턴
        if(a==b) return a;

        // 같지 않다면 같을 때까지
        // for (int k = LOG; k >= 0; k--) {
        for(int k = 0;k<=LOG;k++){
            if(parents[k][a]!=parents[k][b]) {
                a = parents[k][a];
                b = parents[k][b];
            }
        }
        return parents[0][a]; //
    }
}

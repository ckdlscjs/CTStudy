package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem396 {
    static ArrayList<ArrayList<int[]>> G = new ArrayList<>();
    static int[][] parents;
    static long[] dists;
    static int[] counts;
    static int[] depths;
    static final int LOG = 20;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dists = new long[N+1];
        counts = new int[N+1];
        depths = new int[N+1];
        parents = new int[LOG+1][N+1];

        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b, c});
            G.get(b).add(new int[]{a, c});
        }


        Arrays.fill(depths, -1);
        DFS(1, 0, 0, 0);
        Initialization(N);
        int q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                sb.append(dists[b] + dists[c] - 2L * dists[findLCA(b, c)]).append('\n');
            }
            else{
                int k = Integer.parseInt(st.nextToken());
                sb.append(getKthElement(b, c, k)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static int getKthElement(int b, int c, int k) {
        int lca = findLCA(b, c);
        int distB = depths[b] - depths[lca];
        int distC = depths[c] - depths[lca];
        if (distB + 1 >= k) {
            return findThatLCA(b, k-1);
        }else{
            return findThatLCA(c, distB + distC + 1 - k);
        }
    }

    private static int findThatLCA(int b, int k) {
        for (int i = 0; k > 0; i++) {
            if((k& 1) > 0){
                b = parents[i][b];
            }
            k>>=1;
        }
        return b;
    }

    private static void DFS(int cur, int prev, int depth, long dist) {

        dists[cur] = dist;
        depths[cur] = depth;
        parents[0][cur] = prev;

        for(int[] nxt : G.get(cur)) {
            int nxtNode = nxt[0];
            if(depths[nxtNode] != -1) {
                continue;
            }
            long nxtDist;
            nxtDist = (long) nxt[1] + dist;
            DFS(nxtNode, cur, depth + 1, nxtDist);

        }
    }

    private static void Initialization(int N){
        for (int i = 1; i <= LOG; i++) {
            for (int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    static int findLCA(int a, int b) {
        if(depths[a] < depths[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int diff = depths[a] - depths[b];
        for (int i = 0; diff>0; i++) {
            if ((diff & 1) > 0) {
                a = parents[i][a];
            }
            diff>>=1;
        }

        if(a==b) return a;

        for (int k = LOG; k >= 0; k--) {
            if(parents[k][a]!=parents[k][b]){
                a = parents[k][a];
                b = parents[k][b];
            }
        }

        return parents[0][a];
    }
}

package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem395 {
    static ArrayList<ArrayList<int[]>> G = new ArrayList<>(); // 관건 : 거리에 대한 LCA
    static int[][] parents;
    static int[] dists;
    static int[] depths;
    static final int LOG = 17;

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }
        parents = new int[LOG+1][N + 1];
        dists = new int[N+1];
        depths = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b, c});
            G.get(b).add(new int[]{a, c});
        }

        DFS(1, 0, 0, 0);
        Initialize(N);
        int q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dists[a] + dists[b] - 2*dists[findLCA(a, b)]).append('\n');
        }
        System.out.print(sb);
    }

    private static void DFS(int cur, int prev, int depth, int dist) {

        parents[0][cur] = prev;
        depths[cur] = depth;
        dists[cur] = dist;

        for (int[] nxtNode : G.get(cur)) {
            int nxtNum = nxtNode[0];
            if (nxtNum == prev) {continue;}
            int nxtVal = nxtNode[1];
            DFS(nxtNum, cur, depth+1, dist+nxtVal);
        }
    }

    private static void Initialize(int N){

        for(int i = 1;i<=LOG;i++){
            for (int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    private static int findLCA(int a, int b){

        if(depths[a] > depths[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }

        int diff = depths[b] - depths[a];

        for (int i = 0; i <= LOG; i++) {
            if(0 < (diff & 1)) {
                b = parents[i][b];
            }
            diff >>= 1;
        }
        if (a == b) {
            return a;
        }

        for (int k = LOG; k >= 0; k--) {
            if(parents[k][a]!=parents[k][b]){
                a = parents[k][a];
                b = parents[k][b];
            }
        }
        return parents[0][a];
    }
}

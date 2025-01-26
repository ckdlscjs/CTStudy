package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem329 {

    static int[] dist;
    static int result = -1;

    static ArrayList<ArrayList<Pair>> G = new ArrayList<ArrayList<Pair>>();
    static class Pair {
        int nxtNode;
        int dist;

        Pair(int nxtNode, int dist) {
            this.nxtNode = nxtNode;
            this.dist = dist;
        }
    }

    private static void dfs(int x) {
        for(Pair nxt : G.get(x)) {
            int nxtNode = nxt.nxtNode;
            int nxtDist = nxt.dist;
            if (dist[nxtNode] == -1) {
                dist[nxtNode] = dist[x] + nxtDist;
                dfs(nxtNode);
            }
        }
    }

    public static void main(String[] args)
            throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0;i<=n;i++){
            G.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            G.get(a).add(new Pair(b, d));
            G.get(b).add(new Pair(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            dist = new int[n+1];
            Arrays.fill(dist, -1);
            dist[a] = 0;
            dfs(a);
            sb.append(dist[b]).append('\n');
        }
        System.out.print(sb);
    }
}

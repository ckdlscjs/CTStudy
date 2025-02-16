package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem392 {
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    static int[] depth;
    static int[] parents;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0 ;i<=N;i++){
            G.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a).add(b);
            G.get(b).add(a);
        }

        parents = new int[N + 1];
        depth = new int[N + 1];
        Arrays.fill(depth, -1);
        parents[0] = -1;
        DFS(1, 0);
        // dfs for setting parent
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

    private static void DFS(int cur, int prev) {
        if (depth[cur] != -1) {
            return;
        }

        parents[cur] = prev;
        depth[cur] = depth[prev] + 1;
        for(int nxt : G.get(cur)) {
            if (depth[nxt] == -1) {
                DFS(nxt, cur);
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while(depth[a]!=depth[b]) {
            a = parents[a];
        }

        if (a == b) {
            return a;
        }

        while(true){
            a = parents[a];
            b = parents[b];
            if(a == b) {
                return a;
            }
        }
    }
}

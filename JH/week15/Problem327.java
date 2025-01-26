package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem327 {
    static int[] nodes;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    private static void dfs(int x){

        nodes[x] = 1;
        visited[x] = true;
        for(int nxt : G.get(x)){
            if(!visited[nxt]){
                dfs(nxt);
                nodes[x] += nodes[nxt];
            }
        }
    }
    public static void main(String[] args)
    throws  Exception{
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        nodes = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a-1).add(b-1);
            G.get(b-1).add(a-1);
        }

        dfs(R-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            int node = Integer.parseInt(bf.readLine())-1;
            sb.append(nodes[node]).append('\n');
        }
        System.out.print(sb);
    }
}

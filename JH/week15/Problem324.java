package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem324 {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        parents = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 1;i<n;i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=n;i++){
            sb.append(parents[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int x){
        if(visited[x]) return;

        visited[x] = true;

        for(int nxt : adjList.get(x)){
            if(!visited[nxt]){
                parents[nxt] = x;
                dfs(nxt);
            }
        }

        return;
    }
}
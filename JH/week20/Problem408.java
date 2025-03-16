package week20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem408 {
    static int sccSCC = 0;
    static int index;
    static int[] visited = new int[100_001];
    static int[] low_lev = new int[100_001];
    static int[] sccId = new int[100_001];

    static boolean[] onStack = new boolean[100_001];
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> G = new ArrayList();
    public static void main(String[] args)
    throws Exception{
        for(int j = 0;j<=100_000;j++){
            G.add(new ArrayList<>());
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(bf.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            for(int i = 0;i<=N;i++){
                G.get(i).clear();
            }

            sccSCC = 0;
            index = 0;
            stack.clear();
            onStack = new boolean[N+1];
            visited = new int[N+1];
            low_lev = new int[N+1];

            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                G.get(a).add(b); // x -> y
            }

            for(int i = 1;i<=N;i++){
                if(visited[i] == 0) {
                    SCC(i);
                }
            }

            int[] indegree = new int[100_001];
            Arrays.fill(indegree, 0);
            for(int u = 1; u<=N;u++){
                for(int v : G.get(u)){
                    if(sccId[u]!=sccId[v]){
                        indegree[sccId[v]]++;
                    }
                }
            }

            int res = 0;
            for(int i = 1;i<=sccSCC;i++){
                if(indegree[i]==0){
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    private static void SCC(int i){
        visited[i] = low_lev[i] = ++index;
        onStack[i] = true;
        stack.push(i);

        for(int nxtNode : G.get(i)){
            if(visited[nxtNode] == 0){
                SCC(nxtNode);
                low_lev[i] = Math.min(low_lev[i], low_lev[nxtNode]);
            }
            else if(onStack[nxtNode]){
                low_lev[i] = Math.min(low_lev[i], visited[nxtNode]);
            }
        }

        if(low_lev[i] == visited[i]){
            sccSCC++;
            while (!stack.isEmpty()) {
                int v = stack.pop();
                onStack[v] = false;
                sccId[v] = sccSCC;
                if (i == v) break; // SCC의 Root 노드를 꺼냈다면 종료
            }
            // scc의 scc는 언제 종료조건인 걸까?
        }
    }
}

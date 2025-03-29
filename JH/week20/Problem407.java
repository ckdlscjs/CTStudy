package week20;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem407 { // SCC
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    static int[] visited = new int[100_001];
    static int[] low_lev = new int[100_001];
    static int index = 0;
    static boolean[] onStack = new boolean[100_001];
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args)
    throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a).add(b);
            // BCC aG.get(b).add(a);
        }

        for(int i = 1;i<=N;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }

        if(!res.isEmpty()) Collections.sort(res,
                (a,b) -> Integer.compare(a.get(0), b.get(0)));
        System.out.println(res.size());
        for(ArrayList<Integer> l : res){
            System.out.println(l.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    static void dfs(int cur)
    {
        visited[cur] = low_lev[cur] = ++index;
        onStack[cur] = true;
        stack.push(cur);

        for(int nxt : G.get(cur)) {
            if(visited[nxt]==0){
                dfs(nxt);
                low_lev[cur] = Math.min(low_lev[cur], low_lev[nxt]);
            }
            else if(onStack[nxt]){
                // cur low_lev &
                low_lev[cur] = Math.min(low_lev[cur], visited[nxt]);
            }
        }

        if(visited[cur] == low_lev[cur]){
            ArrayList<Integer> temp = new ArrayList<>();
            while(true){
                int v = stack.pop();
                onStack[v] = false;
                temp.add(v);
                if(v == cur){
                    break;
                }
            }
            Collections.sort(temp);
            temp.add(-1);
            res.add(temp);
        }
    }
=======
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem407 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0;i<N;i++)

    }

>>>>>>> 66019fa (??)
}

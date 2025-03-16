package week20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem409 {
    static ArrayList<ArrayList<Integer>> G = new ArrayList();
    static ArrayList<Edge> stack = new ArrayList<>();
    static int index;
    static boolean[] isCycle;
    static int[] low_lev;
    static int[] visited;
    static class Edge{
        int u;
        int v;
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        low_lev = new int[n+1];
        visited = new int[n+1];
        isCycle = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            G.add(new ArrayList<>());
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a).add(b);
            G.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            if(visited[i] == 0){
                BCC(i,0);
            }
        }


        while(!stack.isEmpty()){
            ArrayList<Integer> comp = new ArrayList<>();
            while(!stack.isEmpty()){
                Edge e = stack.remove(stack.size()-1);
                if(!comp.contains(e.u)){comp.add(e.u);}
                if(!comp.contains(e.v)){comp.add(e.v);}
            }
            if(comp.size()>=3){
                // System.out.println(comp);
                for(int vex : comp){
                    if(isCycle[vex]){
                        System.out.println("Not cactus");
                        return;
                    }
                    isCycle[vex] = true;
                }
            }
        }

        System.out.println("Cactus");

    }
    static void BCC(int cur, int prev){
        visited[cur] = low_lev[cur] = ++index;

        for(int nxt : G.get(cur)){
            if(nxt == prev){
                continue;
            }
            else if(visited[nxt] == 0){
                stack.add(new Edge(cur, nxt));
                BCC(nxt,cur);
                low_lev[cur] = Math.min(low_lev[cur], low_lev[nxt]);

                if(low_lev[cur] <= visited[nxt]){
                    // BCC 갱신
                    ArrayList<Integer> comp = new ArrayList<>();
                    while(!stack.isEmpty()){
                        Edge e = stack.remove(stack.size()-1);
                        if(!comp.contains(e.u)){comp.add(e.u);}
                        if(!comp.contains(e.v)){comp.add(e.v);}
                        if(e.u == cur && e.v == nxt){ break;}
                    }

                    if(comp.size()>=3){
                        // System.out.println(comp);
                        for(int vex : comp){
                            if(isCycle[vex]){
                                System.out.println("Not cactus");
                                System.exit(0);
                            }
                            isCycle[vex] = true;
                        }
                    }
                    return;
                }

            }
            else if(visited[cur] > visited[nxt]){ // back edge 처리
                // if(visited[nxt]>=low_lev[cur]){
                stack.add(new Edge(cur, nxt));
                low_lev[cur] = Math.min(low_lev[cur], visited[nxt]);
            }
        }
    }
}

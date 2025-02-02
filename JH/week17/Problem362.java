package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem362 {
    static ArrayList<int[]> edges = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0;i<=M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a,b,c});
        }
        int min = kruskal(N, true);
        int max = kruskal(N, false);
        System.out.println(max * max - min * min);
    }
    static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if (aa !=bb) {
            parent[aa] = bb;
        }
    }

    static int kruskal(int N, boolean reverse){
        for(int i = 0;i<=N;i++){
            parent[i] = i;
        }

        if (reverse) {
            edges.sort(
                    (a,b) -> Integer.compare(b[2], a[2])
            );
        }else{
            edges.sort(
                    (a, b) -> Integer.compare(a[2], b[2])
            );
        }

        int countUP = 0;
        for(int i = 0;i<edges.size();i++){
            if (find(edges.get(i)[0]) != find(edges.get(i)[1])) {
                union(edges.get(i)[0], edges.get(i)[1]);
                if (edges.get(i)[2] == 0) {
                    countUP++;
                }
            }
        }

        return countUP;
    }
}

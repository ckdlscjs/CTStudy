package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem364 { // 전기가 부족해 : boj 10423

    static class Edge {
        int x;
        int y;
        int weight;

        Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static Edge[] Edges;
    static int[] generator;
    static int[] parent;

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
        }

        int m = Integer.parseInt(st.nextToken());
        Edges = new Edge[m];

        int k = Integer.parseInt(st.nextToken());
        generator = new int[k];

        st = new StringTokenizer(bf.readLine());
        int first = Integer.parseInt(st.nextToken());
        for(int j = 1;j<k;j++){
            generator[j] = Integer.parseInt(st.nextToken());
            merge(generator[j], first);
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edges[i] = new Edge(a, b, c);
        }
        Arrays.sort(Edges, (a, b) -> a.weight - b.weight);
        kruskal(n, m);
    }

    private static void kruskal(int n, int m) {

        int res = 0;
        for(int i = 0;i<m;i++){
            int x = Edges[i].x;
            int y = Edges[i].y;
            int weight = Edges[i].weight;
            if(find(x) != find(y)){
                merge(x, y);
                res += weight;
            }
        }
        System.out.println(res);
    }

    private static int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void merge(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa!=bb){
            parent[aa] = bb;
        }
    }

}

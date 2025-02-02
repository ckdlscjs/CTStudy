package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem365 { //
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        long weight;
        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    // static ArrayList<Edge> Edges = new ArrayList<Edge>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;
    static int[][] planet;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        planet = new int[N][4];
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planet[i][0] = x;
            planet[i][1] = y;
            planet[i][2] = z;
            planet[i][3] = i;
        }

        Arrays.sort(planet, Comparator.comparingInt(p -> p[0]));
        for (int i = 0; i < N - 1; i++) {
            int cost = getCost(planet[i], planet[i+1]);
            pq.add(new Edge(planet[i][3], planet[i+1][3],cost));
        }

        // === y 정렬 ===
        Arrays.sort(planet, Comparator.comparingInt(p -> p[1]));
        for (int i = 0; i < N - 1; i++) {
            int cost = getCost(planet[i], planet[i+1]);
            pq.add(new Edge(planet[i][3], planet[i+1][3],cost));
        }

        // === z 정렬 ===
        Arrays.sort(planet, Comparator.comparingInt(p -> p[2]));
        for (int i = 0; i < N - 1; i++) {
            int cost = getCost(planet[i], planet[i+1]);
            pq.add(new Edge(planet[i][3], planet[i+1][3],cost));
        }
//        for(int i = 0;i<=N-1;i++){
//            for(int j = i+1;j<N;j++){
//                int weight = Math.min(Math.abs(planet[i][0]-planet[j][0]), Math.abs(planet[i][1]-planet[j][1]));
//                weight = Math.min(weight, Math.abs(planet[i][2]-planet[j][2]));
//                Edges.add(new Edge(i,j, weight));
//            }
//        } //
        // Collections.sort(Edges);
        MST(N);
    }

    private static int find(int x ){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        int xx = find(x);
        int yy = find(y);
        if(xx != yy){
            parent[xx] = yy;
        }
    }

    private static void MST(int N) {
        int cnt = 0;
        long weight = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int a = find(e.a);
            int b = find(e.b);
            if (a != b) {
                union(a,b);
                cnt++;
                weight += e.weight;
            }
            if (cnt == N - 1) {
                break;
            }
        }
        System.out.println(weight);

    }

    static int getCost(int[] a, int[] b) {
        int dx = Math.abs(a[0] - b[0]);
        int dy = Math.abs(a[1] - b[1]);
        int dz = Math.abs(a[2] - b[2]);
        return Math.min(dx, Math.min(dy, dz));
    }
}

package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem363 {

    static int[][] gods;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        double dist;

        public Edge(int i, int j, double dist) {
            this.x = i;
            this.y = j;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.dist, other.dist);
        }
    }

    static ArrayList<Edge> Edges = new ArrayList<Edge>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        gods = new int[N][2];
        int M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            gods[i][0] = a;
            gods[i][1] = b;
        }

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                double dist = Math.sqrt(
                        Math.pow(gods[i][0] - gods[j][0], 2) +
                        Math.pow(gods[i][1] - gods[j][1], 2)
                );
                Edge edge = new Edge(i,j, dist);
                Edges.add(edge);
            }
        }

        Collections.sort(Edges);

        parent = new int[N + 1];
        for(int i = 0;i<N;i++){
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a,b);
            // res+= Math.sqrt(Math.pow(gods[a][0] - gods[b][0], 2) + Math.pow(gods[a][1] - gods[b][1], 2));
        }


        double res = 0.0;
        for(int i = 0;i<Edges.size();i++){
            int a = Edges.get(i).x;
            int b = Edges.get(i).y;
            if(find(a) != find(b)){
                union(a, b);
                res += Edges.get(i).dist;
            }
        }

        System.out.println( String.format("%.2f",res));
        // Math.round(res * 100.0) / 100.0)

    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int xx = find(x);
        int yy = find(y);
        if(xx == yy) return;
        parent[xx] = yy;
    }
}

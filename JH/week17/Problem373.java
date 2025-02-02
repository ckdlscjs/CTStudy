package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem373 { // 웜홀

    static final int INF = 1_000_000_000;
    static class Edge{
        int x;
        int y;
        int weight;
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static Edge[] Edges;
    static int[] dist;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Edges = new Edge[2*m + w];
            int index = 0;
            for(int i = 0;i<m;i++){
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Edges[index++] = new Edge(a, b, c);
                Edges[index++] = new Edge(b, a, c);
            }

            for (int k = 0; k < w; k++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Edges[index++] = new Edge(a, b, -c); // 웜홀
            }

            dist = new int[n + 1];
            Arrays.fill(dist, 0);
            if(isNegativeCycle(n)){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.print(sb);
    }

    private static boolean isNegativeCycle(int n) {


//        for (int i = 1; i <= n; i++) {
//            dp[i] = INF;
//        }
//        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            for(Edge e : Edges) {
                if (dist[e.x] != INF && dist[e.y] > dist[e.x] + e.weight) {
                    dist[e.y] = dist[e.x] + e.weight;
                }
            }
        }

        for(Edge e : Edges) {
            if (dist[e.x] != INF && dist[e.y] > dist[e.x] + e.weight) {
                return true;
            }
        }

        return false;
    }
}
// 시작점을 어떻게 잡냐는 문제를 다시 고민해야 함.
// https://www.acmicpc.net/source/88465177 -> 는 시작점을 0으로 시작
// ㅇㅎ -> for (int i = 1; i <= N; i++) {
//				edges.add(new Edge(0, i, 0));
//			} 이걸 추가했으니 결국 내가 했던 코드랑 동일하군
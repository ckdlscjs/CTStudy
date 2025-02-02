package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem372 { // 타임 머신 ; 벨만 포드
    static private class Edge{
        int x;
        int y;
        long weight;
        Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static Edge[] Edges;
    static long[] dp;
    static final long INF = 500 * 10001L;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = INF;
        }

        dp[1] = 0; // 첫 노드 초기화

        int M = Integer.parseInt(st.nextToken());
        Edges = new Edge[M];
        // 음수 사이클인 경우 -1 => end
        // 아니라면 그대로 dp값 출력 || 갈 수 없다면 -1

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edges[i] = new Edge(a, b, c);
        }

        for (int i = 2; i <= N; i++) {
            for (Edge e : Edges) {
                if (dp[e.x] != INF && dp[e.x] + e.weight < dp[e.y]) {
                    dp[e.y] = dp[e.x] + e.weight;
                }
            }
        }

        for(Edge e : Edges){ // 음수 사이클 찾기
            if(dp[e.x] != INF && dp[e.x] + e.weight < dp[e.y]){
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2;i<=N;i++){
            sb.append((dp[i] == INF) ? -1 : dp[i]).append('\n');
        }
        System.out.print(sb);
    }
}

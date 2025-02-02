package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem357 {
    static ArrayList<ArrayList<int[]>> G = new ArrayList<>();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b,c});
            G.get(b).add(new int[]{a,c});
        }

        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] dist1 = dijstra(N, 1);
        if(dist1[s] == Integer.MAX_VALUE || dist1[e] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        int[] dist2 = dijstra(N, s);
        int[] dist3 = dijstra(N, e);
        if(dist2[e] == Integer.MAX_VALUE && dist3[s] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        if(dist2[N] == Integer.MAX_VALUE && dist3[N] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(dist1[s] + dist2[e] + dist3[N], dist1[e] + dist3[s] + dist2[N]));
    }

    private static int[] dijstra(int N, int s) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );
        pq.add(new int[]{0, s});

        while(!pq.isEmpty()){
            int[] cur = pq.poll(); // node, dist
            if(cur[0] > dist[cur[1]]) continue;

            for(int[] nxtNode : G.get(cur[1])){
                int nxtDist = cur[0] + nxtNode[1];
                if (dist[nxtNode[0]] > nxtDist) {
                    dist[nxtNode[0]] = nxtDist;
                    pq.offer(new int[]{nxtDist, nxtNode[0]});
                }
            }
        }

        return dist;
    }
    // 1 -> v1 -> v2 :
}

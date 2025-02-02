package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem354 {
    static ArrayList<ArrayList<int[]>> G = new ArrayList<>();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            G.add(new ArrayList<>());
        }

        int k = Integer.parseInt(bf.readLine());
        for(int j = 0;j<m;j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b, c});
            // G.get(b).add(new int[]{a, c});
        }
        dijstra(n, k);
    }

    private static void dijstra(int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1]>dist[cur[0]]) continue;
            for (int[] nxtNode : G.get(cur[0])) {
                int nxtDist = cur[1] + nxtNode[1];
                if (nxtDist < dist[nxtNode[0]]) {
                    dist[nxtNode[0]] = nxtDist;
                    pq.offer(new int[]{nxtNode[0], nxtDist});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.println(sb.toString());
    }
}

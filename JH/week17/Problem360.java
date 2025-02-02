package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem360 {   // 면접 보는 승법이네
    static ArrayList<ArrayList<int[]>> G = new ArrayList();
    static int[] destinations;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        destinations = new int[K];
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(b).add(new int[]{a, c}); // 단방향
        } //

        st = new StringTokenizer(bf.readLine());
        for(int j = 0; j < K; j++) {
            destinations[j] = Integer.parseInt(st.nextToken());
        }
        dijstra(N, K);
    }

    private static void dijstra(int n, int k) {

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a,b) -> Long.compare(a[0], b[0])
        );
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i= 0;i<k;i++){
            pq.add(new long[]{0, destinations[i]});
            dist[destinations[i]]=0;
        }

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long curDist = cur[0];
            int curNode = (int) cur[1];
            if(cur[0] > dist[curNode]) continue;

            for (int[] nxtNode : G.get(curNode)) {
                int nxt = nxtNode[0];
                long nxtDist = cur[0] + nxtNode[1];
                if(dist[nxt] > nxtDist){
                    dist[nxt] = nxtDist;
                    pq.add(new long[]{nxtDist, nxt});
                }
            }
        }

        long maxDist = -1;
        int farthestCity = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                farthestCity = i;
            }
        }
        System.out.println(farthestCity);
        System.out.println(dist[farthestCity]);
    }
}

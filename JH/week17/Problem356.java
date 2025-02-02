package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem356 { // 다시 풀기 다익 두번
    static int[] dist;
    static int[] reversedDist;
    static ArrayList<ArrayList<int[]>> G = new ArrayList();
    static ArrayList<ArrayList<int[]>> reversedG = new ArrayList();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
            reversedG.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        reversedDist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reversedDist, Integer.MAX_VALUE);
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist[X] = 0;
        reversedDist[X] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a[0], b[0])
        );

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b, c});
            reversedG.get(b).add(new int[]{a, c});
        }

        pq.add(new int[]{0, X});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if (cur[0] > dist[cur[1]]) {
                continue;
            }

            for (int[] nxtNode : G.get(cur[1])) {
                int nxtDist = cur[0] + nxtNode[1];
                if (nxtDist < dist[nxtNode[0]]) {
                    dist[nxtNode[0]] = nxtDist;
                    pq.offer(new int[]{nxtDist, nxtNode[0]});
                }
            }
        }

        // X로부터 다른 점까지의 최단거리를 dijstra로 갱신하고

        pq2.add(new int[]{0, X});

        while(!pq2.isEmpty()){
            int[] cur = pq2.poll();
            if (cur[0] > reversedDist[cur[1]]) {
                continue;
            }
            for (int[] nxtNode : reversedG.get(cur[1])) {
                int nxtDist = cur[0] + nxtNode[1];
                if (nxtDist < reversedDist[nxtNode[0]]) {
                    reversedDist[nxtNode[0]] = nxtDist;
                    pq2.offer(new int[]{nxtDist, nxtNode[0]});
                }
            }
        }

        int res = 0;
        for (int i = 1; i <=N; i++) {
            if(dist[i] == Integer.MAX_VALUE || reversedDist[i] == Integer.MAX_VALUE){
                continue;
            }
            res = Math.max(res, dist[i] + reversedDist[i]);
        }
        System.out.println(res);
    }
}

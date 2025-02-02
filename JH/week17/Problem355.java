package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem355 { // 백준 최소비용 구하기 2
    static ArrayList<ArrayList<int[]>> G = new ArrayList();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(bf.readLine());
        for(int i = 0;i<M;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b,c});
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //
        dijstra(N, s, k);
    }

    private static void dijstra(int N, int s, int k) {
        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b[0], a[0])
        );

        pq.add(new int[]{0, s});
        prev[s] = -1;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] > dist[cur[1]]){
                continue;
            }

            for(int[] nxtNode : G.get(cur[1])){
                int nxtDist = cur[0] + nxtNode[1];
                if(dist[nxtNode[0]] > nxtDist){
                    dist[nxtNode[0]] = nxtDist;
                    prev[nxtNode[0]] = cur[1];
                    pq.add(new int[]{nxtDist, nxtNode[0]});
                }
            }
        }

        System.out.println(dist[k]);
        Deque<Integer> deq = new ArrayDeque<>();
        int last = k;
        while (last != -1) {
            deq.addFirst(last);
            last = prev[last];
        }
        System.out.println(deq.size());
        StringBuilder sb = new StringBuilder();
        for(int node : deq){
            sb.append(node).append(" ");
        }
        System.out.println(sb);
        // dijstra 역추적
    }
}

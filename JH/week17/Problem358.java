package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem358 { // 최소 비용 구하기

    static ArrayList<ArrayList<int[]>> G = new ArrayList();

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G.get(a).add(new int[]{b, c});
            // G.get(b).add(new int[]{a, c});
        }
        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a[0], b[0])
        );
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[s] = 0;
        pq.add(new int[]{0, s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] > dp[cur[1]]) {
                continue;
            }

            for (int[] nxtNode : G.get(cur[1])) {
                int nxtDist = cur[0] + nxtNode[1];
                if (dp[nxtNode[0]] > nxtDist) {
                    dp[nxtNode[0]] = nxtDist;
                    pq.add(new int[]{nxtDist, nxtNode[0]});
                }
            }
        }

        System.out.println(dp[e]);
    }
}

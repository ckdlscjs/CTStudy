package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem348 {
    static int[] times;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();

    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        times = new int[N+1];
        indegree = new int[N+1];
        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        for(int i = 1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            int cnt = Integer.parseInt(st.nextToken());
            for(int j =0;j<cnt;j++){
                int prev = Integer.parseInt(st.nextToken());
                G.get(prev).add(i);
                indegree[i]++;
            }
        }
        topologicalSort(N);
    }

    private static void topologicalSort(int N) {
        int[] dp = new int[N + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE/4);
        Arrays.fill(dp, 0); // 초기화 (0으로 설정)

        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        for(int i = 1;i<=N;i++){
            if (indegree[i] == 0) {
                dp[i] = times[i];
                result = Math.max(result, dp[i]);
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : G.get(cur)){
                dp[nxt] = Math.max(dp[nxt], dp[cur] + times[nxt]);
                result = Math.max(result, dp[nxt]);
                if(--indegree[nxt] == 0){
                    // dp[nxt] = Math.min(dp[nxt], dp[cur] + times[nxt]);
                    q.add(nxt);
                }
            }
        }

        System.out.println(result);

    }
}

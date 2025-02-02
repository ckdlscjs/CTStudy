package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem349 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] times = new int[n+1];
            int[] indegree = new int[n+1];
            ArrayList<ArrayList<Integer>> G = new ArrayList<>();
            for(int k = 0;k<=n;k++){
                G.add(new ArrayList<>());
            }

            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            for(int i=1;i<=n;i++){
                times[i] = Integer.parseInt(st.nextToken());
            }

            for(int j =0;j<m;j++){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                G.get(x).add(y);
                indegree[y]++;
            }
            // topological sort with dp
            // dp : how to build ?
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 0);

            Queue<Integer> q = new LinkedList<>();
            for(int i=1;i<=n;i++){
                if(indegree[i]==0){
                    q.add(i);
                    dp[i] = times[i];
                }
            }

            int target = Integer.parseInt(bf.readLine());

            while(!q.isEmpty()){
                int x = q.poll();
                for(int nxt : G.get(x)){
                    dp[nxt] = Math.max(dp[nxt], dp[x] + times[nxt]);
                    if(--indegree[nxt]==0){
                        q.add(nxt);
                    }
                }
            }
            System.out.println(dp[target]);
        }
    }
}

package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem345 {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    public static void main(String[] args)
    throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            G.add(new ArrayList<>());
        }

        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < a; j++) {
                int nxt = Integer.parseInt(st.nextToken());
                indegree[nxt]++;
                G.get(prev).add(nxt);
                prev = nxt;
            }
        }

        topologicalSort(n);
    }

    private static void topologicalSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append('\n');
            count++;
            for(int nxt : G.get(cur)){
                if(--indegree[nxt]==0){
                    q.add(nxt);
                }
            }
        }
        if(count !=n){
            System.out.println(0);
        }else{
            System.out.print(sb.toString());
        }
    }
}
// 위상정렬이 불가능한 경우 <=> DAG로 만들 수 없는 경우


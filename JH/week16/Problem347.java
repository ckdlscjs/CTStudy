package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem347 {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        for(int i = 0;i<=n;i++){
            G.add(new ArrayList<>());
        }

        int m = Integer.parseInt(st.nextToken());
        for(int j = 0;j<m;j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1 < 2 < 3 < 4 .. 이라는 전순서 존재하기 때문에 순서가 완전히 정해져야만 함 -> 스페셜 져지가 아님
            // 똑같은 토폴로지컬 소트에 min heap을 넣어서 해야 함
            indegree[b]++;
            G.get(a).add(b);
        }

        topologicalSort(n);

    }

    private static void topologicalSort(int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare); // min-heap

        for(int i = 1;i<=n;i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for(int nxt : G.get(cur)){
                if(--indegree[nxt]==0){
                    pq.add(nxt);
                }
            }
        }
        System.out.println(sb);
    }
}

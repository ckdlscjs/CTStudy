package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem344 {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        for(int i = 0;i<=N;i++){
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(str[1]);
        indegree = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b]++;
            G.get(a).add(b);
        }

        topologicalSort(N);
    }

    private static void topologicalSort(int N) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res =  new LinkedList<>();
        for(int i = 1;i<=N;i++){
            if(indegree[i]==0){
                queue.add(i); // initialization
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
            for (int nxt : G.get(cur)) { // indegree delete
                if(--indegree[nxt]==0){
                    queue.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int node : res) {
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString());
    }
}

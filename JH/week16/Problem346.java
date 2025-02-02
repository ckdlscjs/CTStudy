package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

 public class Problem346 {

    static int[] indegree;
    static int[] parent;
    static Map<String, Integer> index = new HashMap<>();
    static Map<Integer, String> reversedIndex = new HashMap<>();
    static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 역 토폴로지컬 소트
        indegree = new int[N + 1];
        parent = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        G.add(new ArrayList<>());
        for(int i = 1;i<=N;i++){
            String s = st.nextToken();
            index.put(s, i);
            reversedIndex.put(i, s);
            G.add(new ArrayList<>());
        }

        int M = Integer.parseInt(bf.readLine());
        for(int j = 1;j<=M;j++){
            st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            G.get(index.get(a)).add(index.get(b));
        }


        for(int i = 0;i<=N;i++){
            reversedGraph.add(new ArrayList<>());
        }

        for(int child = 1;child<=N;child++){
            for(int ancestor : G.get(child)){
                reversedGraph.get(ancestor).add(child);
            }
        }

        Arrays.fill(indegree, 0);
        for(int parent = 1; parent <=N; parent++){
            for(int child : reversedGraph.get(parent)){
                indegree[child]++;
            }
        }
        topologicalSort(N);
    }

    private static void topologicalSort(int N) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> roots = new ArrayList<>();
        Arrays.fill(parent, -1);

        for(int i = 1;i<=N;i++){
            if(indegree[i] == 0){
                q.add(i);
                roots.add(i);
            }
        }
        // component 개수 -> how ?
        while(!q.isEmpty()){
            int ancestor = q.poll();
            for(int child : reversedGraph.get(ancestor)){
                if(--indegree[child] == 0){
                    q.add(child);
                    parent[child] = ancestor;
                }
            }
        }

        ArrayList<String> rootNames = new ArrayList<>();
        for (int root : roots) {
            rootNames.add(reversedIndex.get(root));
        }
        Collections.sort(rootNames);
        System.out.println(rootNames.size());
        System.out.println(String.join(" ", rootNames));

        ArrayList<ArrayList<String>> children = new ArrayList<>();
        for(int i = 0;i<=N;i++){
            children.add(new ArrayList<>());
        }

        for(int i = 1; i<=N;i++){
            if (parent[i] != -1) {
                children.get(parent[i]).add(reversedIndex.get(i)); // i의 부모가 i의 이름을 가져감 근데 이걸 굳아? ㅇㅎ 정리
            }
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(children.get(i));
        }

        List<String> sortedNames = new ArrayList<>(index.keySet());
        Collections.sort(sortedNames);
        for (String name : sortedNames) {
            int idx = index.get(name);
            System.out.print(name + " " + children.get(idx).size() + " " + String.join(" ", children.get(idx)));
            //for(String child : children.get(idx)){
            // System.out.print(" " + child);
            // }
            System.out.println();
        }
    }
}

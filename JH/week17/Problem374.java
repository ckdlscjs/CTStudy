package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem374 { // 오민식의 고민
    static class Edge{
        int x;
        int y;
        long weight;
        public Edge(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static Edge[] Edges;
    static int[] earnings;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        earnings = new int[n];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edges = new Edge[m];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edges[i] = new Edge(a,b,c);
            adj.get(a).add(b);
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            earnings[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n+1];
        Arrays.fill(dp, Long.MIN_VALUE); // current
        dp[s] = earnings[s];

        for (int k = 0; k < n-1; k++) {
            for (Edge E : Edges) {
                if (dp[E.x] == Long.MIN_VALUE) {
                    continue;
                }
                if(dp[E.y] < dp[E.x] + earnings[E.y] - E.weight){
                    dp[E.y] = dp[E.x] + earnings[E.y] - E.weight;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] updated = new boolean[n+1];

        for (Edge edge : Edges) {
            if(dp[edge.x] == Long.MIN_VALUE){continue;}
            if(dp[edge.y] < dp[edge.x] + earnings[edge.y] - edge.weight){
                updated[edge.y] = true;
                // return;
            }
        }

        boolean[] reachable = new boolean[n+1];
        for(int i = 0;i<=n;i++){
            if(updated[i]){
                q.add(i);
                reachable[i] = true;
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            for(int nxt : adj.get(current)){
                if (!reachable[nxt]) {
                    reachable[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        if (reachable[e]) {
            System.out.println("Gee");
        }
        else if(dp[e]==Long.MIN_VALUE){
            System.out.println("gg");
        }else{
            System.out.println(dp[e]);
        }
    }
}


//
//package week17;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Problem374_notYet { // 오민식의 고민 (수정됨)
//    static class Edge {
//        int from;
//        int to;
//        int weight;
//        public Edge(int from, int to, int weight) {
//            this.from = from;
//            this.to = to;
//            this.weight = weight;
//        }
//    }
//
//    static Edge[] edges;
//    static List<List<Integer>> adj; // 인접 리스트 (from 노드 기준)
//    static int[] earnings;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//
//        int n = Integer.parseInt(st.nextToken()); // 노드 수
//        int s = Integer.parseInt(st.nextToken()); // 시작점
//        int e = Integer.parseInt(st.nextToken()); // 도착점
//        int m = Integer.parseInt(st.nextToken()); // 간선 수
//
//        edges = new Edge[m];
//        adj = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i = 0; i < m; i++) {
//            st = new StringTokenizer(bf.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            edges[i] = new Edge(a, b, c);
//            adj.get(a).add(b); // 인접 리스트 구축
//        }
//
//        st = new StringTokenizer(bf.readLine());
//        earnings = new int[n];
//        for (int i = 0; i < n; i++) {
//            earnings[i] = Integer.parseInt(st.nextToken());
//        }
//
//        long[] dp = new long[n];
//        Arrays.fill(dp, Long.MIN_VALUE);
//        dp[s] = earnings[s];
//
//        // 벨만-포드 알고리즘 수행 (n-1번)
//        for (int k = 0; k < n - 1; k++) {
//            for (Edge edge : edges) {
//                if (dp[edge.from] == Long.MIN_VALUE) continue;
//                long newProfit = dp[edge.from] + earnings[edge.to] - edge.weight;
//                if (newProfit > dp[edge.to]) {
//                    dp[edge.to] = newProfit;
//                }
//            }
//        }
//
//        // n번째 반복에서 업데이트 가능한 노드 찾기
//        boolean[] updated = new boolean[n];
//        for (Edge edge : edges) {
//            if (dp[edge.from] == Long.MIN_VALUE) continue;
//            long newProfit = dp[edge.from] + earnings[edge.to] - edge.weight;
//            if (newProfit > dp[edge.to]) {
//                updated[edge.to] = true;
//            }
//        }
//
//        // BFS를 통해 업데이트된 노드로부터 도착점 e에 도달 가능한지 확인
//        boolean[] reachable = new boolean[n];
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (updated[i]) {
//                queue.offer(i);
//                reachable[i] = true;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            for (int neighbor : adj.get(current)) {
//                if (!reachable[neighbor]) {
//                    reachable[neighbor] = true;
//                    queue.offer(neighbor);
//                }
//            }
//        }
//
//        // e가 reachable 배열에 포함되어 있는지 확인
//        if (reachable[e]) {
//            System.out.println("Gee");
//        } else if (dp[e] == Long.MIN_VALUE) {
//            System.out.println("gg");
//        } else {
//            System.out.println(dp[e]);
//        }
//    }
//}

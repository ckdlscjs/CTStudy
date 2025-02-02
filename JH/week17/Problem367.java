package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem367 { // 백양호 브레이크

    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        dist = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], 1000000);
            dist[i][i] = 0;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int j = 0;j<m;j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c == 1) {
                dist[b][a] = 0;
                dist[a][b] = 0;
            }else{ // 역방향의 개수 추가
                dist[a][b] = 0;
                dist[b][a] = 1;
            }
        }

        for(int k = 1;k<=n;k++){
            for (int i = 1; i <= n; i++) {
                if(dist[i][k] == 1000000) continue;
                for(int j = 1;j<=n;j++){
                    if(dist[k][j] == 1000000) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dist[a][b]).append('\n');
        }
        System.out.print(sb);
    }
}
// Q : 어떻게 역방향 간선에 대한 누적을 할 수 있는 거지 ?
// Q1 : 그리고 한번에 그걸 어떻게 다 찾을 수 있는 거지?

//package week17;
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Problem367_notYet {
//    public static void main(String[] args) throws IOException {
//        // Initialize BufferedReader for efficient input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // Initialize BufferedWriter for efficient output
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // Read number of buildings (nodes) and streets (edges)
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        // Define INF as a value larger than the maximum possible number of conversions
//        int INF = n + 1;
//
//        // Initialize the distance matrix
//        int[][] dist = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (i == j) {
//                    dist[i][j] = 0; // No conversion needed to stay in the same building
//                } else {
//                    dist[i][j] = INF; // Initialize other distances to INF
//                }
//            }
//        }
//
//        // Process each street and update the distance matrix accordingly
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            if (b == 0) {
//                // One-way street from u to v
//                dist[u][v] = 0; // No conversion needed in this direction
//                // To go from v to u, we need to convert this street to bidirectional
//                dist[v][u] = 1;
//            } else {
//                // Bidirectional street between u and v
//                dist[u][v] = 0;
//                dist[v][u] = 0;
//            }
//        }
//
//        // Execute Floyd-Warshall algorithm to compute all-pairs minimum conversions
//        for (int k = 1; k <= n; k++) {
//            for (int i = 1; i <= n; i++) {
//                // If there's no path from i to k, skip
//                if (dist[i][k] == INF) continue;
//                for (int j = 1; j <= n; j++) {
//                    // If there's no path from k to j, skip
//                    if (dist[k][j] == INF) continue;
//                    // Update the minimum conversions if a better path is found through k
//                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
//                        dist[i][j] = dist[i][k] + dist[k][j];
//                    }
//                }
//            }
//        }
//
//        // Read the number of queries
//        int k_queries = Integer.parseInt(br.readLine());
//
//        // Process each query and write the result
//        for (int i = 0; i < k_queries; i++) {
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            bw.write(dist[s][e] + "\n");
//        }
//
//        // Flush and close the BufferedWriter
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}

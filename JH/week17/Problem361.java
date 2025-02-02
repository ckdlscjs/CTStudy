package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem361 {
    static ArrayList<ArrayList<int[]>> G = new ArrayList();
    static ArrayList<int[]> edges = new ArrayList();
    static int[] parent;
    public static void main(String[] args)
            throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // G.get(a).add(new int[]{b, c});
            // G.get(b).add(new int[]{a, c});
            edges.add(new int[]{a, b, c});
        }
        MST(N);
    }

    private static void MST(int N) {
        // kruskal mst
        edges.sort(Comparator.comparingInt(a -> a[2]));
        parent = new int[N + 1];
        for(int i = 0;i<=N;i++){
            parent[i] = i;
        }

        int mstCount = 0;
        int edgeCount = 0;
        int M = -1;

        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            int weight = edge[2];

            if (find(nodeA) != find(nodeB)) {
                merge(nodeA, nodeB);
                mstCount+= weight;
                M = Math.max(M, weight);
                edgeCount++;
                if (N - 1 == edgeCount) {
                    System.out.println(mstCount - M);
                    return;
                }
            }
        }

        System.out.println(-1);

    }

    private static void mstPrim(){

    }

    private static int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    private static void merge(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) {
            return;
        }

        parent[aa] = bb;

    }

}

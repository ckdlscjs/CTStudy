package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem405 {
    static int[] nums;
    static int[] tree;
    static int[] lazy;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int height = 1 + (int) Math.ceil(Math.log10(N) / Math.log10(2));
        int treeSize = (int) Math.pow(2, height);
        tree = new int[treeSize];
        lazy = new int[treeSize];

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                update(1, 0, N - 1, b, c);
            }
            else{
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1,0, N - 1, b, c)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static int query(int node, int start, int end, int queryLeft, int queryRight) {
        if(lazy[node]!=0) popLazy(node, start, end);

        if(end < queryLeft || start > queryRight){
            return 0;
        }

        if(queryLeft<= start && end <= queryRight){
            return tree[node];
        }

        int mid = start + (end - start)/2;
        int lSum = query(node<<1, start, mid, queryLeft, queryRight);
        int rSum = query(node<<1|1, mid+1, end, queryLeft, queryRight);
        return lSum + rSum;
    }

    private static void update(int node, int start, int end, int queryLeft, int queryRight) {
        if(lazy[node]!=0) popLazy(node, start, end);
        if(end < queryLeft || start > queryRight){
            return;
        }

        if(queryLeft<= start && end <= queryRight){
            tree[node] = (end-start+1) - tree[node];
            if(start!=end){
                lazy[node<<1]^=1;
                lazy[node<<1|1]^=1;
            }
            return;
        }

        int mid = start + (end - start)/2;
        update(node<<1, start, mid, queryLeft, queryRight);
        update(node<<1|1, mid+1, end, queryLeft, queryRight);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    private static void popLazy(int node, int start, int end) {
        tree[node] = (end-start+1) - tree[node];
        if(start!=end){
            lazy[node<<1] ^=1;
            lazy[node<<1|1] ^=1;
        }
        lazy[node] = 0;
    }

}

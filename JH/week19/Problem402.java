package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem402 {
    static long[] nums;
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(bf.readLine());
        }

        int height = ((int) Math.ceil(Math.log10(N) / Math.log10(2))) + 1;
        int treeSize = (int) Math.pow(2, height);
        tree = new long[treeSize];
        lazy = new long[treeSize];
        build(1, 0, N - 1);
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < (M + K); j++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                long d = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, b, c, d);

            }
            else if(a==2){
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;

                sb.append(query(1, 0, N - 1, b, c)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start+end)/2;
        build(node << 1, start, mid);
        build(node << 1|1, mid + 1, end);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    private static void update(int node, int start, int end, int changeStart, int changeEnd, long val) {
        if (lazy[node] != 0L) {
            popLazy(node, start, end);
        }

        if (end < changeStart || start > changeEnd) {
            return;
        }

        if (changeStart <= start && end <= changeEnd) {
            long range = (end - start + 1L);
            tree[node] += range * val;
            if(start!=end){ // not leaf node
                lazy[node<<1] += val;
                lazy[node<<1|1] +=val;
            }
            return;
        }
        int mid = start + (end - start)/2;
        update(node << 1, start, mid, changeStart, changeEnd, val);
        update(node << 1 | 1, mid + 1, end, changeStart, changeEnd, val);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    private static long query(int node, int start, int end, int queryStart, int queryEnd) {
        // lazy pop
        if(lazy[node] != 0L) {
            popLazy(node, start, end);
        }

        if(start > queryEnd || end < queryStart) {
            return 0L;
        }

        if(queryStart <= start && end <= queryEnd) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        long lSum = query(node<<1, start, mid, queryStart, queryEnd);
        long rSum = query(node << 1 | 1, mid + 1, end, queryStart, queryEnd);
        return lSum + rSum;
    }

    //
    private static void popLazy(int node, int start, int end){
        long range = (end - start + 1L);
        tree[node] += range * lazy[node];
        if (start != end) { // not leaf node
            lazy[node<<1] += lazy[node];
            lazy[node<<1|1] += lazy[node];
        }
        lazy[node] = 0;
        return;
    }
}

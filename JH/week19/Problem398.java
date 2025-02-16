package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem398 {
    static final int MOD = 1_000_000_007;
    static long[] nums;
    static long[] tree;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        nums = new long[N];
        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(bf.readLine());
        }
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int height = (int) Math.pow(2, 1 + Math.ceil(Math.log10(N) / Math.log10(2)));
        tree = new long[height + 1];
        build(1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (M + K); i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                long c = Integer.parseInt(st.nextToken());
                // change
                update(N, b - 1, c);
            }else if(a==2){
                int c = Integer.parseInt(st.nextToken());
                // query
                sb.append(query(1, 0, N - 1, b - 1, c - 1)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void update(int N, int b, long c) {
        long div = nums[b];
        update(1, 0, N - 1, b, c, div);
    }

    private static void update(int node, int start, int end, int idx, long val, long div) {
        if (idx < start || end < idx) {
            return;
        }

        tree[node]/= div;
        if(start==end){
            tree[node] = val;
            return;
        }
        int mid = start + (end - start)/2;
        update(node << 1, start, mid, idx, val, div);
        update(node << 1 | 1, mid + 1, end, idx, val, div);
        tree[node] = (tree[node << 1] * tree[node << 1 | 1]) % MOD;
    }

    private static void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        build(node << 1, start, mid);
        build((node << 1) | 1, mid + 1, end);
        // tree[node] = tree[node << 1] * tree[ (node << 1) | 1];
        tree[node] = (tree[2 * node] * tree[2 * node + 1]) % MOD;
    }

    private static long query(int node, int start, int end, int queryLeft, int queryRight) {
        if(end < queryLeft || queryRight < start ){
            return 1;
        }

        if(queryLeft<= start && end <= queryRight){
            return tree[node];
        }
        int mid = (start+end)/2;
        return (query(node << 1, start, mid, queryLeft, queryRight)
                * query(node << 1 | 1, mid + 1, end, queryLeft,
                queryRight)) % MOD;
    }

}
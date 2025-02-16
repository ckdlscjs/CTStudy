package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem403 {
    static int[] nums;
    static int[] tree;
    static int[] lazy;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int height = (int) Math.pow(2, 1 + (int) Math.ceil((Math.log(N) / Math.log(2))));
        tree = new int[height];
        lazy = new int[height];

        build(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, b, c, d);
            }else if(a==2){
                int b = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, b)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void build(int node, int start, int end){
        if(start==end){
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;
        build(node << 1, start, mid);
        build(node << 1 | 1, mid + 1, end);
        tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
    }

    private static void update(int node, int start, int end, int queryLeft, int queryRight, int val) {

        if (lazy[node] != 0) {
            popLazy(node, start, end);
        }

        if (end < queryLeft || queryRight < start) {
            return;
        }

        if(queryLeft <= start && end <= queryRight){
            int range = end - start + 1;
            tree[node] = (range %2==1) ? tree[node]^val : tree[node];
            if (start != end) {
                lazy[node<<1] ^= val;
                lazy[node << 1 | 1] ^= val;
            }
            return;
        }

        int mid = (start+end)/2;
        update(node<<1, start, mid, queryLeft, queryRight, val);
        update(node<<1 | 1, mid + 1, end, queryLeft, queryRight, val);
        tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
    }

    private static int query(int node, int start, int end, int idx) {

        if(lazy[node]!=0){
            popLazy(node, start, end);
        }

        if(idx < start || end < idx){
            return 0; // xor default
        }

        if (start == end) {
            return tree[node];
        }

        int mid = (start + end)/2;
        return query(node<<1, start, mid, idx)
                ^ query(node<<1 | 1, mid + 1, end, idx);
    }

    private static void popLazy(int node, int start, int end){
        tree[node] = (end-start+1)%2==1 ? tree[node] ^ lazy[node] : tree[node];
        if(start!=end){
            lazy[node<<1] ^= lazy[node];
            lazy[node<<1|1] ^= lazy[node];
        }
        lazy[node] = 0;
    }
}

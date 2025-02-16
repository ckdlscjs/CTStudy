package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem406 {
    static long[] nums;
    static long[] tree;
    static ArrayList<long[]> updates = new ArrayList<>();
    static ArrayList<int[]> orders = new ArrayList<>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        int height = 1 + (int) Math.ceil(Math.log10(N) / Math.log10(2));
        int treeSize = (int) Math.pow(2, height);
        tree = new long[treeSize];

        build(1, 0, N - 1);


        int Q = Integer.parseInt(bf.readLine());
        int cnt = 0;
        for(int i = 0;i<Q;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                updates.add(new long[]{b-1, c});
            }else{
                int k = Integer.parseInt(st.nextToken()) ;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                orders.add(new int[]{k, b, c, cnt++});
            }
        }

        Collections.sort(orders, Comparator.comparingInt(a -> a[0]));

        StringBuilder sb = new StringBuilder();
        int upIdx = 0;
        long[] ans = new long[cnt];
        for(int[] query : orders){

            while(upIdx < query[0] && upIdx < updates.size()){
                long[] cur = updates.get(upIdx);
                int curIdx = (int) cur[0];
                update(N, curIdx, cur[1]);
                upIdx++;
            }
            ans[query[3]] = query(1, 0, N - 1, query[1], query[2]);
        }

        for (int i = 0; i < cnt; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void build(int node, int start, int end) {
        if(start==end){
            tree[node] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        build(node<<1, start, mid);
        build(node<<1|1, mid + 1, end);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    private static void update(int node, int start, int end, int idx, long val) {
        if (idx < start || end < idx) {
            return;
        }

        tree[node]+=val;
        if (start != end) {
            int mid = start + (end - start) / 2;
            update(node << 1, start, mid, idx, val);
            update(node << 1 | 1, mid + 1, end, idx, val);
            tree[node] = tree[node<<1] + tree[node << 1 | 1];
            return;
        }
    }

    private static void update(int N, int idx, long val) {
        long diff = val - nums[idx];
        nums[idx] = val;
        update(1, 0, N - 1, idx, diff);
    }

    private static long query(int node, int start, int end, int queryLeft, int queryRight) {
        if(end < queryLeft || start > queryRight){
            return 0;
        }

        if(queryLeft<= start && end <= queryRight){
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        long lSum = query(node<<1, start, mid, queryLeft, queryRight);
        long rSum = query(node<<1|1, mid + 1, end, queryLeft, queryRight);
        return lSum + rSum;
    }
}


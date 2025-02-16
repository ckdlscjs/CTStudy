package week19;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem397 { // segment tree 구간합 구하기
    static private long[] tree;
    static private long[] nums;

    public static void main(String[] args)
    throws Exception{
         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        double v = ceil(log10(N) / log10(2));
        int height = (int) pow(2, v + 1);
        tree = new long[height+1];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(bf.readLine());
        }
        init(1, 0, N - 1); // segment tree 초기화
        System.out.println(Arrays.toString(tree));
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < (M + K); j++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(N, b, c);
            }
            else if (a==2){
                int c = Integer.parseInt(st.nextToken());
                c--;
                sb.append(query(1, 0, N - 1, b, c)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void init(int node, int left, int right) {

        // tree[node] =
        if(left == right) {

            tree[node] = nums[left];
            return;
        }
        int mid = (right + left)/2;
        init(2 * node, left, mid);
        init(2 * node + 1, mid + 1, right);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    static long query(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if(queryRight < nodeLeft || nodeRight < queryLeft ) return 0L;

        if (queryLeft <=  nodeLeft && nodeRight <= queryRight) {
            return tree[node];
        }

        int mid = (nodeRight + nodeLeft)/2;
        return query(2*node, nodeLeft, mid, queryLeft, queryRight) + query(2*node + 1, mid + 1, nodeRight, queryLeft, queryRight);
    }

    static void update(int node, int left, int right, int idx, long target) {
        if(idx<left || idx>right) return;


        tree[node] += target;
        if(left == idx && idx == right){
            return;
        }

        int mid = (left+right)/2;
        update(2 * node, left, mid, idx, target);
        update(2 * node + 1, mid + 1, right, idx, target);
        return;
    }

    static void update(int N, int idx, long target) {
        long cur = target - nums[idx];
        nums[idx]+=cur;
        update(1, 0, N - 1, idx, cur);
    }
}

// int log_2

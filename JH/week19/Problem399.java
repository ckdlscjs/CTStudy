package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem399 {
    static int[] nums;
    static int[][] tree;

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        int height = ((int) Math.ceil(Math.log10(N) / Math.log10(2))) + 1;
        int treeSize = (int) Math.pow(2, height);

        tree = new int[treeSize][2];
        for (int i = 0; i < height; i++) {
            tree[i][0] = Integer.MAX_VALUE; // min
            tree[i][1] = Integer.MIN_VALUE; // max
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        StringBuilder sb = new StringBuilder();
        build(1, 0, N - 1);
        for(int j = 0;j<M;j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            //
            int[] res = query(1, 0, N - 1, a, b);
            sb.append(res[0] + " " + res[1]).append('\n');
        }
        System.out.print(sb);

    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node][0] = nums[start];
            tree[node][1] = nums[start];
            return;
        }

        int mid = (start+end)/2;

        build(node << 1, start, mid);
        build(node << 1 | 1, mid + 1, end);
        tree[node][0] = Math.min(tree[node<<1][0], tree[node<<1|1][0]);
        tree[node][1] = Math.max(tree[node<<1][1], tree[node<<1|1][1]);
        return;
    }

    static int[] query(int node, int start, int end, int queryLeft, int queryRight) {

        if (end < queryLeft || start > queryRight) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        if(queryLeft<= start && end <= queryRight){
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        int[] Left = query(node<<1, start, mid, queryLeft, queryRight);
        int[] Right = query(node << 1 | 1, mid + 1, end, queryLeft, queryRight);
        return new int[]{Math.min(Left[0], Right[0]), Math.max(Left[1], Right[1])};
    }
}

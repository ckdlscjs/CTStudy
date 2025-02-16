package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem404 {
    static int[] nums;
    static int[][] tree; // minprefix, sum
    static int[] lazy;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            nums[i] = (s.charAt(i) - '(')==0? 1 : -1;
        }

        int height = 1 + (int) Math.ceil(Math.log10(s.length()) / Math.log10(2));
        int treeSize = (int) Math.pow(2, height);
        tree = new int[treeSize][2];

        for(int i =0;i<treeSize;i++){
            tree[i][0] = 0;
            tree[i][1] = Integer.MAX_VALUE;
        }

        build(1, 0, s.length() - 1);


        int N = Integer.parseInt(bf.readLine());
        int res = 0;
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(bf.readLine())-1;
            // update
            // query -> check -> yes ? +1 => no ? continue
            update(s.length(), idx);
            int[] resQ = query(1, 0, s.length() - 1, 0, s.length() - 1);
            if (resQ[0] == 0 && resQ[1] >= 0) {
                res += 1;
            }
        }
        System.out.println(res);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node][0] = nums[start];
            tree[node][1] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(node << 1, start, mid);
        build(node << 1 | 1, mid + 1, end);
        tree[node][0] = tree[node << 1][0] + tree[node << 1 | 1][0];
        tree[node][1] = Math.min(tree[node << 1][1], tree[node << 1][0] + tree[node << 1 | 1][1]);
    }

    static void update(int node, int start, int end, int idx, int val) {

        if(idx < start || end < idx) return;

        if(start==end){
            tree[node][0] += val;
            tree[node][1] = tree[node][0];
            return;
        }

        int mid = (start + end)/2;
        update(node << 1, start, mid, idx, val);
        update(node << 1|1, mid + 1, end, idx, val);
        tree[node][0] = tree[node<<1][0] + tree[node<<1|1][0];
        tree[node][1] = Math.min(tree[node << 1][1], tree[node << 1][0] + tree[node << 1 | 1][1]);
    }

    static void update(int N, int idx) {

        int oldVal = nums[idx];
        nums[idx] = -oldVal;
        int diff = nums[idx] - oldVal;
        update(1, 0, N - 1, idx, diff);
    }

    static int[] query(int node, int start, int end, int queryLeft, int queryRight) {
        if(end < queryLeft || start > queryRight) return new int[]{0, Integer.MAX_VALUE};

        if(queryLeft <= start && end <= queryRight) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int[] Left = query(node<<1, start, mid, queryLeft, queryRight);
        int[] Right = query(node<<1|1, mid + 1, end, queryLeft, queryRight);

        return new int[]{Left[0] + Right[0], Math.min(Left[1], Left[0] + Right[1])};
    }
}

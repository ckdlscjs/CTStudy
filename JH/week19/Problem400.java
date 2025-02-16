package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem400 {
    static int[] nums;
    static int[][] tree;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int v = (int) Math.ceil(Math.log10(N) / Math.log10(2));
            int height = (int) Math.pow(2, v + 1);

            nums = new int[N];
            tree = new int[height][2];

            for (int i = 0; i < N; i++) {
                nums[i] = i;
            }

            build(1, 0, N - 1);
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    // change each other
                    int val1 = nums[b];
                    int val2 = nums[c];
                    update(N, b, val2);
                    update(N, c, val1);
                }
                else if(a==1){
                    // query
                    int[] query = query(1, 0, N - 1, b, c);
                    boolean isSame = isPartialSum(b, c, query);

                    sb.append(isSame ? "YES" : "NO").append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    static void build(int node, int start, int end){
        if(start==end){
            tree[node][0] = nums[start];
            tree[node][1] = nums[start];
            return;
        }
        int mid = (start + end)/2;
        build(node << 1, start, mid);
        build(node << 1|1, mid + 1, end);
        tree[node] = new int[]{
                     Math.min(tree[node << 1][0], tree[node << 1 | 1][0]),
                     Math.max(tree[node << 1][1], tree[node << 1 | 1][1])
                };
        return;
    }

    static int[] query(int node, int start, int end, int queryLeft, int queryRight){

        if(end < queryLeft || queryRight < start){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        if(queryLeft <= start && end<= queryRight){
            return tree[node];
        }

        int mid = (start + end)/2;
        int[] Left = query(node << 1, start, mid, queryLeft, queryRight);
        int[] Right = query(node << 1 | 1, mid + 1, end, queryLeft, queryRight);
        return new int[]{Math.min(Left[0], Right[0]), Math.max(Left[1], Right[1])};
    }

    static void update(int node, int start, int end, int idx, int val) {
        if (idx < start || end < idx) {
            return;
        }

        if (start == end) {
            nums[idx] = val;
            tree[node][0] = val;
            tree[node][1] = val;
            return;
        }
        int mid = start + (end - start)/2;
        update(node << 1, start, mid, idx, val);
        update(node << 1 | 1, mid + 1, end, idx, val);
        tree[node] = new int[]{
                Math.min(tree[node << 1][0], tree[node << 1 | 1][0]),
                Math.max(tree[node << 1][1], tree[node << 1 | 1][1])
        };
    }

    static void update(int N, int idx, int val) {
        update(1, 0, N - 1, idx, val);
    }

    static boolean isPartialSum(int s, int e, int[] query){
        return s == query[0] && e == query[1];
    }
}

// 1
// 5 3
// 0 0 3
// -> 0 1 2 3 4 => 3 1 2 0 4
// 0 1 4
// -> 0 4 2 3 1
// 1 1 3
// 합이 같더라도 순서가 다를 수 있음
// 3 5 4
// 6 5 3 => 그래서 => 최대 최소로 해야 함

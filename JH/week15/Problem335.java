package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem335 {
    static int[] parent;

    static int findParent(int x){
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void merge(int a, int b){
        int aa = findParent(a);
        int bb = findParent(b);
        if (aa == bb) {
            return;
        }
        parent[aa] = bb;
    }

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 1;i<=n;i++){
            parent[i] = i;
        }

        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(bf.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (order == 1) {
                int aa = findParent(a);
                int bb = findParent(b);
                sb.append(
                        (aa == bb) ? "YES" : "NO"
                ).append('\n');
            }else{
                merge(a, b);
            }
        }
        System.out.print(sb);
    }
}

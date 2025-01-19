package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.lang.model.element.NestingKind;

public class Problem336 {
    static int[] parents;
    static int idx = 0;
    static int findParent(int x ){
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }

    static void merge(int a, int b){
        int aa = findParent(a);
        int bb = findParent(b);
        if (aa == bb) {
            return;
        }
        parents[aa] = bb;
        return;
    }

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            parents = new int[n+1];

            for(int i = 1;i<=n;i++){
                parents[i] = i;
            }

            int m = Integer.parseInt(bf.readLine());
            for (int i = 1; i <= m; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                merge(a,b);
            }

            int q = Integer.parseInt(bf.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<q;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int aa = findParent(a);
                int bb = findParent(b);
                sb.append( (aa==bb) ? "1\n" : "0\n");
            }
            System.out.printf("Scenario %d:\n",++idx);
            System.out.println(sb);
        }
    }
}

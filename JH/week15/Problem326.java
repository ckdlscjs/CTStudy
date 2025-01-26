package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem326 {

        static ArrayList<ArrayList<Integer>> G;
        static int[] chk;
        public static void main(String[] args)
                throws java.io.IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int c = 1;
            while(true){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                if(n==0 && m==0) break;
                chk = new int[n+1];
                G = new ArrayList<>(n);
                for (int i = 0; i <= n; i++) {
                    G.add(new ArrayList<>());
                }

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(bf.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    G.get(a).add(b);
                    G.get(b).add(a);
                }

                int tree = 0;
                for (int i = 1; i <= n; i++) {
                    if (chk[i]==0) {
                        if(isTree(i, 0)){
                            tree++;
                        }
                    }
                }

                if(tree==0){
                    sb.append(String.format("Case %d: No trees.\n", c++));
                }
                else if(tree==1){
                    sb.append(String.format("Case %d: There is one tree.\n", c++));
                }else{
                    sb.append(String.format("Case %d: A forest of %d trees.\n", c++, tree));
                }
            }
            System.out.print(sb.toString());
        }

        private static boolean isTree(int i, int prev) {

            chk[i] = 1;
            for (int nxt : G.get(i)) {
                if (nxt == prev) {
                    continue;
                }
                if(chk[nxt]==0){
                    if(!isTree(nxt, i)) return false;
                }
                else if(chk[nxt]==1){
                    return false;
                }
            }
            chk[i] = 2;
            return true;
    }
}

package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem338 {
    static int MAX = (Integer) (1_000_000);
    static int[] parent = new int[MAX + 1];
    static int[] sizes = new int[MAX + 1];

    static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void marge(int a, int b){
        int aa = findParent(a);
        int bb = findParent(b);
        if(aa==bb){
            return;
        }
        if(sizes[aa]>sizes[bb]){
            sizes[aa] += sizes[bb];
            parent[bb] = aa;
        }else if(sizes[aa]<sizes[bb]){
            sizes[bb] += sizes[aa];
            parent[aa] = bb;
        }else{ // size가 같으면
            if (aa > bb) {
                sizes[aa] += sizes[bb];
                parent[bb] = aa;
            }else{
                sizes[bb] += sizes[aa];
                parent[aa] = bb;
            }
        }
        return;
    }

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(int i = 0;i<=MAX;i++){
            parent[i] = i;
            sizes[i] = 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            String[] str = bf.readLine().split(" ");
            String a = str[0];
            if (a.equals("I")) {
                int b = Integer.parseInt(str[1]);
                int c = Integer.parseInt(str[2]);
                marge(b,c);
            }
            else{
                int c = Integer.parseInt(str[1]);
                sb.append(sizes[c]).append("\n");
                System.out.println("c : "  + c);
                System.out.println("val : "  + sizes[c]);
                for(int k = 1;k<=20;k++){
                    System.out.print(sizes[k] + " ");
                }
            }
        }
        System.out.println();
        System.out.println(sb);
    }
}

package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem175 {

    static boolean[] chk = new boolean[9];
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chk = new boolean[N+1];
        Arrays.fill(chk, false);
        solve(N, M,0);
        System.out.print(sb.toString());
    }

    private static void solve(int n, int m, int cnt) {

        if (m == cnt) {
            // System.out.println(list.stream().map(s -> s.toString()).collect(Collectors.joining(" ")));
            for (int cur : list) {
                sb.append(cur).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1;i<= n;i++){
            if(chk[i]) continue;
            chk[i] = true;
            list.add(i);
            solve(n, m, cnt+1);
            chk[i] = false;
            list.remove(list.size()-1);
        }
    }
}
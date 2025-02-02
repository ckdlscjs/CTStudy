package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem369 { //  택배
    static int[][] dist;
    static int[][] detour;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        dist = new int[n+1][n+1];
        detour = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dist[i], 100000000);
            dist[i][i] = 0;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
            detour[a][b] = b;  // 초기 직접 경로는 목적지 자체로 설정
            detour[b][a] = a;
        }


        for(int k = 1;k<=n;k++){
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(i==j || i==k || j==k){continue;}
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        detour[i][j] = (detour[i][k] == 0) ? k : detour[i][k];
                        //detour[i][j] = k;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if (detour[i][j] == 0) {
                    sb.append("- ");
                }else{
                    sb.append(detour[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

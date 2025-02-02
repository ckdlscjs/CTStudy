package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem371 {

    static final long INF = 1_000_000_000L;
    static long[][] dist;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        dist = new long[N][N];

        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;  // 자기 자신으로의 거리는 0
        }


        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            long c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for(int k = 0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                   dist[i][j] =  Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long minCycle = INF;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(i==j) continue;
                minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
            }
        }

        System.out.println((minCycle == INF) ? -1 : minCycle);
    }
}

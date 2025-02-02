package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem368 {
    static int[][] dist;
    public static void main(String[] args)
            throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dist = new int[N + 1][N + 1];
        for(int i = 1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 1;j<=N;j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1;i<=N;i++){
            for(int j = 1;j<=N;j++){
                for(int k = 1;k<=N;k++){
                    if (i == k || j == k || i == j) {
                        continue;
                    }
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int res = 0;

        for(int i = 1;i<=N;i++){
            for(int j = i+1;j<=N;j++){
                boolean isDirect = true;
                for(int k = 1;k<=N;k++){
                    if(k!=i && k!=j && dist[i][j] == dist[i][k] + dist[k][j]){
                        isDirect = false;
                        break;
                    }
                }

                if(isDirect){
                    res += dist[i][j];
                }
            }
        }
        System.out.println(res);
    }
}

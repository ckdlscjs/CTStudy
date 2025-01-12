package week14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem314 {
    static int[][] MAP;
    static int[][] DP;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int n;
    static int m;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        MAP = new int[n][m];
        DP = new int[n][m];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j]= -1;
            }
        }

        DFS(n-1, m-1);
        System.out.println(DP[n-1][m-1]);
    }

    private static int DFS(int y, int x) {

        if (y == 0 && x == 0) {
            DP[y][x] = 0;
            return 1;
        }

        if(DP[y][x] != -1) return DP[y][x];

        DP[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (MAP[ny][nx] > MAP[y][x]) {
                DP[y][x] += DFS(ny, nx);
            }
        }
        return DP[y][x];
    }
}

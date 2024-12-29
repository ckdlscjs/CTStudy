package week13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem281 {
     static int N;
     static int Ks  = 0;
     static int startPy;
     static int startPx;
     static int[][] heights;
     static char[][] MAP;
     static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
     static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         heights = new int[N][N];
         MAP = new char[N][N];
         for (int i = 0; i < N; i++) {
             String s = br.readLine();
             for (int j = 0; j < N; j++) {
                 MAP[i][j] = s.charAt(j);
                 if (MAP[i][j] == 'P') {
                     startPy = i;
                     startPx = j;
                 } else if (MAP[i][j] == 'K') {
                    Ks++;
                 }
             }
         }

         ArrayList<Integer> alt = new ArrayList<>();
         for (int i = 0; i < N; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             for (int j = 0; j < N; j++) {
                 heights[i][j] = Integer.parseInt(st.nextToken());
                 alt.add(heights[i][j]);
             }
         }

         Collections.sort(alt);


         int left = 0;
         int right = 0;
         int answer = Integer.MAX_VALUE;
         int len = alt.size();
         while (left<= right && right < len) {
             int lowAlt = alt.get(left);
             int highAlt = alt.get(right);

             int pH = heights[startPy][startPx];
             if (lowAlt > pH || highAlt < pH) {
                 right++;
                 continue;
             }

             if (canDeliver(lowAlt, highAlt)) {
                 answer = Math.min(answer, highAlt - lowAlt);
                 left++;
             }else{
                 right++;
             }

         }
         System.out.println(answer);
     }

    private static boolean canDeliver(int lowAlt, int highAlt) {
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;


        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startPy, startPx});
        visited[startPy][startPx] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];
            for(int i = 0;i<8;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(isOutBound(ny,nx) || visited[ny][nx]) continue;
                int height = heights[ny][nx];
                if(lowAlt<=height && height<=highAlt){
                    visited[ny][nx] = true;
                    que.offer(new int[]{ny, nx});
                    if (MAP[ny][nx] == 'K') {
                        cnt++;
                        if (cnt == Ks) {
                            return true;
                        }
                    }
                }
                // else ?
            }
        }
        return cnt == Ks;
    }

    private static boolean isOutBound(int y, int x) {
        return 0 > y || y >= N || x >= N || 0>x;
    }
}

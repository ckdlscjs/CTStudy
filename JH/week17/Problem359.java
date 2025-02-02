package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem359 { //
    static int[][] MAP;
    static int[][] walls;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        MAP = new int[n][m];
        walls = new int[n][m];
        for(int i =0;i<n;i++){
            String s = bf.readLine();
            for(int j=0;j<m;j++){
                MAP[i][j] = s.charAt(j)-'0';
            }
            Arrays.fill(walls[i], n * m + 1);
        }

        walls[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for(int j = 0;j<4;j++){
                int ny = y + dy[j];
                int nx = x + dx[j];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (MAP[ny][nx] == 0) {
                    if (walls[ny][nx] == (n * m + 1)) {
                        walls[ny][nx] = Math.min(walls[ny][nx], walls[y][x]);
                        q.add(new int[]{ny, nx});
                    }else{
                        if(walls[ny][nx] > walls[y][x]){
                            walls[ny][nx] = walls[y][x];
                            q.add(new int[]{ny, nx});
                        }
                    }
                }else{ // 1
                    if(walls[ny][nx] == (n * m + 1)) {
                        walls[ny][nx] = walls[y][x] + 1;
                        q.add(new int[]{ny, nx});
                    }else{
                        if(walls[ny][nx] > walls[y][x]+1){
                            walls[ny][nx] = walls[y][x] + 1;
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
        System.out.println(walls[n-1][m-1]);
    }
}

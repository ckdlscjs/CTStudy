package week14;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Problem322 {

    private static int[][] MAP;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        MAP = new int[101][101];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            makeDragonCurve(y, x, d, g);
        }

        int ret = countCoordi();
        System.out.println(ret);
    }

    private static int countCoordi() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (MAP[i][j] + MAP[i + 1][j] + MAP[i][j + 1] + MAP[i + 1][j + 1] == 4) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void makeDragonCurve(int y, int x, int d, int g) {
        // 오른쪽 -> 위 -> 왼쪽 -> 남
        // rotation -> add
        // rotation -> add
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int gen = 0; gen < g; gen++) {
            int size = directions.size();
            for (int idx = size - 1; idx >= 0; idx--) {
                int newDir = (directions.get(idx) + 1) % 4;
                directions.add(newDir);
            }
        }



        MAP[y][x] = 1; // 시작점 표시
        for (int dir : directions) {
            y += dy[dir];
            x += dx[dir];
            if ((0 <= y  &&  y <= 100) && (0 <= x && x <= 100)){
                MAP[y][x] = 1;
            }
        }

    }

    private static boolean isOutside(int y, int x) {
        return 0>y || y>=100 || 0>x || x>=100;
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

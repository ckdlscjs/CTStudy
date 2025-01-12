package week14;

import java.io.*;
import java.util.*;

public class Problem306 {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        Queue<Point> waterQ = new LinkedList<>();
        Queue<Point> waterNextQ = new LinkedList<>();
        Queue<Point> swanQ = new LinkedList<>();
        Queue<Point> swanNextQ = new LinkedList<>();

        Point swanStart = null, swanEnd = null;

        // 지도 입력 및 초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] != 'X') {
                    waterQ.offer(new Point(i, j));  // 물 또는 백조 있는 위치를 물 큐에 추가
                }
                if (map[i][j] == 'L') {
                    if (swanStart == null) {
                        swanStart = new Point(i, j);
                    } else {
                        swanEnd = new Point(i, j);
                    }
                }
            }
        }

        // 백조 시작 위치를 스완 탐색 큐에 추가
        swanQ.offer(swanStart);
        visited[swanStart.x][swanStart.y] = true;

        int days = 0;
        boolean found = false;

        while (!found) {
            // 백조 이동 BFS
            while (!swanQ.isEmpty() && !found) {
                Point p = swanQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'X') {
                        // 얼음을 만나면 다음 날을 위해 대기 큐에 추가
                        swanNextQ.offer(new Point(nx, ny));
                    } else {
                        // 물 또는 백조 위치면 이동
                        swanQ.offer(new Point(nx, ny));
                        if (nx == swanEnd.x && ny == swanEnd.y) {
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (found) break;

            // 얼음 녹이기 BFS
            while (!waterQ.isEmpty()) {
                Point p = waterQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (map[nx][ny] == 'X') {
                        map[nx][ny] = '.';
                        waterNextQ.offer(new Point(nx, ny));
                    }
                }
            }

            // 다음 날을 위해 큐들 갱신
            waterQ = waterNextQ;
            waterNextQ = new LinkedList<>();
            swanQ = swanNextQ;
            swanNextQ = new LinkedList<>();
            days++;
        }

        System.out.println(days);
    }
}

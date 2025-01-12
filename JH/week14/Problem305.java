package week14;

import java.io.*;
import java.util.*;

public class Problem305 {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static Set<Character> keys;
    static Map<Character, List<Point>> doorWaiting;
    static int documentCount;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 지도 확장: 한 겹 씩 여유 공간을 두어 외부 접근을 쉽게 함
            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            // 초기 열쇠 세팅
            keys = new HashSet<>();
            String keyLine = br.readLine();
            if (!keyLine.equals("0")) {
                for (char k : keyLine.toCharArray()) {
                    keys.add(k);
                }
            }

            // 방문 배열 초기화
            visited = new boolean[h + 2][w + 2];

            // doorWaiting 초기화
            doorWaiting = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                doorWaiting.put(c, new ArrayList<>());
            }

            documentCount = 0;
            bfs();

            bw.write(documentCount + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 지도 범위 내인지 체크
                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;  // 벽인 경우

                visited[nx][ny] = true;
                char cell = map[nx][ny];

                // 문서 발견
                if (cell == '$') {
                    documentCount++;
                    map[nx][ny] = '.';
                }

                // 열쇠 발견
                if (cell >= 'a' && cell <= 'z') {
                    if (!keys.contains(cell)) {
                        keys.add(cell);
                        char doorChar = Character.toUpperCase(cell);
                        List<Point> waitList = doorWaiting.get(doorChar);
                        for (Point wp : waitList) {
                            queue.offer(wp);
                        }
                        waitList.clear();
                    }
                    map[nx][ny] = '.';
                }

                // 문을 만났을 때 처리
                if (cell >= 'A' && cell <= 'Z') {
                    if (!keys.contains(Character.toLowerCase(cell))) {
                        doorWaiting.get(cell).add(new Point(nx, ny));
                        continue;
                    } else {
                        map[nx][ny] = '.';
                    }
                }

                queue.offer(new Point(nx, ny));
            }
        }
    }
}

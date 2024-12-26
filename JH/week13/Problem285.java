package week13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem285 {
//    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
//    static Deque<int[]> fireballs = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        final int[] evenDirecitons = {0, 2, 4, 6};
        final int[] oddDirecitons = {1, 3, 5, 7};
        Deque<int[]> fireballs = new ArrayDeque<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m1 = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new int[]{r, c, m1, s, d});
        }
        bf.close();
        // 맵 초기화
        ArrayDeque<int[]>[][] map = new ArrayDeque[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayDeque<>();
            }
        }
        while (k-- > 0) {

            // 1. 파이어볼 이동
            while (!fireballs.isEmpty()) {
                int[] fb = fireballs.poll();
                int newR = (fb[0] + fb[3] * dy[fb[4]]) % n;
                if(newR<0) newR+=n;
                int newC = (fb[1]+  fb[3] * dx[fb[4]]) % n;
                if(newC<0) newC+=n;
                fb[0] = newR;
                fb[1] = newC;
                map[newR][newC].offer(fb);
            }

            // 2. 병합 및 분리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count = map[i][j].size();
                    if (count > 1) {
                        int sumM = 0, sumS = 0;
                        boolean allEven = true, allOdd = true;

                        for (int l = 0;l<count;l++) {
                            int[] fb = map[i][j].poll();
                            sumM += fb[2];
                            sumS += fb[3];
                            if (fb[4] % 2 == 0) allOdd = false;
                            else allEven = false;
                        }

                        int newM = sumM / 5;
                        if (newM > 0) {
                            int newS = sumS / count;
                            int[] directions = (allEven || allOdd) ? evenDirecitons : oddDirecitons;
                            for (int d : directions) {
                                fireballs.offer(new int[]{i, j, newM, newS, d});
                            }
                        }
                    } else if (count == 1) {
                        fireballs.offer(map[i][j].poll());
                    }
                }
            }
        }

        // 결과 계산
        int result = fireballs.stream().mapToInt(fb -> fb[2]).sum();
        System.out.println(result);
    }
}

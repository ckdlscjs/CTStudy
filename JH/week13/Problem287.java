package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem287 {

    static int outsideSand = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy_sc = {2,0,-2,1,-1,1,-1,1,-1};
    static int[] dx_sc = {0,2, 0,0, 0,-1,1,1,-1};
    static int[][] scatterPatternWest = { // y 기준
            {0, -2, 5},   // 위쪽 두 칸
            {2, 0, 2},    // 위쪽 두 칸
            {-2, 0, 2},   // 아래쪽 두 칸
            {-1, -1, 10}, // 오른쪽 아래
            {1, -1, 10}, // 왼쪽 아래
            {-1, 0, 7},    // 바로 위
            {1, 0, 7},    // 바로 아래
            {-1, 1, 1},    // 오른쪽 위
            {1, 1, 1},   // 왼쪽 위
            {0, -1, 0}     // alpha 위치
    };

    static int[][] scatterPatternSouth = {
            {2, 0, 5},   // 남쪽 두칸
            {0, -2, 2},  // 왼쪽 두 칸
            {0, 2, 2},   // 오른쪽 두 칸
            {1, -1, 10}, // 위쪽 오른쪽
            {1, 1, 10},  // 아래쪽 오른쪽
            {0, -1, 7},  // 위쪽 왼쪽
            {0, 1, 7},   // 아래쪽 왼쪽
            {-1, -1, 1}, // 바로 왼쪽
            {-1,  1, 1}, // 바로 왼쪽
            {1, 0, 0}    // alpha 위치
    };
    static int[][] scatterPatternEast = {
            {0, 2, 5},  //
            {2,  0, 2},
            {-2, 0, 2},  // 위쪽 두 칸
            {-1, 1, 10}, // 왼쪽 위
            {1,  1, 10},  // 오른쪽 위
            {1, 0, 7},  // 바로 아래
            {-1, 0, 7},  // 바로 아래
            {1, -1, 1}, // 왼쪽 아래
            {-1, -1, 1},  // 오른쪽 아래
            {0, 1, 0}    // alpha 위치
    };

    static int[][] scatterPatternNorth = {
            {-2, 0, 5},  // 왼쪽 두 칸
            {0,  2, 2},   // 오른쪽 두 칸
            {0, -2, 2},   // 오른쪽 두 칸
            {-1, 1, 10},  // 아래쪽 오른쪽
            {-1, -1, 10},   // 위쪽 오른쪽
            {0, 1,  7},   // 바로 오른쪽
            {0, -1, 7},// 아래쪽 왼쪽
            {1, -1, 1}, // 위쪽 왼쪽
            {1, 1, 1},   // 바로 오른쪽
            {-1, 0, 0}    // alpha 위치
    };

    static ArrayList<int[][]> scatterPattern = new ArrayList<>();

    static int[][] MAP;

    public static void main(String[] args)
    throws Exception{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 17);

        int N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        scatterPattern.add(scatterPatternWest);
        scatterPattern.add(scatterPatternSouth);
        scatterPattern.add(scatterPatternEast);
        scatterPattern.add(scatterPatternNorth);
        // N ; 홀수
        int r = N/2;
        int c = N/2;
        int dir = 0;
        int dist = 1;
        // System.out.println(r + " " + c + " " + dist + " " + dir);
        outer:
        while (true) {
            // move
            for(int j = 0;j<dist;j++){
                int[] nextTornado = move(r, c, dir);
                int sand = MAP[nextTornado[0]][nextTornado[1]];
                MAP[nextTornado[0]][nextTornado[1]] = 0;
                scatter(nextTornado, sand, dir, N);
                if(nextTornado[0] == 0 && nextTornado[1] == 0){
                    break outer;
                }
                r = nextTornado[0];
                c = nextTornado[1];
                // System.out.println(r + " " + c + " " + dist + " " + dir);
                // print();
            }
            dir = (dir+1)%4;
            if(dir==0 || dir==2) dist++;
            // if(r==4 || c== 2) break;
        }

        System.out.println(outsideSand);
    }

    private static int[] move(int r, int c, int dir) {
        // dist :  1 -> 1 -> 2 ->  2 -> 3 -> 4 -> 4 ..
        // direct : west -> south -> east -> north -> west ...
        return new int[]{r+dy[dir], c+dx[dir]};
    }

    private static void scatter(int[] nextTornado, int sand, int dir,   int N) {
        if (sand == 0) return;

        int r = nextTornado[0];
        int c = nextTornado[1];
        int totalSpread = 0;

        // 서쪽 기준 패턴을 현재 방향에 맞게 회전시킴
        int[][] curPattern = scatterPattern.get(dir);
        for (int i = 0; i < 10; i++) {
            int ddy = curPattern[i][0];
            int ddx = curPattern[i][1];
            int percent = curPattern[i][2];

            int nr = r + ddy;
            int nc = c + ddx;

            int spread = (int) Math.floor((sand * percent) / 100.0);
            totalSpread += spread;

            if (i == curPattern.length - 1) { // alpha 위치
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    MAP[nr][nc] += (sand - totalSpread);
                } else {
                    outsideSand += (sand - totalSpread);
                }
                break;
            }

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                MAP[nr][nc] += spread;
            } else {
                outsideSand += spread;
            }
        }
    }

    private static void print(){
        System.out.println();
        for (int i = 0; i < MAP.length; i++) {
            System.out.println(Arrays.toString(MAP[i]));
        }
        System.out.println();
    }
}

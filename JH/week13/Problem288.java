package week13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem288 {
    static int len;
    static int[][] MAP;
    static boolean[][] chk;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static ArrayList<Integer> magics = new ArrayList<>();
    public static void main(String[] args)
            throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2,N);
        MAP = new int[len][len];
        chk = new boolean[len][len];
        for (int i = 0;i<len;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<len;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0;i<M;i++){
            magics.add(Integer.parseInt(st.nextToken()));
        }

        DO();

        int res = Arrays.stream(MAP)
                .flatMapToInt(Arrays::stream)
                .sum();
        System.out.println(res);

        int ret = 0;
        for(int i = 0;i<len;i++){
            for(int j=0;j<len;j++){
                if(!chk[i][j] && MAP[i][j]>0) {
                    ret = Math.max(DFS(i, j), ret);
                }
            }
        }
        System.out.println(ret);
    }

    private static void DO() {
        // divide -> rotate -> apply
        for(int i = 0; i< magics.size();i++){
            int size = (int) Math.pow(2, magics.get(i));

            for (int r_i = 0; r_i < len; r_i += size) {
                for(int r_j = 0; r_j < len; r_j += size) {
                    // rotate size : half
                    rotateSubgrid(r_i, r_j, size);
                }
            }
            // check;
            // print();
            check();
        }
    }

    private static void rotateSubgrid(int r_i, int r_j, int size) {
        int[][] tmp = new int[size][size];
        // 시계 방향 회전: (i, j) -> (j, size-1-i)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmp[j][size - 1 - i] = MAP[r_i + i][r_j + j];
            }
        }
        // 회전된 결과를 다시 MAP에 반영
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[r_i + i][r_j + j] = tmp[i][j];
            }
        }
    }

    private static void check() {
        ArrayList<int[]> melted = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (MAP[i][j] > 0 && !hasThree(i, j)) {
                    melted.add(new int[]{i, j});
                }
            }
        }

        for(int[] pos: melted){
            MAP[pos[0]][pos[1]]--;
        }
    }

    private static boolean hasThree(int y, int x) {
        int Ice = 0;
        for(int d = 0;d<4;d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            if (isOutside(ny, nx)) {
                continue;
            }
            if (MAP[ny][nx] > 0) {
                Ice++;
            }
        }
        return Ice>=3;
    }

    // check all

    private static  boolean isOutside(int y, int x) {
        return 0>y || y>= len || 0>x || x>= len;
    }



    private static int DFS(int y, int x) {
        if(isOutside(y, x) || chk[y][x] || MAP[y][x] == 0) return 0;
        int cnt = 1; // current
        chk[y][x] = true;
        cnt += DFS(y - 1, x);
        cnt += DFS(y + 1, x);
        cnt += DFS(y, x - 1);
        cnt += DFS(y, x + 1);
        return cnt;
    }

    private static void print() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }
}

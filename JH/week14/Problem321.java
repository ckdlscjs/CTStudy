package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem321 {


    static boolean[][] ladders;
    static int ret = Integer.MAX_VALUE;
    static List<Integer> oddColumns = new ArrayList<>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        ladders = new boolean[H+1][N+1];
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladders[a][b] = true;
        }

        backtracing(0, 1, 1, H, N);
        System.out.println( (ret>3) ? -1 : ret);
    }


    private static void backtracing(int cnt, int row, int col, int H, int N){

        if (cnt >= 4) {
            return;
        }

        if(simulation(N, H)){
            ret = Math.min(ret, cnt);
            return;
        }

        if (cnt == 3) {
            return;
        }
         for (int r = 1; r <= H; r++) {
            int cCol = (r==row) ? col : 1;
            // 전체 맵에 대한 사다리를 전부 체크
            // 현재 위치가 row와 같을 때는 체크해야 되는 col은 현재 칼럼부터 시작해야 하므로
            for (int c = cCol; c < N; c++) {
                // < N인 이유는 사다리를 놓을 수 없기 떄문에
                if(!ladders[r][c] && !ladders[r][c-1] && !ladders[r][c+1]){
                    ladders[r][c] = true;
                    backtracing(cnt+1, r, c+1, H, N);
                    ladders[r][c] = false;
                }
            }
        }

    }

    private static boolean simulation(int N, int H){
        for (int start = 1; start <= N; start++) {
            int cur = start;
            for(int row = 1; row <= H; row++) {
                if(ladders[row][cur]) cur++;
                else if(cur>1 && ladders[row][cur-1]) cur--;
            }
            if (cur != start) {
                return false;
            }
        }
        return true;
    }
}
//

//
//package week14;
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Problem321 {
//    static int N, M, H;
//    static boolean[][] ladder;
//    static int answer = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 입력 받기
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken()); // 세로선 개수
//        M = Integer.parseInt(st.nextToken()); // 주어진 가로선 개수
//        H = Integer.parseInt(st.nextToken()); // 점선(행) 개수
//
//        ladder = new boolean[H + 1][N + 1]; // 1-based index
//
//        // 주어진 가로선 정보 반영
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken()); // 행
//            int b = Integer.parseInt(st.nextToken()); // 열
//            ladder[a][b] = true; // 가로선 추가
//        }
//
//        // 백트래킹(DFS) 시작
//        dfs(0, 1, 1);
//
//        // 결과 출력
//        System.out.println(answer > 3 ? -1 : answer);
//    }
//
//    // 백트래킹 함수
//    static void dfs(int count, int row, int col) {
//        // 가로선을 3개 초과로 놓으면 중단
//        if (count >= 4) return;
//
//        // i번 세로선의 결과가 i번으로 도착하는지 확인
//        if (check()) {
//            answer = Math.min(answer, count);
//            return;
//        }
//
//        // 모든 가능한 위치에 가로선을 추가 시도
//        for (int r = row; r <= H; r++) {
//            int cStart = (r == row) ? col : 1; // 같은 행에서는 col부터 시작
//            for (int c = cStart; c < N; c++) {
//                // 현재 위치에 가로선을 놓을 수 있는지 확인
//                if (!ladder[r][c] && !ladder[r][c - 1] && !ladder[r][c + 1]) {
//                    ladder[r][c] = true; // 가로선 놓기
//                    dfs(count + 1, r, c + 1); // 다음 단계 탐색
//                    ladder[r][c] = false; // 가로선 제거(백트래킹)
//                }
//            }
//        }
//    }
//
//    // 현재 ladder 상태에서 i번 세로선이 i번으로 도착하는지 확인
//    static boolean check() {
//        for (int start = 1; start <= N; start++) {
//            int cur = start;
//            for (int r = 1; r <= H; r++) {
//                // 오른쪽으로 이동
//                if (cur < N && ladder[r][cur]) cur++;
//                    // 왼쪽으로 이동
//                else if (cur > 1 && ladder[r][cur - 1]) cur--;
//            }
//            // 도착 위치가 출발 위치와 다르면 실패
//            if (cur != start) return false;
//        }
//        return true;
//    }
//}

package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem290 {
    static int N, M;
    static int[][] MAP;

    // 폭발한 구슬 개수 카운트
    static int one = 0;
    static int two = 0;
    static int three = 0;

    // 방향: ↑, ↓, ←, →  (문제에서 1,2,3,4 → 0,1,2,3 로 변환)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 문제에서 사용하는 나선형 순회용 방향 배열 (기존 코드를 최대한 살림)
    static int[] other = {2, 1, 3, 0};

    // 나선형 경로를 미리 계산해두는 리스트
    // spiralIndex.get(0)은 (중앙)이므로 구슬 자리로는 사실상 1부터 사용
    static ArrayList<int[]> spiralIndex = new ArrayList<>();

    // 블리자드 마법 정보: (dir, dist)
    static ArrayList<int[]> blizards = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        initSpiralIndex(); // 나선형 인덱스 사전 계산
        solve();
    }

    /** 메인 로직 */
    private static void solve() {
        for (int[] blizzard : blizards) {
            // 1) 블리자드로 구슬 파괴
            throwBlizzard(blizzard);

            // 2) 연쇄 폭발 처리
            while (true) {
                moveBeads();   // 구슬 이동
                if (!bomb()) { // 폭발 시도
                    break;     // 더 이상 폭발이 없으면 탈출
                }
            }

            // 3) 구슬 변화 단계(그룹 → A,B)
            categorizing();
        }

        // 최종 결과 출력: 1×one + 2×two + 3×three
        System.out.println(one + 2 * two + 3 * three);
    }

    // -----------------------------------------------------------------------------
    // 1. 나선형 좌표(spiralIndex) 사전 계산
    //    (중앙에서 시작하여 왼→아래→오른→위 방식으로 달팽이 모양을 도는 좌표 순서)
    // -----------------------------------------------------------------------------
    private static void initSpiralIndex() {
        int r = N / 2;
        int c = N / 2;
        spiralIndex.add(new int[]{r, c}); // index 0: 상어가 있는 위치(중앙)

        int dir = 0;
        int dist = 1;

        // 나선형으로 (0,0)까지 훑을 때까지 계속
        outer:
        while (true) {
            for (int k = 0; k < dist; k++) {
                r += dy[other[dir]];
                c += dx[other[dir]];
                if (isOutOfBounds(r, c)) {
                    break outer;
                }
                spiralIndex.add(new int[]{r, c});
                if (r == 0 && c == 0) {
                    break outer;
                }
            }
            dir = (dir + 1) % 4;
            if (dir == 0 || dir == 2) {
                dist++;
            }
        }
    }

    // -----------------------------------------------------------------------------
    // 2. 구슬을 리스트로 변환 / 리스트를 맵에 재배치
    // -----------------------------------------------------------------------------
    /** 맵의 구슬을 spiralIndex 순서로 읽어서 리스트로 반환 */
    private static ArrayList<Integer> beadsToList() {
        ArrayList<Integer> list = new ArrayList<>();
        // spiralIndex[0]은 상어 위치(구슬 없음), 1부터 유효 구슬
        for (int i = 1; i < spiralIndex.size(); i++) {
            int r = spiralIndex.get(i)[0];
            int c = spiralIndex.get(i)[1];
            if (MAP[r][c] != 0) {
                list.add(MAP[r][c]);
            }
        }
        return list;
    }

    /** 리스트의 구슬을 spiralIndex 순서대로 다시 맵에 채움 (초과분은 버림) */
    private static void listToBeads(ArrayList<Integer> list) {
        // 맵 전체 0으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAP[i][j] = 0;
            }
        }

        // spiralIndex[0]은 상어 위치 => 항상 0 (구슬 없음)
        int idx = 0;
        for (int i = 1; i < spiralIndex.size(); i++) {
            if (idx >= list.size()) {
                break;
            }
            int r = spiralIndex.get(i)[0];
            int c = spiralIndex.get(i)[1];
            MAP[r][c] = list.get(idx++);
        }
    }

    // -----------------------------------------------------------------------------
    // 3. 블리자드로 구슬 파괴
    // -----------------------------------------------------------------------------
    /** 블리자드 한 번 시전 */
    private static void throwBlizzard(int[] blizzard) {
        int dir = blizzard[0];
        int dist = blizzard[1];

        // 상어 위치에서 dist만큼 해당 방향으로 전진하며 구슬 파괴
        int r = N / 2;
        int c = N / 2;
        for (int i = 0; i < dist; i++) {
            r += dy[dir];
            c += dx[dir];
            if (isOutOfBounds(r, c)) break;
            MAP[r][c] = 0; // 구슬 파괴
        }
    }

    // -----------------------------------------------------------------------------
    // 4. 구슬 이동(moveBeads)
    //    - 빈 칸(0)을 건너뛰며 구슬을 앞쪽으로 당긴다
    // -----------------------------------------------------------------------------
    private static void moveBeads() {
        // 구슬을 리스트로 모으기
        ArrayList<Integer> beads = beadsToList();
        // 그대로 다시 맵에 채워넣으면, 구슬 사이 빈 칸 없이 당겨진 상태가 됨
        listToBeads(beads);
    }

    // -----------------------------------------------------------------------------
    // 5. 구슬 폭발(bomb)
    //    - 4개 이상 연속 구슬 폭발 → one/two/three 카운트 증가
    //    - 한 번이라도 폭발이 일어나면 true 반환, 아니면 false
    // -----------------------------------------------------------------------------
    private static boolean bomb() {
        ArrayList<Integer> beads = beadsToList();

        boolean exploded = false;
        ArrayList<Integer> newList = new ArrayList<>();

        int i = 0;
        while (i < beads.size()) {
            int val = beads.get(i);
            int count = 1;
            // 연속 개수 세기
            while (i + 1 < beads.size() && beads.get(i + 1) == val) {
                count++;
                i++;
            }
            // 폭발 조건
            if (count >= 4) {
                exploded = true;
                switch (val) {
                    case 1: one += count; break;
                    case 2: two += count; break;
                    case 3: three += count; break;
                    default: break; // 문제상 1,2,3만 존재
                }
            } else {
                // 폭발 안 하면 그대로 리스트에 유지
                for (int k = 0; k < count; k++) {
                    newList.add(val);
                }
            }
            i++;
        }

        // 폭발 결과를 다시 맵에 반영
        listToBeads(newList);
        return exploded;
    }

    // -----------------------------------------------------------------------------
    // 6. 구슬 변화(categorizing)
    //    - 연속된 구슬 그룹을 (개수, 구슬번호) 형태로 변환
    // -----------------------------------------------------------------------------
    private static void categorizing() {
        ArrayList<Integer> beads = beadsToList();
        ArrayList<Integer> newList = new ArrayList<>();

        int i = 0;
        while (i < beads.size()) {
            int val = beads.get(i);
            int count = 1;
            while (i + 1 < beads.size() && beads.get(i + 1) == val) {
                count++;
                i++;
            }
            // A = count, B = val
            newList.add(count);
            newList.add(val);
            i++;
        }

        // 변환된 구슬을 다시 맵에 반영 (초과분은 버려짐)
        listToBeads(newList);
    }

    // -----------------------------------------------------------------------------
    // 7. 유틸 메서드
    // -----------------------------------------------------------------------------
    private static boolean isOutOfBounds(int r, int c) {
        return (r < 0 || r >= N || c < 0 || c >= N);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 블리자드 정보 읽기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1; // 1~4 → 0~3
            int dist = Integer.parseInt(st.nextToken());
            blizards.add(new int[]{dir, dist});
        }
    }
}

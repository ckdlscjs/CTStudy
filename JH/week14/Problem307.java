package week14;

import java.io.*;
import java.util.*;

public class Problem307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        int[] attempts = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            attempts[i] = Integer.parseInt(st.nextToken());
        }

        // 거리 배열: -1은 아직 방문하지 않음을 의미
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // 큐 초기화 및 로그인 시도된 비밀번호들로 다중 출발점 설정
        Deque<Integer> queue = new ArrayDeque<>();
        for (int p : attempts) {
            if(p <= N && distance[p] == -1) {
                distance[p] = 0;
                queue.offer(p);
            }
        }

        int maxSafety = 0;
        int L = Integer.toBinaryString(N).length();  // 비트 길이

        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDist = distance[current];
            // 최대 안전도 갱신
            if(currentDist > maxSafety) {
                maxSafety = currentDist;
            }
            // current의 모든 한 비트 차이 이웃 탐색
            for (int bit = 0; bit < L; bit++) {
                int neighbor = current ^ (1 << bit);  // 한 비트만 다른 이웃
                if(neighbor < 0 || neighbor > N) continue;  // 범위 벗어나면 무시
                if(distance[neighbor] == -1) {  // 아직 방문하지 않은 정점이라면
                    distance[neighbor] = currentDist + 1;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(maxSafety);
    }
}

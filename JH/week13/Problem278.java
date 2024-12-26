package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem278 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] nums = new long[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }
        long left = 0L;
        long right = 60000000000L; // 최대 시간 설정
        while (left <= right) {
            long mid = (left + right) / 2;
            long children = M;
            for (int i = 0; i < M; i++) {
                children += mid/nums[i];
            }
            //System.out.println(children);
            if (children >= N) {
                right = mid - 1L;
            }else{
                left = mid + 1L;
            }
        }
        // 이제 마지막 탐색
        // 누적 탑승 수 계산
        long time = left;
        long total = M; // 모든 놀이기구가 초기 1명씩 태움
        long minus = 1L;

        for (int i = 0; i < M; i++) {
            total += (time-minus) / nums[i];
        }
// 마지막 아이가 탑승할 놀이기구 찾기

        // 마지막 아이가 탑승할 놀이기구를 찾는다
        for (int i = 0; i < M; i++) {
            if (time % nums[i] == 0) { // 놀이기구가 비어있는지 확인
                total++; // 한 명 추가 탑승
            }
            if (total == N) { // 마지막 아이가 탑승하는 경우
                System.out.println(i + 1); // 놀이기구 번호 출력
                break;
            }
        }

    }
}

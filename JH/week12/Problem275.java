package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem275 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>();

        int maxEnd = 0; // 최대 종료점
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[]{a, b});
            maxEnd = Math.max(maxEnd, b);
            minEnd = Math.min(minEnd, b);
        }


        int[] prefix = new int[maxEnd + 2];
        for (int[] interval : arr) {
            prefix[interval[0]]++;         // 구간 시작점
            prefix[interval[1]]--;    // [interval_start, end)
        }


        for (int i = 1; i <= maxEnd; i++) {
            prefix[i] += prefix[i - 1];
        }


        int a = 0, b = 0;
        int currentLen = 0;
        int answerA = -1, answerB = -1;

        // 투 포인터 탐색
        while (b <= maxEnd) {
            if (currentLen < K) {
                currentLen += prefix[b];
                b++;
            } else {
                if (currentLen == K) {
                    System.out.println(a + " " + b);
                    return;
                }
                currentLen -= prefix[a];
                a++;
            }
        }

        // 결과 출력
        if (answerA == -1) {
            System.out.println("0 0");
        }
    }
}

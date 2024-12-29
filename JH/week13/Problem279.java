package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem279 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<long[]> arr = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr.add(new long[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        long left = 0;
        long right = Integer.MAX_VALUE;
        boolean flag = false;

        while(left<=right) {
            long mid = left + (right - left)/2;
            long cnt = 0;
            for (int i = 0; i < arr.size(); i++) {
                long A = arr.get(i)[0];
                long C = arr.get(i)[1];
                long B = arr.get(i)[2];

// mid 이하 & C 이하 중 최솟값
                long maxVal = Math.min(mid, C);

                if (maxVal >= A) {
                    // 음수가 안 되도록 주의
                    cnt += (maxVal - A) / B + 1;
                }
            }

            if (cnt % 2 == 1) {
                flag = true;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        long candidate = left;
        long totalCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            long A = arr.get(i)[0];
            long C = arr.get(i)[1];
            long B = arr.get(i)[2];
            // long maxVal = Math.min(candidate, C);
            // if (maxVal >= A) {
            //    totalCount += (maxVal - A) / B + 1;
            // }
            if(candidate>=A && candidate<=C && (candidate-A)% B == 0){
                totalCount++;
            }
        }

// 최종 확인
        if (totalCount % 2 == 1) {
            // 홀수 번 등장하므로 후보가 맞음
            System.out.println(candidate + " " + totalCount);
        } else {
            // 홀수 개 존재하는 정수가 없음
            System.out.println("NOTHING");
        }

    }
}

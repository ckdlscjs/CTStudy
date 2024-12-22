//package week12;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Problem274 {
//    public static void main(String[] args)
//            throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[][] nums = new int[n][m];
//        int[][] students = new int[n*m][2]; // 4 * 3 = 12
//        for (int i = 0; i < n; i++) { // i = 3 -
//            st = new StringTokenizer(bf.readLine());
//            for (int j = 0; j < m; j++) {
//                // nums[i][j] = Integer.parseInt(st.nextToken());
//                students[i*m+j][0] = Integer.parseInt(st.nextToken());
//                students[i*m+j][1] = i;
//            }
//        }
//        Arrays.sort(students, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        int left = 0;
//        int right = 0;
//        int minVal = Integer.MAX_VALUE;
//        int[] countStudentCount = new int[n];
//        int classNum = 0;
//        int len = n*m;
//        while (right < len) {
//            int currentClass = students[right][1];
//            if (countStudentCount[currentClass] == 0) {
//                classNum++;
//            }
//            countStudentCount[currentClass]++;
//            right++;
//            while (classNum == n) {
//                int[] student = students[left];
//                minVal = Math.min(minVal, students[right - 1][0] - students[left][0]);
//                countStudentCount[student[1]]--;
//                if (countStudentCount[student[1]] == 0) {
//                    classNum--;
//                }
//                left++;
//            }
//        }
//
//        System.out.println(minVal);
//    }
//}


package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem274 {
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums[i]);
        }
        PriorityQueue<piii> pq = new PriorityQueue<piii>();
        int MM = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            pq.add(new piii(nums[i][0], i, 0));
            MM = Math.max(MM, nums[i][0]);
        }
        System.out.println(Integer.MAX_VALUE);
        int dist = MM - pq.peek().val; // 갱신 완료
        while (!pq.isEmpty()) {
            piii cur = pq.poll(); // 갱신한 거 빼주고
            int y = cur.y;
            int x = cur.x; // 그 다음을 찾아야 하는데
            if(x==M-1) break; // 이제 다음 것을 못 봄

            pq.offer(new piii(nums[y][x + 1], y, x + 1));
            if (MM < nums[y][x + 1]) {
                MM = nums[y][x + 1];
            }
            dist = Math.min(dist, MM - pq.peek().val);
        }
        System.out.println(dist);
    }
    static class piii implements Comparable<piii> {
        int val;
        int y;
        int x;
        public piii(int val, int y, int x) {
            this.val = val;
            this.y = y;
            this.x = x;
        }
        @Override
        public int compareTo(piii o) {
            return val - o.val;
        }

    }
}
package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem320 {
    static int[][] MAP;

    static int[] dy = new int[]{1, 0};
    static int[] dx = new int[]{0, 1};

    public static void main(String[] args)
            throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];
        int L = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0;i<N;i++){ // check row
            if (isRowPossible(i, N, L)) {
                cnt++;
                // System.out.println("row : " + i);
            }
        }

         for(int j = 0;j<N;j++){ // check col
            if (isColPossible(j, N, L)) {
                cnt++;
                // System.out.println("col : " + j);
            }
         }
        System.out.println(cnt);
    }

    private static boolean isRowPossible(int start, int end, int requirement) { // button : 0 = row, 1 = col
        boolean[] ladders = new boolean[end];
        for(int i = 0;i<end-1;i++) {
            int currentHeight = MAP[start][i];
            int nextHeight = MAP[start][i + 1];

            if (Math.abs(currentHeight - nextHeight) > 1) {
                return false;
            }
            else if(currentHeight-nextHeight==0) {
                continue;
            } else{ // Math.abs(.. - .. ) = 1
                if(currentHeight < nextHeight) { // 왼쪽으로 내려가기
                    // L개 체크
                    for(int j = 0;j<requirement;j++){
                        int idx = i-j;
                        if(idx<0 || MAP[start][idx] != currentHeight || ladders[idx] ) {
                            return false;
                        }
                        ladders[idx] = true;
                    }
                }else if(nextHeight < currentHeight){ // 오른쪽으로 내려가기
                    for(int j = 1;j<=requirement;j++){
                        int idx = i+j;
                        if(idx>=end || MAP[start][idx] != nextHeight || ladders[idx] ) {
                            return false;
                        }
                        ladders[idx] = true;
                    }
                    i+=requirement-1;
                    // 3 2 2 3 4
                    // 0 1 2 3 4
                }
            }
        }
        return true;
    }

    private static boolean isColPossible(int start, int end, int requirement) { // button : 0 = row, 1 = col
        boolean[] ladders = new boolean[end];
        for(int i = 0;i<end-1;i++) {
            int currentHeight = MAP[i][start];
            int nextHeight = MAP[i+1][start];

            if (Math.abs(currentHeight - nextHeight) > 1) {
                return false;
            }
            else if(currentHeight-nextHeight==0) {
                continue;
            } else{ // Math.abs(.. - .. ) = 1
                if(currentHeight < nextHeight) { // 왼쪽으로 내려가기
                    // L개 체크
                    for(int j = 0;j<requirement;j++){
                        int idx = i-j;
                        if(idx<0 || MAP[idx][start] != currentHeight || ladders[idx] ) {
                            return false;
                        }
                        ladders[idx] = true;
                    }
                }else{ // 오른쪽으로 올라가기
                    for(int j = 1;j<=requirement;j++){
                        int idx = i+j;
                        if(idx>=end || MAP[idx][start] != nextHeight || ladders[idx] ) {
                            return false;
                        }
                        ladders[idx] = true;
                    }
                    i+=requirement-1;
                    // 3 2 2 3 4
                    // 0 1 2 3 4
                }
            }
        }
        return true;
    }

}
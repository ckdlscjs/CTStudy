package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem319 {
    static int[][] MAP;
    static boolean[] visited = new boolean[30];
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args)
    throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bactracking(0, 0, N / 2);
        System.out.println(ret);
    }

    private static void bactracking(int idx, int cnt, int N) {
        if (cnt == N) {
            int A = 0, B = 0;
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();
            for(int i = 0;i<2*N;i++){
                if(visited[i]){
                    teamA.add(i);
                }else{
                    teamB.add(i);
                }
            }

            for(int i = 0;i<teamA.size()-1;i++){
                for (int j = i + 1; j < teamA.size(); j++) {
                    A+= MAP[teamA.get(i)][teamA.get(j)];
                    A+= MAP[teamA.get(j)][teamA.get(i)];
                }
            }

            for(int i = 0;i<teamB.size()-1;i++){
                for (int j = i + 1; j < teamB.size(); j++) {
                    B+= MAP[teamB.get(i)][teamB.get(j)];
                    B+= MAP[teamB.get(j)][teamB.get(i)];
                }
            }

            ret = Math.min(ret, Math.abs(A - B));
            // System.out.println(Arrays.toString(visited));
            // System.out.println(teamA + " " + teamB);
            // System.out.println(A + " " + B);
            return;
        }

        for(int i = idx;i<N*2;i++){
            if(!visited[i]){
                visited[i] = true;
                bactracking(i + 1,cnt + 1, N);
                visited[i] = false;
            }
        }
    }
}

// 6
// 0 1 2 3 4 5 : (1, 3, 6), (2, 4, 5)
// 1 0 2 3 4 5 :  (1,3) : 2 + 1 = 3, (1, 6) : 5 + 1 = 6, (3, 6) : 5 + 3 = 8 => 17
// 1 2 0 3 4 5 :  (2,4) : 3 + 2 = 5, (2, 5) : 4 + 2 = 6, (4, 5) : 4 + 4 = 8 => 19
// 1 2 3 0 4 5
// 1 2 3 4 0 5
// 1 2 3 4 5 0

package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem323 {
    static int[][] field;
    static int[] order = new int[9];
    static boolean[] used = new boolean[10];
    static int maxScore = 0;

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        field = new int[N][9];

        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st= new StringTokenizer(bf.readLine());
            for(int j = 0;j<9;j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[3] = 1; // 4번타자
        used[1] = true;

        solve(0, N);
        System.out.println(maxScore);
    }

    private static void solve(int idx, int N){

        if (idx == 9) {
            maxScore = Math.max(maxScore, simulate(N));
        } else if (idx == 3) {
            solve(idx + 1, N);
            return;
        }else{
            for(int player = 2; player<=9; player++){
                if(!used[player]){
                    used[player] = true;
                    order[idx] = player;
                    solve(idx + 1, N);
                    used[player] = false;
                }
            }
        }
    }

    private static int simulate(int N) {
        int score = 0;
        int curIdx = 0;

        for (int inning = 0; inning < N; inning++) {
            int outs = 0;
            boolean[] base = new boolean[4];

            while (outs < 3) {
                int player = order[curIdx];
                int result = field[inning][player - 1];

                if (result == 0) {
                    outs++;
                } else if (result == 1) {
                    if (base[3]) {
                        score++;
                    }
                    base[3] = base[2];
                    base[2] = base[1];
                    base[1] = true;
                }
                else if(result == 2) {
                    if (base[3]) {
                        score++;

                    }
                    if (base[2]) {
                        score++;
                    }
                    base[3] = base[1];
                    base[2] = true;
                    base[1] = false;
                } else if (result == 3) {
                    if(base[3]) score++;
                    if(base[2]) score++;
                    if(base[1]) score++;
                    base[3] = true;
                    base[2] = false;
                    base[1] = false;
                }else{// homerun
                    if(base[3]) score++;
                    if(base[2]) score++;
                    if(base[1]) score++;
                    score++;
                    base[3] = false;
                    base[2] = false;
                    base[1] = false;
                }

                curIdx = (curIdx + 1) % 9;
            }
        }
        return score;
    }
}

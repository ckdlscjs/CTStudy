package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem302 {

    static ArrayList<Integer> abilities;
    static int[][] board;
    static boolean[][] chk;
    static ArrayList<ArrayDeque<int[]>> ques;

    public static void main(String[] args)
            throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NMP = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int N = NMP[0];
        int M = NMP[1];
        int P = NMP[2];
        board = new int[N][M];
        chk = new boolean[N][M];

        abilities = new ArrayList<>();
        ques = new ArrayList<>(P+1);
        for(int i = 0;i<=P;i++){
            ques.add(new ArrayDeque<>());
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());

        abilities.add(0);
        for(int i = 0;i<P;i++){
            abilities.add(Integer.parseInt(st.nextToken()));
        }

        for(int i =0;i<N;i++){
            String tmp = bf.readLine();
            for(int j = 0;j<M;j++){
                char c = tmp.charAt(j);
                if(48<= c && c <= 57){
                    board[i][j] = (c-48);
                    ques.get(board[i][j]).add(new int[]{i,j});
                    chk[i][j] = true;
                }
                else{
                    if(c=='.'){ // empty
                        board[i][j] = 0;
                    }else{ // # wal;
                        board[i][j] = P+1;
                        chk[i][j] = true;
                    }
                }
            }
        }

        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        boolean flag;

        while(true){
            flag = false;
            for(int i = 1;i<=P;i++){
                int times = abilities.get(i);
                while(times-->0){
                    boolean newOne = false;
                    int n = ques.get(i).size();
                    for(int j = 0;j<n;j++){
                        int[] cur = ques.get(i).poll();
                        int cur_y = cur[0];
                        int cur_x = cur[1];
                        int val = board[cur_y][cur_x];
                        for(int k = 0;k<4;k++){
                            int ny = cur_y + dy[k];
                            int nx = cur_x + dx[k];
                            if(isOutside(ny, nx, N, M) || chk[ny][nx]) continue;

                            chk[ny][nx] = true;
                            board[ny][nx] = val;
                            ques.get(i).addLast(new int[]{ny,nx});
                            flag = true;
                            newOne = true;
                        }
                    }
                    if(!newOne){
                        break;
                    }
                }
            }

            if(!flag){
                break;
            }
        }

        int[] res = new int[P+1];
        for(int i = 0;i<N;i++){
            for(int j =0;j<M;j++){
                if(board[i][j]!=(P+1) && board[i][j]!=0){
                    res[board[i][j]]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=P;i++){
            // System.out.print(res[i]+" ");
            sb.append(res[i]+" ");
        }
        System.out.println(sb);

    }

    static boolean isOutside(int ny, int nx, int N, int M){
        return (0>ny || 0>nx || ny>=N || nx>=M);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem171 {

    
    static int[][] board = new int[100][100];
    static int[][] new_board = new int[100][100];

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    static class Pair{
        int y;
        int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }   
    }

    public static void main(String[] args) 
    throws IOException {

        // Input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());
        for(int i = 0;i<N;i++){
            int j =0;
            String line = bf.readLine();
            for(char c : line.toCharArray()){
                board[i][j++] = ((c=='R') ? 0 : (c=='G') ? 1 : 2); // R : 0, G : 1, B : 2
            }
        }

        // 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
        for(int i = 0;i<N;i++){
            for(int j =0;j<N;j++){
                new_board[i][j] = (board[i][j]>=2)? 2 : 1; // B vs G
            }
        }
        
        // Logic 
        solve(N);
    }

    static void BFS(boolean[][] cur_chk, int[][] cur_board, int y, int x, int color, int N){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.addLast(new Pair(y, x));

        while(!que.isEmpty()){
            Pair cur = que.pollFirst();
            int cur_y = cur.y;
            int cur_x = cur.x;
            for(int i = 0;i<4;i++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                if(isOutside(ny, nx, N)) continue;
                if(cur_chk[ny][nx] || (cur_board[ny][nx]!=color)) continue;
                cur_chk[ny][nx] = true;
                que.addLast(new Pair(ny, nx));
            }
        }
    }
    
    static void solve(int N){
        boolean[][] chk = new boolean[100][100];
        boolean[][] new_chk = new boolean[100][100];

        int cnt = 0;
        for(int i = 0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!chk[i][j]){
                    chk[i][j] = true;
                    BFS(chk, board, i,j, board[i][j], N);
                    cnt++;
                }
            }
        }

        int cnt_1 = 0;
        for(int i = 0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!new_chk[i][j]){
                    new_chk[i][j] = true;
                    BFS(new_chk, new_board, i,j, new_board[i][j], N);
                    cnt_1++;
                }
            }
        }
        System.out.println(cnt + " " + cnt_1);
        return;
    }

    static boolean isOutside(int ny, int nx, int N){
        return (0>ny || 0>nx || ny>=N || nx>=N);
    }
}

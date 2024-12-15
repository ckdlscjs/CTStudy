import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main135 {
    
    static int[][] D = new int[101][101];
    static int[][] board = new int[101][101];
    static boolean [][] chk = new boolean[101][101];
    static int N;
    static int M;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static int INF = 130103330;

    static class Pair{
        int y;
        int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        INPUT();
        SOLVE();
        // print();
    }

    static void INPUT() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0;i<N;i++){
            String nxt = bf.readLine();
            int j =0;
            for(char c : nxt.toCharArray()){
                board[i][j] = (c=='1') ? 1 : 0;
                D[i][j++] = INF;
            }
        }
    }
    
    static void print(){
        for (int i = 0; i < N; i++) {
            for(int j = 0;j<M;j++){
                // System.out.print(board[i][j] + " ");
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void SOLVE(){
        D[0][0] = 1;
        BFS(0,0);
        System.out.println(D[N-1][M-1]);
    }

    static void BFS(int y, int x){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(y,x));
        chk[0][0] = true;
        while(!que.isEmpty()){
            Pair cur = que.pollFirst();
            int cur_y = cur.y;
            int cur_x = cur.x;
            for(int i = 0;i<4;i++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                if(isOutside(ny,nx)) continue;
                if(chk[ny][nx]) continue;
                if(board[ny][nx]==1){
                    // if(D[ny][nx] > D[y][x] + 1){
                    D[ny][nx] = D[cur_y][cur_x] + 1;
                    que.add(new Pair(ny,nx));
                    chk[ny][nx] = true;
                }
            }
        }
    }

    static boolean isOutside(int ny, int nx){
        return (0>ny || ny>=N || 0>nx || nx>=M);
    }
}

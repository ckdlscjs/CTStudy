import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem149  {
    static int[][] board = new int[1000][1000];
    static boolean[][] chk = new boolean[1000][1000];
    static boolean[][] s_chk = new boolean[1000][1000];
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    static ArrayDeque<Pair> F = new ArrayDeque<>();
    static ArrayDeque<Pair> S = new ArrayDeque<>();
    
    // output 
    static StringBuilder sb = new StringBuilder();

    static class Pair{
        int y;
        int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
        @Override
        public String toString(){
            return y + " " + x;
        }
    }
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0){
            int[] MN = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            int N = MN[1];
            int M = MN[0];
            INPUT(N, M, bf);
            SOLVE(N, M);
            while(!F.isEmpty()){
                F.pollFirst();
            }
            while (!S.isEmpty()) { 
                S.pollFirst();
            }
        }
        System.out.print(sb);
    }

    static void INPUT(int N, int M, BufferedReader bf) throws IOException{
        for(int i =0 ;i<N;i++){
            String tmp = bf.readLine();
            int j = 0;
            for(char c : tmp.toCharArray()){
                chk[i][j] = false;
                s_chk[i][j] = false;
                board[i][j++] = (c=='.') ? 0 : ((c=='@') ? 1 : ((c=='*') ? 2 : 3));
                if(board[i][j-1]==1){
                    S.addLast(new Pair(i, j-1));
                }
                else if(board[i][j-1]==2){
                    F.addLast(new Pair(i, j-1));
                    chk[i][j-1] = true;
                }
            }
        }
    }

    static void print(int N, int M){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    static boolean BFS(int status, int N, int M){
        if(status == 0){ // FIRE 
            int f = F.size();
            // System.out.println(f);
            for(int i = 0;i<f;i++){
                Pair curF = F.pollFirst();
                int F_y = curF.y;
                int F_x = curF.x;
                for(int j = 0;j<4;j++){
                    int ny = F_y + dy[j];
                    int nx = F_x + dx[j];
                    if(isOutside(ny, nx, N, M)) continue;
                    if(chk[ny][nx] || board[ny][nx]==3) continue;
                    chk[ny][nx] = true;
                    F.addLast(new Pair(ny, nx));
                }
            }
            return false;
        }else{ // SANG
            int k = S.size();
            for(int i = 0;i<k;i++){
                Pair curS = S.pollFirst();
                int S_y = curS.y;
                int S_x = curS.x;
                for(int j = 0;j<4;j++){
                    int ny = S_y + dy[j];
                    int nx = S_x + dx[j];
                    if(isOutside(ny, nx, N, M)) continue;
                    if(chk[ny][nx] || s_chk[ny][nx] || board[ny][nx]>=2) continue;
                    if(isBeforeEscape(ny, nx, N, M)){
                        return true;    
                    }
                    s_chk[ny][nx] = true;
                    S.addLast(new Pair(ny, nx));
                }
            }
            // System.out.println("SS"  + S);
            return false;
        }
    }

    static boolean isOutside(int ny, int nx, int N, int M){
        return (0>ny || 0>nx || ny>=N || nx>=M);
    }

    static boolean isBeforeEscape(int ny, int nx, int N, int M){
        return (0==ny || 0==nx || ny==N-1 || nx==M-1);
    }

    static void SOLVE(int N, int M){

        int cnt = 0;
        // chk before BFS
        for(Pair s : S){
            if(isBeforeEscape(s.y, s.x, N, M)){
                sb.append(1 +"\n");
                return;
            }
        }

        while(!F.isEmpty() || !S.isEmpty()){
            // BFS FIRE 
            ++cnt;
            BFS(0,N,M);
            // System.out.println("AFter " + S);
            if(BFS(1,N,M)){
                // System.out.println(cnt+1);
                sb.append((cnt+1) + "\n");
                return;
            }
            // BFS 상근 
        }
        // System.out.println("IMPOSSIBLE");
        sb.append("IMPOSSIBLE\n");
    }

    static void deletePossible(){
        int n = S.size();
        for(int i = 0;i<n;i++){
            int y = S.peekFirst().y;
            int x = S.peekFirst().x;
            if(chk[y][x]) {
                S.pollFirst();
            }
            else{
                S.addLast(S.pollFirst());
            }
        }
    }
}


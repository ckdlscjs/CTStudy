import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main141 {
    static int[][] board = new int[101][101];
    static boolean[][] chk = new boolean[101][101];
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] MNK = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        int N = MNK[0];
        int M = MNK[1];
        int K = MNK[2];
        
        for(int l = 0;l<K;l++){
            int[] xyXY = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            int y = xyXY[1];
            // System.out.println("before " + xyXY[1]+ " " + xyXY[3]);
            int x = xyXY[0];
            int Y = xyXY[3];
            int X = xyXY[2];
            
            if(y>Y){
                int tmp = Y;
                Y = y;
                y = tmp;
            }
            
            if(x>X){
                int tmp = X;
                X = x;
                x = tmp;
            }
            
            // System.out.println("S " + y + " " + x + " " + Y + " " + x);

            for(int i = y+1;i<=Y;i++){
                for(int j = x;j<X;j++){
                    board[i][j] = 1;
                    chk[i][j] = true;
                }
            }
        }
        
        int ret = 0;
        int cnt = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 1;i<=N;i++){
            for(int j = 0;j<M;j++){
                if(!chk[i][j] && board[i][j]==0){
                    ret++;
                    cnt = dfs(i,j, N, M);
                    lst.add(cnt);
                }
            }
        }
        System.out.println(ret);
        Collections.sort(lst);
        StringBuilder sb = new StringBuilder();
        for(int num : lst){
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
    static int dfs(int y, int x, int N, int M){
        
        int cur = 1;
        chk[y][x] = true;
        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isOutside(ny,nx, N, M)) continue;
            if(!chk[ny][nx] && board[ny][nx]==0){
                cur += dfs(ny,nx, N, M);
            }
        }
        return cur;
    }

    static boolean isOutside(int ny, int nx, int N, int M){
        return (0>nx || 1>ny || nx>=M || ny>=(N+1));
    }

 
}
// 5 7 3
// 0 2 4 4
// 1 1 2 5
// 4 0 6 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main155  {

    static int[][][] board; 
    static int N;
    static int K;
    static int L;
    static class Pair{
        int z;
        int y;
        int x;
        Pair(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        INPUT();
        System.out.println(BFS());
    }

    static boolean isOutside(int y, int x, int z){
        return (0>y || 0>x || 0>z || y>=K || x>=N || z>=L);
    }

    static void INPUT()
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NKL = Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        N = NKL[0];
        K = NKL[1];
        L = NKL[2];
        board = new int[L][K][N];
        StringTokenizer st;

        for(int l = 0;l<L;l++){
            for(int i = 0;i<K;i++){
                int j = 0;
                st = new StringTokenizer(bf.readLine());
                while(st.hasMoreElements()){
                    board[l][i][j++] = Integer.parseInt(st.nextToken());
                }
            }
        }
 
    }

    static int BFS(){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        boolean[][][] chk = new boolean[L][K][N];

        for(int i = 0;i<L;i++){
            for(int j=0;j<K;j++){
                for(int l = 0;l<N;l++){
                    if(board[i][j][l]==1){
                        chk[i][j][l] = true;
                        que.addLast(new Pair(i, j, l));
                    }
                }
            }
        }
        int[] dz = {1,-1,0,0,0,0};
        int[] dy = {0,0,1,-1,0,0};
        int[] dx = {0,0,0,0,1,-1};
        int cnt = 0;
        while(!que.isEmpty()){
            int M = que.size();
            boolean flag = false;
            for(int k = 0;k<M;k++){
                Pair front = que.pollFirst();
                int z = front.z;
                int y = front.y;
                int x = front.x;
    
                for(int i = 0;i<6;i++){
                    int nz = z + dz[i];
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(isOutside(ny, nx, nz) || chk[nz][ny][nx] || board[nz][ny][nx]==-1) continue;
                    chk[nz][ny][nx] = true;
                    board[nz][ny][nx] = 1;
                    que.addLast(new Pair(nz, ny, nx));
                    flag = true;
                }
            }
            if(flag) cnt++;
        }

        for(int l=0;l<L;l++){
            for(int i = 0;i<K;i++){
                for(int j =0;j<N;j++){
                    if(!chk[l][i][j] && board[l][i][j]==0){
                        return -1;
                    }
                }
            }
        }
        return cnt;
    }
}

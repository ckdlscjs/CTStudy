import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main139 {
    static int N;
    static int M;
    static int[][] board = new int[1001][1001];

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
        int res = BFS();
        System.out.println(res);
    }

    static void INPUT() 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int BFS(){
        ArrayDeque<Pair> que = new ArrayDeque<Pair>();
        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1,-1,0,0};
        boolean[][] chk = new boolean[M][N];
         int INF = 301030130;
        
        for(int i=0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(board[i][j]==1){
                    que.add(new Pair(i, j));
                    chk[i][j] = true;
                }
            }
        }

        int cnt = 0;
        // System.out.println(que.size());
        while(!que.isEmpty()){
            // System.out.println(que.size());
            int n = que.size();
            boolean flag = false;
            for(int j = 0;j<n;j++){
                Pair cur = que.pollFirst();
                int cur_y = cur.y;
                int cur_x = cur.x;
    
                for(int i =0;i<4;i++){
                    int nx = cur_x + dx[i];
                    int ny = cur_y + dy[i];
                    if(isOutside(ny, nx)) continue;
                    if(board[ny][nx]==0 && !chk[ny][nx]){
                        flag = true;
                        board[ny][nx] = 1; // 확산 
                        chk[ny][nx] = true;
                        que.add(new Pair(ny, nx));
                    }
                }
            }

            if(flag){
                cnt++;
            }
        }

        for(int i = 0;i<M;i++){
             for(int j=0;j<N;j++){
                if(board[i][j]==0){
                    return -1;
                }
            }
        }
        return cnt;
    }

    static boolean isOutside(int ny, int nx){
        return (0>ny || ny >= M || 0>nx || nx>=N);
    }

    static void print(){
        for(int i= 0;i<M;i++){
            for(int j = 0;j<N;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


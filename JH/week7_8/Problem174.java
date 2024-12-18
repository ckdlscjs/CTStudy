import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem174{

    static int N;
    static int M;
    static int[][] board = new int[501][501];
    static boolean[][] chk = new boolean[501][501];

    public static void main(String[] args) 
    throws IOException{
        Input();      
        Solve();  
    }

    static void Input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i= 0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return;
    }

    static void Solve(){
        int area = 0;
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(!chk[i][j] && board[i][j] == 1){
                    int tmp_area = dfs(i,j);
                    area = (tmp_area > area)? tmp_area : area;
                    cnt++;
                }
            }   
        }
        System.out.printf("%d\n%d\n", cnt, area);
    }

    static int dfs(int y, int x){
        
        if(isOutside(y, x) || chk[y][x] || board[y][x]==0){
            return 0;
        }

        int cnt = 1;
        chk[y][x] = true;
        cnt += dfs(y+1, x);
        cnt += dfs(y, x+1);
        cnt += dfs(y-1, x);
        cnt += dfs(y, x-1);
        return  cnt;
    }

    static boolean isOutside(int ny, int nx){
        return (0>ny || ny>= N || 0>nx || nx>=M);
    }
}

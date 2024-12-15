import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem151 {

    static int[][] MAP;
    static boolean[][] chk;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static Deque<int[]> candidates = new ArrayDeque<>(); 
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        MAP = new int[N+1][N+1];
        chk = new boolean[N+1][N+1];

        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        } 
        
        int M = 1001 * 1001;

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(MAP[i][j]==1){
                    DFS(i,j,N);
                    int area = BFS(N,M);
                    M = Math.min(area,M);
           
                }
            }
        }
        System.out.println(M);

    }
    // N<= 100
    // 100 * 100 init 
    static int BFS(int N, int cnt){ // dfs 말고 bfs를 쓴 이유 최소거리 보장해야 하기 때문
 

        int distance = 0;

        // chk
        for(int i = 0;i<N;i++){
            Arrays.fill(chk[i], false);
        }

        for(int[] tmp : candidates){
            chk[tmp[0]][tmp[1]] = true;
        }
 
        while(!candidates.isEmpty()){
     
                int[] cur = candidates.pollFirst();
                int cur_y = cur[0];
                int cur_x = cur[1];
                int cur_dist = cur[2];
                

                for(int i = 0;i<4;i++){
                    int ny = cur_y + dy[i];
                    int nx = cur_x + dx[i];
                    if(isOutside(ny,nx, N) || chk[ny][nx] || MAP[ny][nx]==2) continue;

                    chk[ny][nx] = true;

                    if(MAP[ny][nx]==1){
                        cnt = Math.min(cnt,  cur_dist); // 다리 길이니까 
                    }
                    candidates.addLast(new int[]{ny,nx, cur_dist+1});
                }
 
        }

        return cnt;
    }

    static void DFS(int y, int x, int N){

        if(isOutside(y, x, N) || MAP[y][x]!=1) return;
        MAP[y][x] = 2;
        candidates.addLast(new int[]{y,x,0});
        DFS(y-1,x,N);
        DFS(y+1,x,N);
        DFS(y,x-1,N);
        DFS(y,x+1,N);
    }

    static boolean isOutside(int y, int x, int N){
        return (0>y || 0>x || y>=N || x>=N);
    }
}

// ㅣ게 왜 더 빠르지?

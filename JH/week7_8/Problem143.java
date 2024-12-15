import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem143 {

    static int[] dy = {-2,-2,-1,-1,1,1,2,2};
    static int[] dx = {1,-1,-2,+2,-2,2,1,-1};
    
    static class Pair{
        int y;
        int x;
        int dist;
        Pair(int y, int x, int dist){
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int N = Integer.parseInt(bf.readLine());
            int[] currentKnight = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cur_y = currentKnight[0];
            int cur_x = currentKnight[1];
            int[] goalPosition = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int goal_y = goalPosition[0];
            int goal_x = goalPosition[1];
            int cnt = BFS(cur_y, cur_x, N, goal_y, goal_x);
            sb.append(cnt+"\n");
        }
        System.out.print(sb);
    }

    static int BFS(int y, int x, int N, int goal_y, int goal_x){
        if(y == goal_y && x == goal_x){
            return 0;
        }
        
        ArrayDeque<Pair> que = new ArrayDeque<>();
        boolean[][] chk = new boolean[N][N];

        que.add(new Pair(y, x, 0));
        chk[y][x] = true;

        while(!que.isEmpty()){
            Pair cur = que.pollFirst();
            int cur_y = cur.y;
            int cur_x = cur.x;
            int cur_dist = cur.dist;

            for(int i = 0;i<8;i++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                if(isOutside(ny, nx, N)) continue;
                if(chk[ny][nx]) continue;
                que.addLast(new Pair(ny, nx, cur_dist+1));
                if(ny == goal_y && nx == goal_x){
                    return cur_dist+1;
                }
                chk[ny][nx] = true;
            }
        }
        return 0;// 쓸일 없음
    }

    static boolean isOutside(int ny, int nx, int N){
        return (0>ny || 0>nx || ny>=N || nx>=N);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main157 {

    static char [][] board = new char[1001][1001];
    static int R;
    static int C;
    static int F_y;
    static int F_x;
    static int J_y;
    static int J_x;
    static ArrayDeque<Pair> Fs = new ArrayDeque<>();
    static ArrayDeque<Pair> Js = new ArrayDeque<>();
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
    throws IOException{
        INPUT();
        int cnt = 0;
        while(true){
            if(check()){
                System.out.println(cnt+1);
                break;
            }
            cnt++;
             
            BFS_J();
            BFS_F();
            // System.out.println(Js.size());
            findDeadJ();
            // System.out.println(Js.size());
            if(check()){
                System.out.println(cnt+1);
                break;
            }
            // print();
            if(Js.isEmpty()){
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
    }

    private static void findDeadJ() {
        // TODO Auto-generated method stub
        int n = Js.size();
        for(int i = 0;i<n;i++){
            Pair cur = Js.pollFirst();
            if(board[cur.y][cur.x]=='F'){
                continue;
            }else{
                Js.addLast(cur);
            }
        }
    }

    private static void INPUT() 
    throws IOException{
        // TODO(INPUT BOARD: char[][])
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int i = 0;i<R;i++){
            char[] chars = (bf.readLine().toCharArray());
            int j = 0;
            for(char c : chars){
                board[i][j] = c;
                if(c=='J'){
                    Js.add(new Pair(i, j));
                                }
                else if(c =='F'){
                   Fs.add(new Pair(i, j));
                }
                j++;
            }
        }
    }

    static void BFS_F(){
        
        int n = Fs.size();
        for(int i = 0;i<n;i++){
            Pair cur_f = Fs.pollFirst();
            int cur_fy = cur_f.y;
            int cur_fx = cur_f.x;
            
            for(int j = 0;j<4;j++){
                int ny = cur_fy + dy[j];
                int nx = cur_fx + dx[j];
                if (isOutside(ny,nx)) continue;
                if (board[ny][nx]=='#' || board[ny][nx] == 'F') continue;

                board[ny][nx] = 'F';
                Fs.add(new Pair(ny, nx));
            }
        }
    }

    
    static void BFS_J(){
        
        // check there exists outSide;
       
        int n = Js.size();

        for(int i  =0;i<n;i++){
            Pair cur_J = Js.pollFirst();
            int cur_Jy = cur_J.y;
            int cur_Jx = cur_J.x;
            if(board[cur_Jy][cur_Jx]=='F'){continue;}
            for(int j = 0;j<4;j++){
                int ny = cur_Jy + dy[j];
                int nx = cur_Jx + dx[j];
                if(isOutside(ny, nx)){ continue;}
                if(board[ny][nx]=='.'){
                    board[ny][nx] = 'J';
                    Js.add(new Pair(ny, nx));
                }
            }    
        }
     }

    private static boolean isOutside(int ny, int nx) {
        // TODO (check whether it is out of the board)
        return (0>ny || ny >= R || 0>nx || nx>=C);
    }

    private static boolean check(){
        for(Pair cur : Js){
            if(cur.y == 0 || cur.y==R-1 || cur.x == C-1 || cur.x == 0 ){
                // System.out.println(cur.y + " " + cur.x);
                return true;
            }
        }
        return false;
    }

    private static void print(){
        for(int  i =0 ;i<R;i++){
            for(int j = 0;j<C;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }
}

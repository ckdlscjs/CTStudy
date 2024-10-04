package week1;

public class problem6 {
    static class Solution {
        
        public int solution(String[][] board, int h, int w) {
            int answer = 0;
            int n = board.length;
            int[] dy = {0,0,1,-1};
            int[] dx = {1,-1,0,0};
            
        
            // for(int i = 0;i<n;i++){
            //     for(int j = 0;j<n;j++){
            // O(1)
                    int cnt = 0;            
                    for(int k=0;k<4;k++){
                        int ny = h + dy[k];
                        int nx = w + dx[k];
                        if(0>ny || ny>=n || 0>nx || nx>=n) continue;
                        if(board[h][w].equals(board[ny][nx])){
                            cnt++;
                        }
                    }
                    answer = (cnt > answer)? cnt : answer;
            
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }    
}

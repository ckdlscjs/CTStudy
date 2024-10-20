import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> st = new ArrayDeque<Integer>();
        for(int move : moves){
            int chk = isPossible(--move, board);
            System.out.println(chk);
            if(chk!=-1){
                if(st.size()>0){
                    if(st.peekLast()==chk){
                        st.pollLast();
                        answer+=2; 
                    }else{
                        st.addLast(chk);    
                    }
                }else{
                    st.addLast(chk);    
                }
                
            }
        }
        return answer;
    }
    
    static public int isPossible(int move, int[][] board){
        int n = board.length;
        for(int i = 0;i<n;i++){
            if(board[i][move]!=0){
                int tmp = board[i][move];
                board[i][move] = 0;
                return tmp;
            }
        }
        
        return -1;
    }
}
 
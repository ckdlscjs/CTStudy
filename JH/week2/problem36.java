package week2;

public class problem36 {

    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            
            for(int i =left;i<=right;i++){
                
                int cnt = 0;
                int m = (int) Math.ceil(Math.sqrt(i));
                // System.out.println(m + "  ");
                for(int j = 1;j<=m;j++){
                    // System.out.printf("i : %d j : %d cnt = %d\n", i, j, cnt);
                    if(i % j == 0){
                        if(i/j == j){
                            // System.out.printf("i : %d j : %d cnt = %d\n", i, j, cnt);
                            cnt+=1;
                        }
                        else{
                            cnt+=2; // i/j, i;
                        }
                    }    
                }
                // System.out.println(i + " " + cnt);
                if(cnt%2==0){
                    answer+=i;
                }else{
                    answer-=i;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        
    }
}

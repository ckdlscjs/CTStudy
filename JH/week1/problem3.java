package week1;

public class problem3 {
    class Solution{
        static boolean isOutside(int cur_y, int cur_x, int park_y, int park_x){
            return cur_y < 0 || cur_y >= park_y || cur_x < 0 || cur_x >= park_x;
        }

        static int max(int a, int b){return (a>b)? a : b;}    

        static boolean isPossible(int cur_y, int cur_x, String[][] maps, int mat){
            
            int ny = cur_y + mat;
            int nx = cur_x + mat;
            // boolean tmp = ny> maps.length || nx > maps[0].length;
            if(ny> maps.length || nx > maps[0].length) return false;
            
            for(int i = cur_y; i < ny; i++){
                for(int j = cur_x; j < nx ; j++){
                    if(!maps[i][j].equals("-1")){
                        // System.out.println("ret " + i + " " + j);
                        return false;
                    }
                }
            }
            
            return true;
        }

        public int solution(int[] mats, String[][] park) {
            int answer = -1;
            // 큰수 -> 작은수  
            int n = park.length;
            int m = park[0].length;
            // 시간복잡도 O(mats.length * park[i][j]^2 * mats[i]^2)
            for(int mat : mats){
                for(int i = 0;i<n;i++){
                    for(int j=0;j<m;j++){
                        // check possbile? 
                        // System.out.println(i + " " + j + " " + mat + " " + isPossible(i, j, park, mat));
                        if (isPossible(i, j, park, mat)){
                            answer = max(answer,mat);
                        }
                    }
                }
            }
            // System.out.println(park[2][2].equals("-1"));
            return answer;
        }

    }
    public static void main(String[] args) {
        
    }
}
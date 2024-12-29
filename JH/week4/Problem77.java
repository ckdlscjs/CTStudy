package week4;

public class Problem77 {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
        int p = 0;
        int y = 0;
        for(char c : s.toCharArray()){
            if(c == 'p' || c== 'P'){
                p+=1;
            }
            if(c == 'y' || c== 'Y'){
                y+=1;
            }
        }
        if(y == p){
            return true;
        }
        return false;
    }
}
public class Problem58 {
    public boolean solution(int x) {
        // boolean answer = true;
        int cur = x;
        int tmp = 0;
        while(x>0){
            tmp += (x%10);
            x/=10;
        }
        if(cur % tmp == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
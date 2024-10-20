#### 첫번째 풀이 (시간초과)
class Solution {
    public int solution(int n) {
        String ternary = "";
        int decimal = 0;
        while(n != 0){
            ternary += n % 3;
            n /= 3;
        }
        int ti = 1;
        int ternaryInt = Integer.parseInt(ternary);
        for(int i = 0; i < ternary.length(); i++){
           	decimal += (ternaryInt % 10) * ti;
            ternaryInt /= 10;
            ti *= 3;
        }
        return decimal;
    }
}

#### 두번째 풀이

class Solution {
    public int solution(int n) {
        String ternary = "";
        int decimal = 0;
        while(n != 0){
            ternary += n % 3;
            n /= 3;
        }
        
        return Integer.parseInt(ternary, 3);
    }
}

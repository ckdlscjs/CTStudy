class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        int GCD = 0;
        for(int i = 1; i <= min; i+=1){
            if(min % i == 0 && max % i == 0)
                GCD = i;
        }
        int LCM = max * min / GCD;
        answer[0] = GCD;
        answer[1] = LCM;
        
        return answer;
    }
}

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int remaindor = 0;
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(min != 0){
            remaindor = max % min;
            max = min;
            min = remaindor;
        }
        int G = max;
        int L = n * m / max;
        answer[0] = G;
        answer[1] = L;
        
        return answer;
    }
}

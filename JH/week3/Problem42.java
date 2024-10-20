// import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] chk = new int[201];
        int n = numbers.length;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j =i+1;j<n;j++){
                int tmp = numbers[i] + numbers[j];
                if(chk[tmp]==0){
                    chk[tmp]++;  
                    cnt++;
                } 
            }
        }
        
        int[] answer = new int[cnt];
        int i = 0;
        for(int k = 0;k<=200;k++){
            if(chk[k]>0){
                answer[i++] = k;
            }
        }
        return answer;
    }
}
public class Problem46 {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] friends = new int[n+1];
        for(int i = 0; i<=n;i++){
            friends[i] = 1;
        }
        
        int m = lost.length;
        for(int i = 0;i<m;i++){
            friends[lost[i]]-=1;
        }
        
        int k = reserve.length;
        for(int i = 0;i<k;i++){
            friends[reserve[i]]+=1;
        }
        
        
        
        int answer = n; 
        for(int i = 1;i<=n;i++){
            if(friends[i]==0){
                if(i>1 && friends[i-1]>=2){
                    friends[i]++;
                    friends[i-1]--;
                }
                else if(i<n && friends[i+1]>=2){
                    friends[i]++;
                    friends[i+1]--;
                }else{
                    answer--;
                }
            } 
            
        }
        
        return answer;
    }
}
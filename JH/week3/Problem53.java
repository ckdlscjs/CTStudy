class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    int tmp = nums[i] + nums[j] + nums[k];
                    if(isPrime(tmp)){
                        System.out.println(tmp);
                        answer++;
                    }
                }
            }    
        }

        return answer;
    }
    
    static boolean isPrime(int n){
        int m = (int) Math.ceil(Math.sqrt(n));
        for(int i = 2;i<=m;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int n = phone_number.length();
        answer = phone_number.substring(n-4, n);
        for(int i =0;i<n-4;i++){
            answer = "*" + answer;
        }
        return answer;
    }
}
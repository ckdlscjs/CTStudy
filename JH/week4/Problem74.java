class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String K = "Kim";
        int idx = 0;
        for(int i =0;i<seoul.length;i++){
            if(seoul[i].equals(K)){
                idx = i;
                break;
            }
        }
        answer = String.format("김서방은 %d에 있다", idx);
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        String ret = "";
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%3);
            n/=3;
        }
        ret = sb.toString();
        int i = 0;
        for(;i<ret.length();i++){
            if(ret.charAt(i)!='0'){
                break;
            }
        }
        ret = ret.substring(i);
        int answer = 0;
        for (int j = 0;j<ret.length();j++){
            answer = (3*answer) + (ret.charAt(j) -48);
        }
        return answer;
    }
}
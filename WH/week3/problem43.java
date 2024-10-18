class Solution {
    static int left = 10;
    static int right = 12;
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers){
            sb.append(pressKey(num, hand));
        }
        return sb.toString();
    }
    
    public String pressKey(int number, String hand){
        if(number == 1 || number == 4 || number == 7){ // 1. 왼손 검지
            left = number;
            return "L";
        }else if(number == 3 || number == 6 || number == 9){ // 2. 오른손 검지
            right = number;
            return "R";
        }else{ // 3. 가까운 거리 탐색
            if(number == 0) number = 11;
            int leftDis = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
            int rightDis = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;
            if(leftDis == rightDis){// 3-1. 거리가 같다면 손잡이 확인
                if(hand.equals("left")){
                    left = number;
                    return "L";
                }else{
                    right = number;
                    return "R";
                }
            }else if(leftDis > rightDis){
                right = number;
                return "R";
            }else{
                left = number;
                return "L";
            }
        }
    }
}

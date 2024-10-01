package week1;

import java.util.HashMap;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> friendsEnum = new HashMap<>();
        int[][] friendsIndex = new int[friends.length][2];
        int[][] friendsGiftIndex = new int[friends.length][friends.length];
        
        int cnt = 0;
        for(String friend : friends){
            friendsEnum.put(friend, cnt++);
        }
        
        
        for(String gift : gifts){
            String[] give_giver = gift.split(" ");
            friendsGiftIndex[friendsEnum.get(give_giver[0])][friendsEnum.get(give_giver[1])]++; // ->
            friendsIndex[friendsEnum.get(give_giver[0])][0]++;
            friendsIndex[friendsEnum.get(give_giver[1])][1]++;
        }
        
        // next month 
        
        int[] ret = new int[friends.length];
        
        for(int i = 0;i< friends.length;i++){
            for(int j = i+1;j< friends.length;j++){
                int one = friendsEnum.get(friends[i]);
                int two = friendsEnum.get(friends[j]);
                if(friendsGiftIndex[one][two] != friendsGiftIndex[two][one]){
                    if(friendsGiftIndex[one][two] > friendsGiftIndex[two][one]){
                        ret[one]++;
                    }else{
                        ret[two]++;
                    }
                }else{// 선물지수 판단 
                    int one_gift_index = friendsIndex[one][0] - friendsIndex[one][1];
                    int two_gift_index = friendsIndex[two][0] - friendsIndex[two][1];
                    if (one_gift_index == two_gift_index){
                        continue;
                    }else{ // 
                        if(one_gift_index > two_gift_index){
                            ret[one]++;
                        }else{
                            ret[two]++;
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0;i<friends.length;i++){
            answer = (answer > ret[i]) ? answer : ret[i];
        }
        return answer;
    }
    
}

public class problem4{
    public static void main(String[] args) {
        
    }
}

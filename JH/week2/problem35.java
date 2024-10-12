package week2;

import java.util.HashMap;

public class problem35 {
    static class Solution {
        public int solution(String s) {
            String[] nums = {"zero", "one", "two", "three","four","five","six","seven","eight", "nine"};
            
            HashMap<String, Integer> map = new HashMap<>();

            int val = 0;
            for(String num : nums){
                map.put(Integer.toString(val), val);
                map.put(num, val++);
            }

            int answer = 0;
            boolean flag = false;
            String tmp_str = "";
            for(int i = 0;i<s.length();){
                Character tmp = (Character) s.charAt(i);
                // System.out.println(tmp_str + " " + "#");
                if(map.getOrDefault(tmp_str, -1)>=0){
                    answer = (10*answer + map.get(tmp_str));
                    tmp_str = "";
                }

                if('0' <= tmp && tmp <= '9') { // flag = true -> false
                    if(flag){
                        flag = false;
                        tmp_str = "";
                        continue;
                    }
                    tmp_str += tmp;
                }else{ // flag = false -> true
                    if(!flag){
                        flag = true;
                        tmp_str = "";
                        continue;
                    }
                    tmp_str += tmp;
                }
                i++;
            }        

            if(map.getOrDefault(tmp_str, -1)>=0){
                answer = (10*answer + map.get(tmp_str));
                tmp_str = "";
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {

    }
}

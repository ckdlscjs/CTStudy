// package week1;

import java.util.ArrayDeque;
import java.util.Deque;
 

public class problem16 {
    
    static class Solution {
            
        public String convertTimeToInt(String Time){
            String[] TT = Time.split("\\.");
            String ret = "";
            for(int i = 0;i<TT.length;i++){
                ret += TT[i];
            }
            return ret;
        }

        public String calculDate(String cur, int month){
            // System.out.println(cur + " 324");
            String cur_date = convertTimeToInt(cur);
            int ccur_date = Integer.parseInt(cur_date);
            // System.out.println(ccur_date);
            int mm = month % 12;
            int year = month / 12;
            int cur_year = ccur_date / 10000; // 20240312
            int cur_month = (ccur_date % 10000) / 100;
            cur_year += year;
            cur_month += mm;
            if(cur_month>12){
                cur_month-=12;
                cur_year+=1;
            }
            int cur_days = ccur_date%100 -1;
            if(cur_days<=0){
                cur_month-=1;
                if(cur_month<=0){
                    cur_year-=1; 
                    cur_month+=12;
                    cur_days = 28;
                }else{
                    cur_days = 28;
                }
            }

            String[] date = {String.format("%04d", cur_year), 
                            String.format("%02d",cur_month),
                            String.format("%02d",cur_days)};

            String ret = "";
            for(String t : date){
                ret += t;
            }
            return ret;
        }

        public int[] solution(String today, String[] terms, String[] privacies) {
            // int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            //              1   2   3   4   5   6   7   8   9  10  11  12
            // 윤년 
            int[] month = new int[12];

//             int [] prevSumMonth = new int[month.length];
                
//             month[0] = 28;
//             prevSumMonth[0] = month[0];
//             for(int i = 1;i<month.length;i++){
//                 month[i] = 28;
//                 prevSumMonth[i] = prevSumMonth[i-1] + month[i];
//             }
            
            // 일수로 바꾸기 
            

            Deque<Integer> deq = new ArrayDeque<>();
            // 조건에 맞는 것들을 더하기 위한
            int[] answer;
            String time_today = convertTimeToInt(today);
            // String until = calculDate("2022.01.01", 30);
            // System.out.println(time_today + " " + until);
            for(int i = 0;i<privacies.length;i++){            
                String[] privacy = privacies[i].split(" ");

                char cur = (privacy[1].charAt(0));
                int j = 0;
                for(j = 0;j<terms.length;j++){
                    if(terms[j].charAt(0)==cur){
                        break;
                    }
                }

                int m = Integer.parseInt(String.valueOf(terms[j].substring(2)));
                // 계산해서 today 보다 이후에 나온 거면 ㄴㄴ 
                String until = calculDate((privacy[0]), m);
                System.out.println(time_today + " " + until);
                if(until.compareTo(time_today)<0){
                    deq.push(i+1);
                } 
            }
            answer = new int[deq.size()];            
            for(int i = 0;i<deq.size();i++){
                // System.out.println(deq.peekFirst());
                deq.addLast(deq.peekFirst());
                deq.pollFirst();
            }
            int leng = deq.size();
            for(int k = 0;k<leng;k++){
                // if(deq.peekLast()==0) break;
                answer[k] = deq.pollLast();
            }
    
            // System.out.println(Arrays.toString(answer));
            return answer;
        }
    }
    
    public static void main(String[] args) {
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        Solution ss = new Solution();	
        ss.solution("2020.01.01", terms, privacies);

    }
}


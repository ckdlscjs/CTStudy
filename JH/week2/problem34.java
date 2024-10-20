package week2;

public class problem34 {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0L;
            long price_l = price;
            long acc_price_l = 0L;
            long money_l = money;
            long count_l = count;
            
            // 3*(1+2+3+4) (n+1)(n)/2 
            int idx = 0;
            while(idx < count){
                idx++;
                acc_price_l += (price_l);
                price_l += price;
            }
            return (money_l - acc_price_l>=0)? 0 : -(money_l - acc_price_l);
        }
    }
    public static void main(String[] args) {
        
    }
}

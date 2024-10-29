public class problem83{
    class Solution {
        public String solution(int a, int b) {
            // a=5;
            // b=24;
            String answer = "";
            // offset 0 -> FRI
            int[] M = {31, 29, 31, 
                       30, 31, 30, 
                       31, 31, 30, 
                       31, 30, 31};
            int[] acc = new int[13]; // 이전까지 
            
            acc[0] = 0;
            for(int i = 1;i<12;i++){
                acc[i] = acc[i-1] + M[i-1];
            }
            
            int cur = acc[a-1] + b-1;
            String[] days = "FRI,SAT,SUN,MON,TUE,WED,THU".split(",");
            // System.out.println(cur);
            return days[cur%7];
        }
    }
    
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( \')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
}
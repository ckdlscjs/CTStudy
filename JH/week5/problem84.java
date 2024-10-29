
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.function.BiFunction;

// public class problem84{
//     public static void main(String[] args) 
//         throws IOException{
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         int[] nums = Arrays.stream(bf.readLine().split(" "))
//                             .mapToInt(s->Integer.parseInt(s))
//                             .toArray();
        
//         BiFunction<Integer, Integer, Integer>[] functions = new BiFunction[5];
//         functions[0] = problem84::sum;
//         functions[1] = problem84::sub;
//         functions[2] = problem84::mul;
//         functions[3] = problem84::div;
//         functions[4] = problem84::rem;
//         for(int i = 0;i<5;i++){
//             System.out.println(functions[i].apply(nums[0], nums[1]));
//         }

//     }
//     public static int sum(int a, int b){
//         return a+b;
//     }
//     public static int sub(int a, int b){
//         return a-b;
//     }
//     public static int mul(int a, int b){
//         return a*b;
//     }
//     public static int div(int a, int b){
//         return a/b;
//     }
//     public static int rem(int a, int b){
//         return a%b;
//     }
// }


public class problem84{
    static class Solution {
    
        public int solution(int[] nums) {
            int answer = 0;
            int[] cnts = new int[200001];
            for(int num : nums){
                cnts[num]++;
            }
            
            int n = (nums.length)/2;
            
            for(int i = 1;i<=200000;i++){
                if(answer==n) break;
                if(cnts[i]>0){
                    answer++;    
                }
            }
            return answer;
        }
    }
    
    
    public static void main(String[] args) {
        
    }
}

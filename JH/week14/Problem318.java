package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Problem318 {
    static int[] nums;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static ArrayList<Integer> operators = new ArrayList<>();
    static int[] operations = new int[4];

    static BiFunction<Integer, Integer, Integer> add = Integer::sum;
    static BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
    static BiFunction<Integer, Integer, Integer> mul = (a, b) -> a * b;
    static BiFunction<Integer, Integer, Integer> div = new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer a, Integer b) {
            boolean flag1 = false;
            boolean flag2 = false;
            if (a < 0) {
                flag1 = true;
                a *= -1;
            }
            if (b < 0) {
                flag2 = true;
                b *= -1;
            }
            if (!(flag1 ^ flag2)) {
                return a / b;
            } else {
                int quo = a / b;
                return -quo;
            }

        }
    };

    public static void main(String[] args)
    throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, N - 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void backtracking(int cnt, int N) {

        if (cnt == N) {
            int tmp = nums[0];
            // System.out.println(operators);
            for(int j = 0; j < operators.size(); j++) {
                int opr = operators.get(j);
                tmp = findOperation(opr).apply(tmp, nums[j + 1]);
            }
            MAX = Math.max(tmp, MAX);
            MIN = Math.min(tmp, MIN);
            return;
        }

        for(int i = 0;i<4;i++){
        // 0 : add, 1 : sub, 2 : mul, 3 : div
            if (operations[i] > 0) {
                operators.add(i);
                operations[i]--;
                backtracking(cnt+1, N);
                operators.remove(operators.size()-1); // removeLast
                operations[i]++;
            }
        }
    }

    private static BiFunction<Integer, Integer, Integer> findOperation(int idx){
        if(idx==0){
            return add;
        }
        else if(idx==1){
            return sub;
        }
        else if(idx==2){
            return mul;
        }
        return div;
    }
}

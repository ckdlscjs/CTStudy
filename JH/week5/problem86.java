import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class problem86 {

    static boolean flag = false;
    static boolean[] chk = new boolean[20];
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args)
            throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0;i<9;i++){
            nums.add(Integer.parseInt(bf.readLine()));
        }

        System.out.println();
        backtracing(new ArrayList<Integer>(), 0, 0);
     }
    // backtracking style

    public static void backtracing(ArrayList<Integer> arr, int cnt, int idx){

        if(flag) return;

        if(cnt == 7) {
            if (arr.size() == 7) {
//                System.out.println(arr.size());
//                System.out.println(arr + " " + ret);

                int ret = arr.stream().reduce(0, (subtotal, element) -> (subtotal + nums.get(element)));
                if (ret == 100) {
                    Collections.sort(arr, (a,b) -> Integer.compare(nums.get(a), nums.get(b)));
                    String res = arr.stream().map(integer -> String.valueOf(nums.get(integer)))
                            .collect(Collectors.joining("\n"));

                    System.out.println(res);
                    flag = true;
                }
            }
            return;
        }

        for (int i = idx; i < 9; i++){
            if(!chk[i]){
                chk[i] = true;
                arr.add(i);
                backtracing(arr, cnt+1, i);
                arr.remove(arr.size()-1);
                chk[i] = false;
            }
        }
    }
}

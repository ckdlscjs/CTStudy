import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class problem89{
    public static void main(String[] args) 
        throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] stores = new int[20];
        for(int i = 0;i<20;i++){
            stores[i] = i+1;
        }

        for (int idx = 0; idx < 10; idx++) {
            int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();





            int a = nums[0]-1;
            int b = nums[1]-1;
            ArrayList<Integer> tmp = new ArrayList<>();
            // ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for(int i=a;i<=b;i++){
                tmp.add(stores[i]);
            }
            // Collections.sort(tmp, new Comparator<Integer>(){
            //     @Override
            //     public int compare (Integer o1, Integer o2){
            //         return Integer.compare(o2, o1);
            //     }
            // });
            // System.out.println(a + " " + b);
            for(int i=a;i<=b;i++){
                stores[i] = tmp.get(b-i);// 1 4 -> 0 1 2 3  
            }
        }
        for (int num : stores) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}
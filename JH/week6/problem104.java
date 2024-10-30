
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class problem104{
    
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bf.readLine());

        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0;i<N;i++){
            if (x - nums[i] <= 0) break;
            int idx = isPossible(nums, N, x-nums[i]);
            if(idx==N || idx == i) continue;
            else{
                // System.out.println(idx +" "  + i);
                cnt++;
            }
        }
        System.out.println(cnt/2);
    }

    static int isPossible(int[] arr, int N, int x){
        int l = 0;
        int r = N;
        while(l<N && l<=r){
            int m = (l+r)/2;
            if (arr[m] < x){ // x - arr[m] 
                l = m+1;
            }
            else if(arr[m] > x){
                r = m-1;
            }
            else{
                return m;
            }
        }
        return N;
    }
}
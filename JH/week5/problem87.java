import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

 
public  class  problem87{

    public static void main(String[] args) 
        throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long[] nums = Arrays.stream(bf.readLine().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
        long N = nums[0];
        long M = nums[1];
        if(N>=M){
            long tmp = M;
            M = N;
            N = tmp;
        }

        if (M-N-1<=0){ // N+1 ... M-1= > 1 ... M-N-1
            System.out.println(0);
            return;
        }

        System.out.println(M-N-1);
        StringBuilder sb = new StringBuilder();
        long one = 1;
        for(long i = N+one;i<M;i+=one){
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);

    }
}
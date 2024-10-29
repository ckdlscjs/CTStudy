
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem100{
    public static void main(String[] args) 
        throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0;i<9;i++){
            int tmp = Integer.parseInt(bf.readLine());
            if(M<tmp){
                M = tmp;
                idx = i;
            }
        }
        System.out.println(M);
        System.out.println(idx+1);
    }
    
}
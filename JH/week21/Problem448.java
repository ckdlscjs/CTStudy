import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem448 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean ascending = true;
        boolean descending = true;
        int prev = 0;
        for(int i = 0;i<8;i++){
            int num = Integer.parseInt(st.nextToken());
            if(prev!=0){
                if(prev < num){
                    descending = false;
                }

                if(prev > num){
                    ascending = false;
                }

                prev = num;
            }else{
                prev = num;
            }
        }

        System.out.println( (!(ascending || descending)) ? "mixed" : ((ascending) ? "ascending" : "descending"));
    }
}

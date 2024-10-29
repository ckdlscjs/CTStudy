import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public  class problem96{
    public static void main(String[] args) 
        throws IOException{
        
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(bf.readLine());
            for (int i = 1; i <= n; i++) {
                for(int j = 1;j<i;j++){
                    bw.write(" ");
                }
                for(int j = 0;j<2*(n-i)+1;j++){
                    bw.write(42);
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
            bf.close();
    }
}
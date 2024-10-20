import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = (bf.readLine()).split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<b;i++){
            for(int j =0;j<a;j++){
                sb.append('*');
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
}
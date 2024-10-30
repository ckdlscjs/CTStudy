
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class problem101{
    public static void main(String[] args) 
    throws IOException{
        int[] arr = new int[26];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String in  = (bf.readLine());
        for(char c : in.toCharArray()){
            arr[c-'a']++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int num : arr){
            bw.write(num + " ");    
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
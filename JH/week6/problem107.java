
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class problem107{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0 ;i<N;i++){
            String[] AB = bf.readLine().split(" ");
            String A = AB[0];
            String B = AB[1];
            if(doTheyHaveSameChars(A,B)){
                // System.out.println("Possible");
                sb.append("Possible");
            }else{
                sb.append("Impossible");
                // System.out.println("Impossible");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean doTheyHaveSameChars(String a, String b){
        int[] aa = new int[26];
        for(char c : a.toCharArray()){
            aa[c-'a']++;
        }

        int[] bb = new int[26];
        for(char c : b.toCharArray()){
            bb[c-'a']++;
        }

        for(int i = 0;i<26;i++){
            if(aa[i]!=bb[i]) return false;
        }

        return true;
    }
}
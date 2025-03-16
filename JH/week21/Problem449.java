import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem449 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] modulos = new int[42];
        for(int i = 0;i<10;i++){
            int num = Integer.parseInt(bf.readLine());
            modulos[num%42] ++;
        }

        int cnt = 0;
        for(int i = 0;i<42;i++){
            if(modulos[i]>0) cnt++;
        }
        System.out.println(cnt);
    }
}
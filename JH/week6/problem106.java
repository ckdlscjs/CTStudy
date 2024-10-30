
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class problem106{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];
        int[][] school = new int[6][2];

        for(int i = 0;i<N;i++){
            int[] genderClass = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            school[genderClass[1]-1][genderClass[0]]++;
        }

        int cnt = 0;
        for(int i = 0;i<6;i++){
            for(int j = 0; j<2;j++){
                cnt += (school[i][j]/K) + ((school[i][j]%K >0) ? 1 : 0);
            }
        }
        System.out.println(cnt);
        return;
    }
}
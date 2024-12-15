import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main166 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N+1];
        int[][][] dp = new int[2][N+1][M+1];

        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(bf.readLine()) - 1;
        }

        if(nums[1]==0){
            dp[0][1][0] = 1;
        }
    
        if(M>0){
            dp[1][1][1] = (nums[1]==1) ? 1 : 0;
        }

        for(int i = 2; i <= N; i++) {
            int fruit = nums[i];
            for(int j = 0;j<=M;j++){
                if(j>i) break;
                if(fruit==0){
                    dp[0][i][j] = dp[0][i-1][j]+1;
                }else{
                    dp[0][i][j] = dp[0][i-1][j];
                }

                if(j>0){
                    int tmp = dp[1][i-1][j-1] + (fruit == 0 ? 1 : 0);
                    dp[0][i][j] = Math.max(dp[0][i][j], tmp);
                }

                if(fruit == 1){
                    dp[1][i][j] = dp[1][i-1][j] + 1;
                }else{
                    dp[1][i][j] = dp[1][i-1][j];
                }

                if(j>0){
                    int tmp = dp[0][i-1][j-1] + (fruit == 1 ? 1 : 0);
                    dp[1][i][j] = Math.max(dp[1][i][j], tmp);
                }
            }
        }

        int ret = 0;
        for(int i = 0;i<=M;i++){
            int tmp = Math.max(dp[0][N][i], dp[1][N][i]);
            ret = Math.max(ret, tmp);
        }
        System.out.println(ret);
    }
}

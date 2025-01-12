package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem317 {
    static  int mod = (int) Math.pow(10,9) + 3;
    public static void main(String[] args)
            throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 색의 개수
        int K = Integer.parseInt(bf.readLine()); // 색상환에서 선택하는 개수

        int[][] dp = new int[N+1][K+1];
        // dp[1][1] = 1; // 하나의 색을 쓸 때 하나의 색을 칠하는 경우는 당연히 하나밖에 없음
        // dp[N][0] = 1; // 여러가지 색 중에 아무 것도 칠하지 않는 경우는 empty set 하나만 존재함.
        // dp[N][1] = N; // 여러가지 색 중에 단 하나만 선택해야 하는 경우는 N가지 존재함.

        for(int i = 0;i<=N;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<=N;i++){
            dp[i][1] = i;
        }

        // 1. 선형 dp
        for(int k = 2; k <= K; k++){
            for(int n = 2; n <= N; n++){
                dp[n][k] = (dp[n - 1][k] + dp[n - 2][k - 1]) % mod;
                // 현재 값을 사용하지 않고 k개 만들기, 현재 값을 사용하고 남은 k-1 만들기
                // but dp는 가짓수를 천천히 채워야 하므로 k=2부터 시작 <- k=1는 base 케이스로 위에서 이미 정의함
            }
        }

        // 2. 원형 dp
        System.out.println( (dp[N-1][K] + dp[N-3][K-1]) % mod);
        // 1번을 선택하지 않고, 나머지 N-1 중에서 K개를 선택할 것이냐
        // 1번을 선택하고, 나머지 N-3 중에서 K-1개를 선택할 것이냐

    }
}

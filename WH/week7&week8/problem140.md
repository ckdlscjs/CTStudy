https://www.acmicpc.net/problem/2579

규칙) 
1. 한번에 한계단 or 두 계단
2. 연속된 세개의 계단 x 
3. 마지막 도착 계단은 반드시 밟아야 함

총 점수의 최댓값 구하기


계단의 수 300 이하
점수 10,000 이하

f(n) = f(n-1) + f(n-2)  (n >=5)

300까지의 점화식 배열은 다 구해놧음. 

그럼 처음 계단의 개수가 주어지면 
각 계단의 점수가 적힌 배열을 생성.

점화식 값만큼 경우의수를 
```java
import java.io.*;
import java.util.*;

class Main {
    static Integer dp[];
    static int scores[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // NOTE: dp 배열에 score 최댓값 저장
        dp = new Integer[n + 1]; // Integer로 선언한 이유 : null로 초기화
        scores = new int[n + 1];

        for(int i = 1; i < n + 1; i+=1){
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = scores[0];
        dp[1] = scores[1];

        if(n >= 2) dp[2] = scores[1] + scores[2];

        System.out.println(step(n));
    }
    // NOTE: dp 배열 채우기 -> n - 1 을 기준으로 나누어 계산하기
    static int step(int n){
        if(dp[n] == null){
            dp[n] = Math.max(step(n - 2), step(n - 3) + scores[n - 1]) + scores[n];
        }
        return dp[n];
    }
}
```

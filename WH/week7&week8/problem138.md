https://www.acmicpc.net/problem/11726

n <= 1000

2 * n  크기의 직사각형을 1 x 2, 2 x 1 타일로 채우는 방법의 수

DP문제는 점화식을 찾는 것이 가장 중요하다. 

n = 1 ) 1가지 
n = 2 ) 2가지
n = 3 ) 3가지
n = 4 ) 4가지

이를 토대로, 점화식 f(n) = f(n-1) + f(n-2) (n>=2) 을 세울 수 있다.

```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // NOTE: 점화식 작성
        for(int i = 4; i < dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
```

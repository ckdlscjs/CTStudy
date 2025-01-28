https://www.acmicpc.net/problem/9095

합을 나타낼때에는 1개 이상의 수를 사용해야한다.

정수 n이 주어졌을때 1, 2, 3의 합으로 나타내는 방법의 수 출력

dp[n] = dp[n-1] + dp[n-2] + dp[n-3] 의 점화식을 얻을 수 있다.

```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
        int T = Integer.parseInt(br.readLine());  
        int[] dp = new int[12];  
        dp[1] = 1;  
        dp[2] = 2;  
        dp[3] = 4;  
        for(int i = 4; i <= 11; i++){  
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];  
        }  
  
        // 1, 2, 3 으로만 나타내는 방법  
        for(int i = 0; i < T; i++){  
            int n = Integer.parseInt(br.readLine());  
            System.out.println(dp[n]);  
        }  
    }  
}
```

dp 문제는 점화식을 찾는것이 관건이다.

시간 복잡도: n이 11이하라서 dp 배열을 만드는게 가능했을 것이라 생각. -> O(11)

재귀식으로 문제를 푸는 것과 시간과 메모리 측면에서 차이가 날까
n이 커지면 커질수록 재귀식으로 푸는 것이 더 효율적일까?

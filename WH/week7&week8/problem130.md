https://www.acmicpc.net/problem/10799

쇠막대기는 자기 자신보다 긴 쇠막대기 위에만 놓일 수 있다. -> 짧을 수록 위에 넣기 
각 쇠막대기는 구간 안에 포함된 레이저 개수 +1개로 나누어진다. 

여는 괄호가 어디에 위치했었는지 저장 
아 어렵다,,

## 쇠막대기의 관점에서 풀이
  ```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
        String input = br.readLine();  
        int N = input.length();  
        char[] arr = new char[N + 1];  
        System.arraycopy(input.toCharArray(), 0, arr, 1, N);  
  
        int[] laser = new int[N + 1];  
        for(int i = 1; i <= N; i++){  
            laser[i] = laser[i - 1];  
            if(arr[i] == '(' && arr[i + 1] == ')')  
                laser[i]++; // store laser index  
        }  
  
        int answer = 0;  
        int[] stack = new int[N + 1];  
        int topIndex = -1;  
        for(int i = 1; i <= N; i++){  
            if(arr[i] == '(' && arr[i + 1] != ')'){ // not laser  
                stack[++topIndex] = i;  
            }else if(arr[i] == ')' && arr[i - 1] != '('){ // not laser  
                int openIndex = stack[topIndex--];  
                answer += laser[i] - laser[openIndex - 1] + 1;  
            }  
        }  
        System.out.println(answer);  
        br.close();  
    }  
}
```

## 레이저의 관점에서 풀이

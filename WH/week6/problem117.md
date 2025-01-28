## 입력
1 <= N <= 1,000,000 => NlogN 이하의 알고리즘

## 출력
총 N개의 수를 공백으로 구분하여 출력한다.

## 접근방법

현재 원소가 이전원소보다 작을때까지 스택에 push


```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++){
            sb.append(arr[i] + " ");;
        }
        System.out.println(sb);
    }
}
```

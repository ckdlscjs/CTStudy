https://www.acmicpc.net/problem/15552

```java
package CodingTest;  

import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws  IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;  
  
        int N = Integer.parseInt(br.readLine());  
        for(int i = 0; i < N; i++){  
            st = new StringTokenizer(br.readLine());  
            int a = Integer.parseInt(st.nextToken());  
            int b = Integer.parseInt(st.nextToken());  
            bw.write(a + b + "\n");  
        }  
        bw.flush();  
        bw.close();  
    }  
}
```
bw.write(a+b + "\n")

```java
bw.write(a+b)

System.out.println();
```
위 방식으로 할 경우 출력방식이 BufferedWriter는 버퍼에 저장이되고 
System.out.prinln(); 은 표준 출력스트림이므로 콘솔에 출력되므로 
혼합되어서 쓸 경우 출력의 순서가 제대로 나타나지 않을 수 있다.

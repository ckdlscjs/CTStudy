https://www.acmicpc.net/problem/10807

package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
  
        int n = Integer.parseInt(br.readLine());  
        int[] arr = new int[n];  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int i = 0;  
        while(st.hasMoreTokens()){  
            arr[i++] = Integer.parseInt(st.nextToken());  
        }  
        int x = Integer.parseInt(br.readLine());  
  
        int count = 0;  
        for(int j = 0; j < n; j++){  
            if(arr[j] == x) count++;  
        }  
        System.out.println(count);  
    }  
}


더 고민해봐야될게 무엇이 있을까 어떤 부분을 디벨롭 시킬까 

br.readLine으로 읽은 String값을 int형 배열로 선언하고 싶을때
```java
int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt()).toArray();
```

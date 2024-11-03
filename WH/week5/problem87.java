
```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws  IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String[] arr = br.readLine().split(" ");  
        long firstNum = Math.min(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));  
        long secondNum = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));  
  
        long cnt = firstNum != secondNum ? secondNum - firstNum - 1 : 0;  
  
        System.out.println(cnt);  
        if(cnt != 0) {  
            long tmp = secondNum - 1;  
            for (long i = firstNum + 1; i < secondNum - 1; i += 1) {  
                System.out.print(i + " ");  
            }  
            System.out.println(tmp);  
        }  
    }  
}
```
30점

```java

package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws  IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String[] arr = br.readLine().split(" ");  
        long firstNum = Math.min(Long.parseLong(arr[0]), Long.parseLong(arr[1]));  
        long secondNum = Math.max(Long.parseLong(arr[0]), Long.parseLong(arr[1]));  
  
        long cnt = firstNum != secondNum ? secondNum - firstNum - 1 : 0;  
  
        System.out.println(cnt);  
        if(cnt != 0) {  
            for (long i = firstNum + 1; i < secondNum; i += 1) {  
                System.out.print(i + " ");  
            }  
        }  
    }  
}
```
100점

parseLong까지 해주어야한다.!!

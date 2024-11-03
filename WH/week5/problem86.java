https://www.acmicpc.net/problem/2309


```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws  IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
  
        int[] arr = new int[9];  
        int nonMemA = 0;  
        int nonMemB = 0;  
        int sum = 0;  
        for(int i = 0; i < arr.length; i+=1){  
            arr[i] = Integer.parseInt(br.readLine());  
            sum += arr[i];  
        }  
  
        for(int i = 0; i < arr.length; i+=1){  
            for(int j = i+1; j < arr.length; j+=1){  
                int nonMem = arr[i] + arr[j];  
                if(sum - nonMem == 100){  
                    nonMemA = arr[i];  
                    nonMemB = arr[j];  
                }  
            }  
        }  
        Arrays.sort(arr);  
        for(int i = 0; i < arr.length; i+=1){  
            if(arr[i] != nonMemA && arr[i] != nonMemB)  
                System.out.println(arr[i]);  
        }  
  
    }  
}
```

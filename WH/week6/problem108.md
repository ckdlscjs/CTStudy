https://www.acmicpc.net/problem/1919

두 개의 영어 단어가 주어졌을때 서로 애너그램 관계에 있도록 만들기 위해 제거해야하는 최소 개수의 문자 수 

aabbcc
xxyybb

aa cc제거 xx yy제거 

크기가 26인 배열을 두개 생성한 다음 각 알파벳 순서에 맞는 인덱스에 1씩 더하여 개수를 카운트한다.

그다음 배열을 순회하면서 값이 다르면 카운트++ 
각 단어는 1000자를 넘지 않는다. 배열로 만들기 위한 시간복잡도 2* O(1000) + O(26)

```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
        char[] word1 = br.readLine().toCharArray();  
        char[] word2 = br.readLine().toCharArray();  
        int[] arr1 = new int[26];  
        int[] arr2 = new int[26];  
        int count = 0;  
  
        // NOTE: 알파벳 인덱스 배열 생성  
        for(int i = 0; i < word1.length; i++){  
            arr1[word1[i] - 97]++;  
        }  
        for(int i = 0; i < word2.length; i++){  
            arr2[word2[i] - 97]++;  
        }  
  
        // NOTE: 알파벳 배열 순회  
        for(int i = 0; i < arr1.length; i++){  
            if(arr1[i] != arr2[i]){  
                int max = Math.max(arr1[i], arr2[i]);  
                int min = Math.min(arr1[i], arr2[i]);  
                count += (max - min);  
            }  
        }  
  
        System.out.println(count);  
  
    }  
}
```

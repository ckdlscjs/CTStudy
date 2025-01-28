https://www.acmicpc.net/problem/5397

L인 문자열이 주어진다. (1 <= L <= 1,000,000)

만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한칸 이동한다.
=> 이 말이 무슨말이지.

n이 몇개인지는 안주어지는군 
O(1,000,000) => nlogn 이하의 알ㅁ고리즘을 구현해야함  

내풀이 미완
```java
import java.io.*;  
import java.util.*;  
import java.util.stream.Collectors;  
import java.util.stream.IntStream;  
  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb;  
  
        int n = Integer.parseInt(br.readLine());  
  
        while(n-- > 0){  
            sb = new StringBuilder(br.readLine());  
            int cursor = 0;  
            List<Character> pw = new ArrayList<>();  
            for(int i = 0; i < sb.length(); i++){  
                char c = sb.charAt(i);  
                switch(c){  
                    case '<':  
                        if(cursor != 0)  
                            cursor -= 1;  
                        continue;  
                    case '>':  
                        if(cursor < pw.size())  
                            cursor += 1;  
                        continue;  
                    case '-':  
                        if(pw.)  
                         pw.remove(cursor);  
                        continue;  
                    default:  
                        pw.add(cursor, c);  
                        cursor++;  
                        break;  
                }  
            }  
            StringBuilder ans = new StringBuilder();  
            for(int i = 0; i < pw.size(); i++){  
                ans.append(pw.get(i));  
            }  
            System.out.println(ans.toString());  
        }  
    }  
}
```

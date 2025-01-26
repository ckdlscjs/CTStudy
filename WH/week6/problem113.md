재현이는 잘못 된 수를 부를 때마다 0을 외쳐서 재민이가 쓴 수를 지우게 시킨다.
이렇게 모든 수를 받아 적은 다음 그 수의 합은?
정수 K (1 <= K <= 100,000)

풀이과정 : 
간단한 로직. 0이면 pop() 하고 아니면 push()한다.
```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
class Main {  
    public static void main(String[] args) throws Exception {  
        Scanner sc = new Scanner(System.in);  
        ArrayDeque<Integer> stack = new ArrayDeque<>();  
  
        int k = sc.nextInt();  
        int sum = 0;  
  
        while(k-- > 0){  
            int n = sc.nextInt();  
            if(n == 0){  
                stack.poll();  
            }else stack.push(n);  
        }  
        while(!stack.isEmpty()){  
            sum += stack.pop();  
        }  
        System.out.println(sum);  
    }  
}
```

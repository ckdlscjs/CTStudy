https://www.acmicpc.net/problem/2562

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                idx = i;
            }
        }
        bw.write(max + "\n");
        bw.write(idx + "\n");
        bw.flush();
    }
}

```
bw.write() 정수 출력하려면 꼭 개행문자가 붙어야하는가?
bw.write 는 문자열만 출력할 수 있기 때문에 int 형 변수를 출력하려고 하면 오류가 발생할 수 있다.
int 형 변수를 String.valueOf(int)를 사용하여 String값으로 변환하여 출력해야한다.
또는 "\n"개행문자를 붙여 출력할 수 있다. 

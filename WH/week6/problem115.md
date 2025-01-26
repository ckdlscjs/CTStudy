https://www.acmicpc.net/problem/2493

## 입력
1 <= N <= 500,000
탑의 높이 <= 100,000,000
## 출력
각 탑이 발사한 레이저를 수신하는 탑들의 번호를 출력한다. 

## 접근 방법
이전 원소가 현재원소보다 커야지 벽과 만나 수신이 됩니다. 
6 9 5 7 4
이게 스택이랑 무슨 상관인거지 
일단 배열 두개 선언 배열 맨 마지막 부터 스택에 넣음 

```java
for(int i = towers.length -1; i >= 0; i--){
	int startIdx = i - 1;
	while(true){
		if(towers[startIdx] > towers[i]){
			received[i] = startIdx + 1;
			startIdx--;
			break;
		}else{
			startIdx--;
		}
	}
}
```

맨 마지막 배열 원소 스택에 집어넣음.
앞 원소들 순회하면서 큰거 있으면 인덱스 저장. 없으면 계속 푸시 
시간복잡도 O(n^2) --> 시간초과 발생
```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] received = new int[n];

        for(int i = towers.length - 1; i >= 0; i--){
            int startIdx = i - 1;
            while(startIdx >= 0){  
                if(towers[startIdx] > towers[i]){
                    received[i] = startIdx + 1;
                    break;
                }
                startIdx--;
            }
            if(startIdx < 0){  
                received[i] = 0;
            }
        }

        for(int i = 0; i < n; i++){ 
            bw.write(received[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
```

시간복잡도 O(n)
- index 1부터 n 까지 순차적으로 진행
	- 스택의 top이 현재 탑의 높이보다 작으면 pop (스택이 empty를 기준으로 하기)
	- 스택이 비어있지 않으면  stack의 top이 신호 수신
		- top의 인덱스를 저장

스택을 이용한 풀이)
```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] received = new int[n + 1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && towers[stack.peek()] < towers[i]){
                stack.pop();
            }

            received[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        for(int i = 0; i < n; i++){
            bw.write(received[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
```

기준을 스택이 비어있는 상태로 하는 것임
- 스택이 비어있으면 0 출력
- 스택이 비어있지 않으면
	- 스택 상단 원소를 peek 한 것이 현재 높이보다 높은경우
		- peek한 인덱스를 출력하고 현재 탑의 높이를 push한다.
	- 스택 상단 원소를 peek 한 것이 현재 높이보다 낮은 경우
		- pop을 해서 스택을 비어있는상태로 만들어줌
블로그 참고 풀이)
```java
import java.io.*;  
import java.util.*;  
import java.util.stream.*;  
  
class Top{  
    int num;  
    int height;  
    Top(int num, int height){  
        this.num = num;  
        this.height = height;  
    }  
}  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;  
        int N = Integer.parseInt(br.readLine());  
  
        Stack<Top> stack = new Stack<>();  
        StringBuilder sb = new StringBuilder();  
        st = new StringTokenizer(br.readLine());  
        for(int i = 1; i <= N;  i++){  
            int height = Integer.parseInt(st.nextToken());  
  
            if(stack.isEmpty()){  
                sb.append("0 ");  
                stack.push(new Top(i, height));  
            }else{  
                while(true){  
                    if(stack.isEmpty()){  
                        sb.append("0 ");  
                        stack.push(new Top(i, height));  
                        break;  
                    }  
                    Top top = stack.peek();  
  
                    if(top.height > height){  
                        sb.append(top.num + " ");  
                        stack.push(new Top(i, height));  
                        break;  
                    }else{  
                        stack.pop();  
                    }  
                }  
            }  
        }  
        bw.write(sb.toString());  
        bw.flush();  
        bw.close();  
    }  
}
```

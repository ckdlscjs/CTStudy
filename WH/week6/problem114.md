https://www.acmicpc.net/problem/1874

1 <= n <= 100,000

push -> +
pop -> -

## 접근 방법
스택에 1부터 n까지의 수를 스택에 넣고 push/pop을 통해 주어진 수열을 만들 수 있는지 판단하는 문제입니다.
오름차순으로 push하여 스택에 수를 넣어야합니다. 


수열의 처음 값은 4이다. 그러므로 1부터 4까지 스택에 push를 한다.
```java
int pointer = 0;

int value = input(); // 4

if(value > pointer){
	for(int i = pointer + 1; i <= value; i++){
		stack.push(i);
	}
	pointer = value;
}

```
어디까지 입력받았는지 알기 위한 변수 start를 value 값으로 갱신해주어야 합니다.

스택의 맨 위의 원소가 입력받은 원소와 같다면 pop()을 하고, 같지 않다면 "NO"입니다.

```java
int pointer = 0;

int value = input();

if(value > pointer){ // NOTE: value까지는 push를 해야한다.
	for(int i = pointer + 1; i <= value; i++){
			stack.push(i);
	}
	pointer = value;
}
// NOTE: 맨위의 원소와 입력받은 원소가 다른 경우
else if(stack.peek() != value){
	print("NO"); return;
}

// NOTE: value 까지 push가 되었다면 pop을 한다.
stack.pop();

```

```java
int pointer = 1;
for(int i = pointer; i <= value; i++)
```
pointer는 여기까지 스택에 집어넣었다는 것을 가리키는 변수이기 때문에 
for(int i = pointer; ; )가 되어버리면 이미 스택에 집어넣은 원소를 다시 한번 탐색하는 것이기 때문에 에러가 발생합니다. 


배열을 이용한 풀이) 
```java
import java.io.*;  
import java.util.*;  
import java.util.stream.*;  
  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();  
  
        int n = Integer.parseInt(br.readLine());  
        int[] stack = new int[n];  
  
        int idx = 0;  
        int start = 0;  
  
        while(n-- > 0){  
            int element = Integer.parseInt(br.readLine());  
            if(element > start){  
                for(int i = start + 1; i <= element; i++){  
                    stack[idx] = i;  
                    idx++;  
                    sb.append("+\n");  
                }  
                start = element;  
            }else if(stack[idx - 1] != element){  
                System.out.println("NO");  
                return;  
            }  
            idx--;  
            sb.append("-\n");  
        }  
        System.out.println(sb);  
    }  
}
```

시간복잡도 O(n) * O(1) (while문  x for문)

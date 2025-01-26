https://www.acmicpc.net/problem/1158

양의 정수 K(<=N)
K번째 사람 제거 

N<= 5000 

while 문으로 계속 돌아야하는데 
5000인 경우에 시간복잡도 통과할 수 있나 ? 3으로 나누어서 0이 될때까지 되니깐 될듯
제한시간 2초 -> 2억번 가능

모듈로 연산을 이용해서 계속 순회할 수 있지 않을까 ? 

먼저 원형 -> 모듈로 연산으로 구현 

첫번째 풀이) 연결리스트 모듈로 연산
```java
import java.io.*;  
import java.util.*;  
import java.util.stream.Collectors;  
import java.util.stream.IntStream;  
  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int n = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken());  
  
        StringBuilder sb = new StringBuilder();  
        List<Integer> list = IntStream.range(0, n).boxed().map(i -> i + 1).collect(Collectors.toList());  
  
        int index = 0;  
        sb.append("<");  
        while(list.size() > 1){  
	        // k - 1 만큼 이동, 리스트 사이즈 체크
            index = (index + k - 1) % list.size();  
            // index 위치 원소 제거
            sb.append(list.remove(index) + ", ");  
        }  
        sb.append(list.remove(0) + ">");  
        System.out.println(sb.toString());  
  
    }  
}
```

배열이라고 생각하면 n으로 모듈로 연산을 하지만 리스트에서 제거를 하기 때문에 list.size()로 나눠준다.

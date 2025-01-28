https://www.acmicpc.net/problem/1021

M <= N <= 50

N: 큐의 원소개수
M: 뽑아내려는 원소의 수

addLast와 addFirst 연산을 총 몇번 하는지 출력하라.(최솟값) 
덱의 첫번째 원소만 뽑을 수 있음 

중간 기준 앞에 있으면 2번연산
중간 기준 뒤에 있으면 3번연산

```java
import java.io.*;  
import java.util.*;  
import java.util.stream.*;  
  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String[] line1 = br.readLine().split(" ");  
        int n = Integer.parseInt(line1[0]);  
        int m = Integer.parseInt(line1[1]);  
        int[] findNums = Arrays.stream(br.readLine().split(" "))  
                .mapToInt(Integer::parseInt)  
                .toArray();  
        // NOTE: 인덱스 값을 알아야하므로 LinkedList선택  
        LinkedList<Integer> deque = new LinkedList<>(IntStream.rangeClosed(1, n)  
                .boxed().collect(Collectors.toList()));  
        int answer = 0;  
  
        // NOTE: 중간 인덱스보다 앞 -> 2번연산 || 중간인덱스보다 뒤 -> 3번연산  
        for(int i = 0; i < m; i++){  
            int targetIdx = deque.indexOf(findNums[i]);  
            int midIdx = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;  
  
            if(targetIdx <= midIdx){  
                // NOTE: 2번연산  
                for(int j = 0; j < targetIdx; j++){  
                    deque.addLast(deque.pollFirst());  
                    answer++;  
                }  
            }else{  
                for(int j = 0; j < deque.size() - targetIdx; j++){  
                    deque.addFirst(deque.pollLast());  
                    answer++;  
                }  
            }  
            deque.pollFirst();  
        }  
        System.out.println(answer);  
    }  
}
```


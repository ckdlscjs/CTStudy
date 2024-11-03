https://school.programmers.co.kr/learn/courses/30/lessons/12906

0-9로 이루어진 배열 연속적으로 나타내는 숫자는 하나만 남기고 제거

O(n)으로 배열 원소의 앞뒤를 비교하고 마지막 원소만 넣어주었음
```java
import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < arr.length; i+=1){
            if(arr[i-1] != arr[i]){
                list.add(arr[i-1]);
            }
        }
        list.add(arr[arr.length-1]);
        

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
```


스택으로도 풀 수 있음 

```java

mport java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
        if(stack.peek() != arr[i]) // stack안 원소랑 배열값 비교
            stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];
        
            
        for(int i = stack.size() - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }
        //for(int i = 0; i < stack.size(); i++){
            //answer[stack.size() - i - 1] = stack.pop();
        //}
        
        return answer;
    } 
}
```

```java

for(int i = stack.size() - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }
for(int i = 0; i < stack.size(); i++){
            answer[stack.size() - i - 1] = stack.pop();
        }
```

두번째 for문 에서는 pop()이 실행될 때마다 stack.size()도 줄어들게 됩니다. 


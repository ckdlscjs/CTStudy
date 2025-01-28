## 입력
1 <= N <= 80,000
1 <= hi(각 건물의 높이) <= 1,000,000,000
## 출력
확인할 수 있는 옥상의 합 출력

## 접근방법
오른쪽에 있는 빌딩의 높이가 현재 있는 빌딩의 높이보다 낮으면 모두 탐색가능하다.
먼저 생각나는 방식은 각 빌딩마다 오른쪽에 있는 빌딩들을 완전탐색하는 것이다. 
이럴 경우 최악의 경우 시간복잡도가 O(80,000) * O(80,000)이 되기 때문에 시간초과가 발생할 것이다.

i번째 빌딩에서 관찰 가능한 다른 빌딩 의 기준을 변경하여
i번째 빌딩이 다른빌딩에서 몇번 관찰 가능한지로 기준을 삼는다. 
그렇다면 스택을 사용하여 
i 번째 인 경우 0.. i-1까지 조사 
비어있는 경우 스택에 삽입
넣으려고 하는 경우 스택 상단에 있는 높이 비교 
	- 현재 높이보다 높은경우 나를 관찰할 수 있는 빌딩이므로 pop 나보다 낮은 빌딩이 나올때 까지 진행
	- 

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(br.readLine());
        }
        long tot = 0;

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && stack.peek() <= buildings[i]){
                stack.pop();
            }
            tot += stack.size();
            stack.push(buildings[i]);
        }
        System.out.println(tot);
    }
}
```
관점을 바꾸는 풀이 말고 다른 풀이를 보고 싶은데 블로그를 찾아보면 거의 다 같은 풀이이다.

https://school.programmers.co.kr/learn/courses/30/lessons/136798


기사번호 약수에 해당하는  공격력을 가진 무기 구매

제한 수치 > 공격력 -> 정해진 공격력(power)

total 철의 무게 return 

약수의 개수 구하기.. 

**첫번째풀이**
```java
class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        // 제한수치 > 공격력
        
        for(int i = 1; i <= number; i++){
            int attack = 0; // 공격력
            // 공격력 == 약수 개수 
            for(int j = 1; j <= i; j++){
                if(i % j == 0){ // 약수이면 
                    attack++;
                }else continue;
            }
            if(attack > limit)
                attack = power;
            sum += attack;
        }
        return sum;
    }
}
```
시간 복잡도 O(n^2)

#### 제한사항 
1 <= number <= 100,000
2<= limit<= 100

시간복잡도가 O(n^2) 보다 낮아야함. 

```java

class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        // 제한수치 > 공격력
        
        for(int i = 1; i <= number; i++){
            int count = 0;
            // 약수의 개수
            for(int j = 1; j*j <= i; j++){
                if(j * j == i) count++;
                else if(i % j == 0) count += 2;
            }
            if(count > limit) count = power;
            sum += count;
        }
        return sum;
    }
}
```

약수의 개수를 구할 때 
똑같이 이중 for문을 사용하는데 j가 제곱근이 될때 까지 loop를 돈다. O(n) * O(n ^1/2) = O(n* n^1/2)


세번째 풀이 (다른 사람의 풀이)
약수의 개수를 먼저 구함  **잘이해가 안간다**

```java

class Solution {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for(int i = 1; i <= number; i++){
            for(int j = 1; j <= number / i; j++){
                count[i * j]++;
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= number; i++){
            if(count[i] > limit) answer += power;
            else answer += count[i];
        }
        return answer;
    }
}
```

# Java_coding_factory : Second Week

---

## Solving Programmers level 1 Problems (2) : 21 - 40
## Problems and Links

| 문제  | URL |
| --- | --- |
| problem 21. | [https://school.programmers.co.kr/learn/courses/30/lessons/136798](https://school.programmers.co.kr/learn/courses/30/lessons/136798) |
| problem 22. | [https://school.programmers.co.kr/learn/courses/30/lessons/135808](https://school.programmers.co.kr/learn/courses/30/lessons/135808) |
| problem 23. | [https://school.programmers.co.kr/learn/courses/30/lessons/134240](https://school.programmers.co.kr/learn/courses/30/lessons/134240) |
| problem 24. | [https://school.programmers.co.kr/learn/courses/30/lessons/133502](https://school.programmers.co.kr/learn/courses/30/lessons/133502) |
| problem 25. | [https://school.programmers.co.kr/learn/courses/30/lessons/133499](https://school.programmers.co.kr/learn/courses/30/lessons/133499) |
| problem 26. | [https://school.programmers.co.kr/learn/courses/30/lessons/132267](https://school.programmers.co.kr/learn/courses/30/lessons/132267) |
| problem 27. | [https://school.programmers.co.kr/learn/courses/30/lessons/131705](https://school.programmers.co.kr/learn/courses/30/lessons/131705) |
| problem 28. | [https://school.programmers.co.kr/learn/courses/30/lessons/131128](https://school.programmers.co.kr/learn/courses/30/lessons/131128) |
| problem 29. | [https://school.programmers.co.kr/learn/courses/30/lessons/118666](https://school.programmers.co.kr/learn/courses/30/lessons/118666) |
| problem 30. | [https://school.programmers.co.kr/learn/courses/30/lessons/92334](https://school.programmers.co.kr/learn/courses/30/lessons/92334) |
| problem 31. | [https://school.programmers.co.kr/learn/courses/30/lessons/87389](https://school.programmers.co.kr/learn/courses/30/lessons/87389) |
| problem 32. | [https://school.programmers.co.kr/learn/courses/30/lessons/86491](https://school.programmers.co.kr/learn/courses/30/lessons/86491) |
| problem 33. | [https://school.programmers.co.kr/learn/courses/30/lessons/86051](https://school.programmers.co.kr/learn/courses/30/lessons/86051) |
| problem 34. | [https://school.programmers.co.kr/learn/courses/30/lessons/82612](https://school.programmers.co.kr/learn/courses/30/lessons/82612) |
| problem 35. | [https://school.programmers.co.kr/learn/courses/30/lessons/81301](https://school.programmers.co.kr/learn/courses/30/lessons/81301) |
| problem 36. | [https://school.programmers.co.kr/learn/courses/30/lessons/77884](https://school.programmers.co.kr/learn/courses/30/lessons/77884) |
| problem 37. | [https://school.programmers.co.kr/learn/courses/30/lessons/77484](https://school.programmers.co.kr/learn/courses/30/lessons/77484) |
| problem 38. | [https://school.programmers.co.kr/learn/courses/30/lessons/76501](https://school.programmers.co.kr/learn/courses/30/lessons/76501) |
| problem 39. | [https://school.programmers.co.kr/learn/courses/30/lessons/72410](https://school.programmers.co.kr/learn/courses/30/lessons/72410) |
| problem 40. | [https://school.programmers.co.kr/learn/courses/30/lessons/70128](https://school.programmers.co.kr/learn/courses/30/lessons/70128) |

## 문제 해설
- 문제 이해 → 풀이 방향 :
- 사용한 자료구조 & 시간복잡도 : O(N)
- (option 참고 문제 & 참고 링크 등등) :
- 까다로웠던 점 & 논의하고 싶은 부분 :
Problem 21: 
- 기사번호 약수에 해당하는 공격력을 가진 무기 구매
  제한수치 > 공격력 -> 정해진 공격력(power)
  약수의 개수 구하기
- 첫번째 풀이 시간복잡도 O(n^2) 
  이중 for문을 통해 약수구하기 -> 시간초과( input<= 100,000)
- 두번째 풀이 시간복잡도 O(n * n^1/2)
  두번째 loop의 j가 제곱근이 될 때까지 반복.
- 세번째 풀이(다른사람 풀이)
  약수의 개수를 먼저 구함 ** 잘 이해 안감 **
  ```
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
  
- 약수 구하는 방법과 시간복잡도에 대한 숙지가 필요해보임.

Problem 22: 
문제 유형 : 구현

사과 점수 : 1 ~ k 점

한 상자에 m개를 담음
사과 상자의 가격 은 p * m (p는 가장 낮은 점수)

가능한 많은 사과를 팔았을 때 얻는 최대 이익.

사과의 최대점수 3 <= k <= 9
한 상자에 들어가는 사과의 수 3 <= m <= 10
사과들의 점수 7 <= score[] <=  1,000,000

1) 일단 주어진 배열 오름차순으로정리

2) 배열 맨 끝부터 m개씩 담는다 => 최대이익

3) 만들어진 배열의 첫번째 원소 * 배열의 길이 = 이익

시간복잡도 O(n)

1) 배열 정렬
2) 배열길이 / m개의 상자를 만든다. 그 배열의 첫번째 원소를 기준으로 이익률 계산
3) sum에 더함
Problem 23: 
내 풀이) 
문자열을 직접 연산한 뒤 두개의 문자열을 합쳤다.
시간 복잡도 O(n)

하지만 원소가 1000개였고 문자열을 직접 연산해서 메모리를 많이 잡아먹는 풀이였을것 같다. 

Stringbuilder를 이용해서 연산하면 메모리 측면에서 훨씬 절약이 될 것같다. 

StringBuilder를 사용하면 연산 측면에서 속도가 훨 씬 빠르고 메서드도 다양함


문자열 연산이 많으면 String Builder로 해야함
Problem 24: 
풀이 - 스택 
arraylist가 더 나을것 같음

1 - 빵 
2 - 야채
3 - 고기

1
3
2
1
일때 햄버거 하나 완성.

키 포인트) 1 - 2 - 3 - 1 을 어디에 보관하지

list 사이즈 가 4 이상일때 list의 마지막 원소부터 4개를 체크해서 햄버거 순서가 맞는지 확인. 
맞으면 그 원소들을 반복문을 통해 지운다. 

시간 복잡도 O(n) *O(n) * O(4)

배열 인덱스를 활용한 풀이 해보기
Problem 25: 
연속되는 단어 x 
주어진 단어의 조합만 발음 가능

contains 만으로는 판단할 수 없다.

ayyea 인경우 ay a

주어진 문자열을 ""로 대체할 경우 남은 문자들이 연결되어 단어가 되는 경우가 발생한다. 
이 경우를 주의해서 예외처리를 해줘야한다.

주어진 단어가 4개뿐이어서 for문으로 처리했다.
시간복잡도 O(n)*O(1)
Problem 26: 
<br />
<br />
<br />
Problem 27: 
<br />
<br />
<br />
Problem 28: 
<br />
<br />
<br />
Problem 29: 
<br />
<br />
<br />
Problem 30: 
<br />
<br />
<br />
Problem 31: 
<br />
<br />
<br />
Problem 32: 
<br />
<br />
<br />
Problem 33: 
<br />
<br />
<br />
Problem 34: 
<br />
<br />
<br />
Problem 35: 
<br />
<br />
<br />
Problem 36: 
<br />
<br />
<br />
Problem 37: 
<br />
<br />
<br />
Problem 38: 
<br />
<br />
<br />
Problem 39: 
<br />
<br />
<br />
Problem 40: 
<br />
<br />
<br />

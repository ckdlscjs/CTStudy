

# Java_coding_factory : Fifth Week

---

## Solving Programmers level 1 Problems with BaekJoon (5) : 81 - 100
## Problems and Links

| 문제 | URL |
| --- | --- |
| problem 81 | [https://school.programmers.co.kr/learn/courses/30/lessons/12906](https://school.programmers.co.kr/learn/courses/30/lessons/12906) |
| problem 82 | [https://school.programmers.co.kr/learn/courses/30/lessons/12903](https://school.programmers.co.kr/learn/courses/30/lessons/12903) |
| problem 83 | [https://school.programmers.co.kr/learn/courses/30/lessons/12901](https://school.programmers.co.kr/learn/courses/30/lessons/12901) |
| problem 84 | [https://school.programmers.co.kr/learn/courses/30/lessons/1845](https://school.programmers.co.kr/learn/courses/30/lessons/1845) |
| problem 85 | [https://www.acmicpc.net/problem/10871](https://www.acmicpc.net/problem/10871) |
| problem 86 | [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309)   | 
| problem 87 | [https://www.acmicpc.net/problem/10093](https://www.acmicpc.net/problem/10093) |
| problem 88 | [https://www.acmicpc.net/problem/1267](https://www.acmicpc.net/problem/1267) |
| problem 89 | [https://www.acmicpc.net/problem/10804](https://www.acmicpc.net/problem/10804) |
| problem 90 | [https://www.acmicpc.net/problem/15552](https://www.acmicpc.net/problem/15552) |
| problem 91 | [https://www.acmicpc.net/problem/2438](https://www.acmicpc.net/problem/2438) |
| problem 92 | [https://www.acmicpc.net/problem/2439](https://www.acmicpc.net/problem/2439) |
| problem 93 | [https://www.acmicpc.net/problem/2440](https://www.acmicpc.net/problem/2440) |
| problem 94 | [https://www.acmicpc.net/problem/2441](https://www.acmicpc.net/problem/2441) |
| problem 95 | [https://www.acmicpc.net/problem/2442](https://www.acmicpc.net/problem/2442) |
| problem 96 | [https://www.acmicpc.net/problem/2443](https://www.acmicpc.net/problem/2443) |
| problem 97 | [https://www.acmicpc.net/problem/2444](https://www.acmicpc.net/problem/2444) |
| problem 98 | [https://www.acmicpc.net/problem/2445](https://www.acmicpc.net/problem/2445) |
| problem 99 | [https://www.acmicpc.net/problem/2446](https://www.acmicpc.net/problem/2446) |
| problem 100 | [https://www.acmicpc.net/problem/2562](https://www.acmicpc.net/problem/2562) |



## 배운 것 정리 
  

무엇을 배웠고 <br/>

어떤 ADT를 가졌는고, <br/>

시간복잡도는 어떻게 되는지 
<br/>


## 문제 해설
 problem 번호: 예제

문제 이해 → 풀이 방향 : 구현, 연산 3개를 구현하는 부분이 까다로울 수도 있을 거 같다.
사용한 자료구조 & 시간복잡도 : O(N)
(option 참고 문제 & 참고 링크 등등) : 유사한? 문제 백준 : https://www.acmicpc.net/problem/1942
까다로웠던 점 & 논의하고 싶은 부분 : 자바 특성상 임의의 자료형을 정의를 하는 순간 길이가 엄청나게 길어진다. 그게 좀 재밌으면서도 어려웠다.
<br/>
<br/>

Problem 81: <br> <br> <br>
스택으로 풀수 있지만 스택으로 풀 때 pop할때 마다 스택 사이즈가 달라지므로 이를 유념하여 원소를 pop해야한다.
시간복잡도 O(N)
Problem 82: <br> <br> <br>
StringBuilder를 사용하여 문자열 객체 생성에 소요되는 시간 감소 시간 복잡도 O(1) (?)
Problem 83: <br> <br> <br>

Problem 84: <br> <br> <br>
Set 을 이용한 풀이 
시간복잡도 O(N)
Problem 85: <br> <br> <br>
StringTokenizer로 파싱해도 되고
Sting의 split()메서드를 사용해서 파싱하여도 된다.
시간복잡도 O(N)
Problem 86: <br> <br> <br>
총 9개의 원소를 돌면되기때문에 이중for문을 돌아도 72가지 밖에 되지 않아 이중for문을 사용하였다.
시간복잡도 O(9) * O(8) 이면 O(1)이라고 해도 관계없나?
Problem 87: <br> <br> <br>
long타입 사용. 

Problem 88: <br> <br> <br>
단순 계산 구현 문제 
Problem 89: <br> <br> <br>
삽입삭제가 많아 list를 이용한 풀이를 하였다. 
배열을 선언한뒤 임시저장소 temp변수를 사용해서 배열을 이용한 풀이도 괜찮을 것 같다. -> 배열 활용 풀이 다시 해보기 
Problem 90: <br> <br> <br>
BufferedWriter write메서드를 사용할 경우 기본 String을 인자로 받기 때문에 정수 출력시 개행문자를 붙여주거나 String.valueOf()메서드를 사용하여야한다. 
Problem 91: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 92: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 93: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 94: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 95: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 96: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 97: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 98: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 99: <br> <br> <br>
별찍기 -> 그냥하면된다.
Problem 100: <br> <br> <br>
별찍기 -> 그냥하면된다.

 

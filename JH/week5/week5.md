# Java_codingTest_5thWeek

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
| problem 86 | [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309) |
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

Brute-Force 

## 문제 해설

problem 번호: 예제

문제 이해 → 풀이 방향 : 구현, 연산 3개를 구현하는 부분이 까다로울 수도 있을 거 같다.
사용한 자료구조 & 시간복잡도 : O(N)
(option 참고 문제 & 참고 링크 등등) : 유사한? 문제 백준 : [https://www.acmicpc.net/problem/1942](https://www.acmicpc.net/problem/1942)
까다로웠던 점 & 논의하고 싶은 부분 : 자바 특성상 임의의 자료형을 정의를 하는 순간 길이가 엄청나게 길어진다. 그게 좀 재밌으면서도 어려웠다.
<br>
<br>

Problem 81:  같은 숫자는 싫어 

문제 이해 및 해설 : 같은 숫자는 싫어는 연속해서 같은 숫자가 나오는 경우 ex) 1 1 1 2 3 3 0 4 4 같이 나온다면, output이 1 2 3 0 4 같이 나와야 한다. 문제는 위 로직에 대한 처리를 하기 위해 stack을 이용해서 stack의 top이 다음 숫자와 똑같으면 push를 안하고 넘어가면서 구현할 수 있었다. 

시간복잡도 : O(N)

<br> <br> <br>

Problem 82: 가운데 글자 가져오기 

문제 이해 및 해설 : 문자열 자료가 주어졌을 때 가운데를 리턴하면 되는데 짝수 길이면 중간에 0-index 기준으로 (n//2)-1, n//2에 해당되는 두 문자열을 출력하면 된다.  

시간복잡도 : O(N/2) = O(N) 

<br> <br> <br>

Problem 83: 

문제 이해 및 해설 : 2016년에 대한 요일을 출력하면 된다. 누적합을 이용해서 현재월까지의 누적 일수를 계산하고 7%로 나눠서  요일 배열에 넣고 리턴한다. 요일 배열은 1월 1일이 FRI 이므로 이를 감안해서 FRI, SAT, SUN, … , THU로 쓴다. FRI를 1월 1일이므로 첫날이기 때문에 0일로 계산했다. (1월 2일은 1일로 계산했습니다.) 이를 위해 전체 일수에서 -1을 했다.  

시간복잡도 : O(1)

<br> <br> <br>

Problem 84: 폰켓몬 

문제 이해 및 해설 : 포켓몬의 종류에 대한 리스트가 주어진다. 주어진 리스트를 counting sort해서 종류가 최대 N/2를 고를 수 있으면 return N/2를 반환하고, 그렇지 않으면 가능한 최대 종류를 반환한다. 

시간복잡도 : O(200000)

<br> <br> <br>

Problem 85: **X보다 작은 수**

문제 이해 및 해설 : 정수 배열과 X값이 주어진다. 주어진 정수 배열 중에서 X값보다 작은 것들을 저장해서 반환한다. 

시간복잡도 : O(N) 

<br> <br> <br>

Problem 86: 일곱난쟁이 

문제 이해 및 해설 : 난쟁이는 9명이 주어진다. 7 난쟁이의 키의 합이 100이 되는 경우를 찾아야 한다. 단순한 브루트포스 구현을 하고 싶지 않아서 백트래킹으로 구현했다. 

시간복잡도 : O$(2^9)$

<br> <br> <br>

Problem 87: 숫자

문제 이해 및 해설 : 두 양의 정수가 주어졌을 때, a와 b사이에 있는 모든 정수의 개수를 반환하고, 전부 나열하라.  주어진 배열의 범위는 다음과 같다 [a+1, b). 배열의 길이는 b - a - 1가 되는데 b - a -1 ≤ 0이 되는 경우는 주어진 두 수 사이의 숫자가 존재하지 않는다. 또한, a>b가 나올 수도 있기 때문에 swap을 해줘야 한다. 이것만 주의하고 구현하면 된다. 

시간복잡도 : $O(N^2)$

<br> <br> <br>

Problem 88: 핸드폰 요금제 

문제 이해 및 해설 : 영식, 민식의 요금제는 각각 30초당 10원, 60초당 15원이다. N개만큼 통화량이 주어졌을 때 각각의 요금제로 계산하면, 누구의 요금제가 더 싼지 출력해야 하는 문제다. 

- 주의할 점은 만약 29초 또는 그보다 적은 요금제를 쓴다면 → 몫이 없더라도 요금이 추가되어야 한다.

시간복잡도 : O(N)

<br> <br> <br>

Problem 89: 카드역배치 

문제 이해 및 해설 : 카드 20장이 1부터 20까지 주어진다. 그 다음 10줄에 걸쳐 i번부터 j번에 위치한 카드를 reverse해야 한다. 

시간복잡도 : O(20*10) 

<br> <br> <br>

Problem 90: 빠른 A + B

문제 이해 및 해설 :  

시간복잡도 : 

<br> <br> <br>

Problem 91: <br> <br> <br>

Problem 92: <br> <br> <br>

Problem 93: <br> <br> <br>

Problem 94: <br> <br> <br>

Problem 95: <br> <br> <br>

Problem 96: <br> <br> <br>

Problem 97: <br> <br> <br>

Problem 98: <br> <br> <br>

Problem 99: <br> <br> <br>

Problem 100: <br> <br> <br>
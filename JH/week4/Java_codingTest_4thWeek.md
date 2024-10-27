# Java_codingTest_4thWeek

# Java_coding_factory : Fourth Week
---

## Solving Programmers level 1 Problems (4) : 61 - 80

## Problems and Links

| 문제 | URL |
| --- | --- |
| problem 61. | [https://school.programmers.co.kr/learn/courses/30/lessons/12940](https://school.programmers.co.kr/learn/courses/30/lessons/12940) |
| problem 62. | [https://school.programmers.co.kr/learn/courses/30/lessons/12937](https://school.programmers.co.kr/learn/courses/30/lessons/12937) |
| problem 63. | [https://school.programmers.co.kr/learn/courses/30/lessons/12935](https://school.programmers.co.kr/learn/courses/30/lessons/12935) |
| problem 64. | [https://school.programmers.co.kr/learn/courses/30/lessons/12934](https://school.programmers.co.kr/learn/courses/30/lessons/12934) |
| problem 65. | [https://school.programmers.co.kr/learn/courses/30/lessons/12933](https://school.programmers.co.kr/learn/courses/30/lessons/12933) |
| problem 66. | [https://school.programmers.co.kr/learn/courses/30/lessons/12932](https://school.programmers.co.kr/learn/courses/30/lessons/12932) |
| problem 67. | [https://school.programmers.co.kr/learn/courses/30/lessons/12931](https://school.programmers.co.kr/learn/courses/30/lessons/12931) |
| problem 68. | [https://school.programmers.co.kr/learn/courses/30/lessons/12930](https://school.programmers.co.kr/learn/courses/30/lessons/12930) |
| problem 69. | [https://school.programmers.co.kr/learn/courses/30/lessons/12928](https://school.programmers.co.kr/learn/courses/30/lessons/12928) |
| problem 70. | [https://school.programmers.co.kr/learn/courses/30/lessons/12926](https://school.programmers.co.kr/learn/courses/30/lessons/12926) |
| problem 71. | [https://school.programmers.co.kr/learn/courses/30/lessons/12925](https://school.programmers.co.kr/learn/courses/30/lessons/12925) |
| problem 72. | [https://school.programmers.co.kr/learn/courses/30/lessons/12922](https://school.programmers.co.kr/learn/courses/30/lessons/12922) |
| problem 73. | [https://school.programmers.co.kr/learn/courses/30/lessons/12921](https://school.programmers.co.kr/learn/courses/30/lessons/12921) |
| problem 74. | [https://school.programmers.co.kr/learn/courses/30/lessons/12919](https://school.programmers.co.kr/learn/courses/30/lessons/12919) |
| problem 75. | [https://school.programmers.co.kr/learn/courses/30/lessons/12918](https://school.programmers.co.kr/learn/courses/30/lessons/12918) |
| problem 76. | [https://school.programmers.co.kr/learn/courses/30/lessons/12917](https://school.programmers.co.kr/learn/courses/30/lessons/12917) |
| problem 77. | [https://school.programmers.co.kr/learn/courses/30/lessons/12916](https://school.programmers.co.kr/learn/courses/30/lessons/12916) |
| problem 78. | [https://school.programmers.co.kr/learn/courses/30/lessons/12915](https://school.programmers.co.kr/learn/courses/30/lessons/12915) |
| problem 79. | [https://school.programmers.co.kr/learn/courses/30/lessons/12912](https://school.programmers.co.kr/learn/courses/30/lessons/12912) |
| problem 80. | [https://school.programmers.co.kr/learn/courses/30/lessons/12910](https://school.programmers.co.kr/learn/courses/30/lessons/12910) |

## 문제 해설

problem 61 : 

  - 문제 정의 & 해설 : 최소공배수, 최대공약수 구하기 -> 최대공약수를 euclid algorithm을 이용해서 구하고, 최소공배수를 구한 최대공약수를 이용해서 구한다. 

  - 시간복잡도 : $\text{O}(\log_2(N))$ 

Problem 62: 짝수, 홀수 

  - 문제 정의 & 해설 : 짝수, 홀수 판별을 해주고, 짝수면 “Even”, 홀수면 “Odd”를 return한다.

  - 시간복잡도 : $\text{O}(1)$

Problem 63: **제일 작은 수 제거하기**

  - 문제 정의 & 해설 : 인트 배열 arr가 주어지는데 이 arr에서 가장 작은 값을 제외한 나머지 값을 ret 배열에 저장해서 리턴한다. 

  - 시간복잡도 : $\text{O}(N)$

Problem 64 : **정수 제곱근 판별**

  - 문제 정의 & 해설 : 주어진 수가 어떤 수의 제곱이라면, 그 수에서 1을 더한 값의 제곱을 리턴한다. 그렇지 않으면 -1를 리턴한다. 

  - 시간 복잡도 : $\text{O}(\log_2(N))$

Problem 65 : **정수 내림차순으로 배치하기**

  - 문제 정의 & 해설 : 주어진 숫자를 다시 내림차순 정렬해서 리턴한다. 계수 정렬을 이용해서 풀었다. 

  - 시간복잡도 : $\text{O}(N)$

Problem 66 : 자연수 뒤집어 배열로 만들기

  - 문제 정의 & 해설 : 주어진 숫자가 12345가 주어졌을 때 숫자를 뒤집어서 배열 [5,4,3,2,1]를 리턴한다. 

  - 시간 복잡도 : $\text{O}(N)$

Problem 67 : **자릿수 더하기**

  - 문제 정의 & 해설 : 자연수가 주어진다. 그 자연수의 자릿수의 합을 구하라. 

  - 시간복잡도 : $\text{O}(\log_{10}(N))$

Problem 68 : **이상한 문자 만들기**

  - 문제 정의 & 해설 : 문자열이 주어진다. 공백인 경우 현재 기록하는 인덱스를 초기화하고, 공백이 아니면, 인덱스를 누적시키면서 짝수 인덱스는 대문자로, 홀수 인덱스는 소문자로 바꿔서 리턴한다.

  - 시간 복잡도 : $\text{O}(N)$

Problem 69 : 약수의 합

  - 문제 정의 & 해설 : 주어진 자연수의 약수의 합을 전부 더한다. 주어진 자연수를 n이라고 할 때 int sqrtn = (int) Math.ceil(Math.sqrt(n))를 구하고 i=1부터 i=sqrtn까지 for-loop를 돌리는데 n이 i로 나누어 떨어지는 경우 n/i == i이 되는 경우는 i값만 더하고, 그렇지 않은 경우는 둘다 더한다. 그러다가 i값이 n/i값보다 커지면 break를 건다. 

  - 시간 복잡도 : $\text{O}(\sqrt{N})$ 

Problem 70 : 시저 암호 

  - 문제 정의 & 해설 : 문자열과 n값이 주어집니다. n은 1≤, ≤25 사이의 자연수가 주어집니다. 소문자는 밀어도 소문자가 되고, 대문자는 밀어도 대문자가 됩니다. 주어진 문자열에 있는 알파벳을 전부 n만큼 밀었을 때 바뀌는 문자열을 리턴해야 합니다.

  - 시간복잡도 : $\text{O}(N)$

Problem 71 : **문자열을 정수로 바꾸기**

  - 문제 정의 & 해설 : 주어진 숫자 문자열을 숫자로 바꿔야 합니다. 

  - 시간복잡도 : $\text{O}(N)$ 

Problem 72 : 수박수박수박수박수? 

  - 문제 정의 & 해설 : 주어진 자연수 n에 대해서 수박수박수박수박수를 구해서 리턴한다. “수박수박수박수박수”란 현재 문자열 “수”와 “박”을 번갈아 더해서 만드는 문자열이다. 

  - 시간복잡도 : $\text{O}(N)$

Problem 73 : 소수 찾기 

  - 문제 정의 & 해설 : isPrime 구현 후, 1부터 n까지 소수의 개수 찾기, $\text{O}(\sqrt{N})$에 돌아가는 isPrime를 구현하고, for-loop를 돌린다. 

  - 시간복잡도 : $\text{O}(N \sqrt{N})$

Problem 74 : 서울에서 김서방 찾기 

  - 문제 정의 & 해설 : seoul 배열을 탐색해서 0-index 기준으로 “Kim”의 위치가 어디 있는지 저장하고, 출력한다.

  - 시간복잡도 : $\text{O}(N)$

Problem 75 : 문자열 다루기 기본 

  - 문제 정의 & 해설 : 주어진 문자열에 isDigit()을 통과할 수 없는 Character 값이 존재한다면, return false를 하고 그렇지 않다면, return true를 합니다. 

  - 시간 복잡도 : $\text{O}(N)$

Problem 76 : 문자열 내림차순으로 배치하기 

  - 문제 정의 & 해설 : 앞서 자릿수 내림차순으로 정렬하기 문제를 풀듯이 주어진 문자열이 있을 때 char값이 큰 값을 앞으로 문자열을 내림차순 해야 한다. → 계수 정렬을 이용해서 풀었다. 

  - 시간 복잡도 : $O(N)$

Problem 77 : **문자열 내 p와 y의 개수**

  - 문제 정의 & 해설 : 주어진 문자열에서 “y”, “Y” 개수와, “p”, “P”의 개수를 각각 계산한다. 

  - 시간 복잡도 : $\text{O}(N)$

Problem 78 : **문자열 내 마음대로 정렬하기**

  - 문제 정의 & 해설 : 문자열 배열이 주어진다. 그 다음으로 n값이 주어지는데, 이 n 위치에 있는 각 string의 charAt값을 비교하여, 주어진 배열을 오름차순으로 정렬한다. 

  - 시간복잡도 : $\text{O}(N\log_2(N))$

Problem 79 : 두 정수 사이의 합 

  - 문제 정의 & 해설 : 두 정수 a,b가 주어졌을 때  a≤ x ≤ b를 만족하는 자연수 x값을 전부 더하라. → 등차수열의 합 공식을 이용해서 풀었다. 

  - 시간복잡도 : $\text{O}( \text{Math.floor}(\log_{10}(a)) \times \text{Math.floor}(\log_{10}(b)) )$

Problem 80 : 나누어 떨어지는 숫자 배열 

  - 문제 정의 & 해설 : 정수배열이 주어진다. 이 정수 배열에서 주어진 divisor로 나눴을 때 나누어 떨어지는 값만 모으고, 이를 오름차순 정렬해서 반환한다. 그러한 값이 하나도 없다면 [-1]를 반환한다. 

  - 시간복잡도 :  $\text{O}(N \log_2(N))$
  

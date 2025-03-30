# Java_coding_factory : 22th Week

---

## BackJoon : Problems of class 2 in Backjoon  

---

## Problems and Links

| 인덱스 | 문제 번호 | 문제 제목 | 자료구조/알고리즘 | URL |
|--------|----------|----------|------------------|----------------|
| 463 | 4153 | 직각삼각형 | ??? | [4153](https://www.acmicpc.net/problem/4153) |
| 464 | 30802 | 웰컴 키트 | ??? | [30802](https://www.acmicpc.net/problem/30802) |
| 465 | 1978 | 소수 찾기 | ??? | [1978](https://www.acmicpc.net/problem/1978) |
| 466 | 2231 | 분해합 | ??? | [2231](https://www.acmicpc.net/problem/2231) |
| 467 | 2292 | 벌집 | ??? | [2292](https://www.acmicpc.net/problem/2292) |
| 468 | 2798 | 블랙잭 | ??? | [2798](https://www.acmicpc.net/problem/2798) |
| 469 | 15829 | Hashing | ??? | [15829](https://www.acmicpc.net/problem/15829) |
| 470 | 1259 | 팰린드롬수 | ??? | [1259](https://www.acmicpc.net/problem/1259) |
| 471 | 1546 | 평균 | ??? | [1546](https://www.acmicpc.net/problem/1546) |
| 472 | 2609 | 최대공약수와 최소공배수 | ??? | [2609](https://www.acmicpc.net/problem/2609) |
| 473 | 2775 | 부녀회장이 될테야 | ??? | [2775](https://www.acmicpc.net/problem/2775) |
| 474 | 2869 | 달팽이는 올라가고 싶다 | ??? | [2869](https://www.acmicpc.net/problem/2869) |
| 475 | 10989 | 수 정렬하기 3 | ??? | [10989](https://www.acmicpc.net/problem/10989) |
| 476 | 11050 | 이항 계수 1 | ??? | [11050](https://www.acmicpc.net/problem/11050) |
| 477 | 28702 | FizzBuzz | ??? | [28702](https://www.acmicpc.net/problem/28702) |
| 478 | 1181 | 단어 정렬 | ??? | [1181](https://www.acmicpc.net/problem/1181) |
| 479 | 1436 | 영화감독 숌 | ??? | [1436](https://www.acmicpc.net/problem/1436) |
| 480 | 1676 | 팩토리얼 0의 개수 | ??? | [1676](https://www.acmicpc.net/problem/1676) |
| 481 | 2751 | 수 정렬하기 2 | ??? | [2751](https://www.acmicpc.net/problem/2751) |
| 482 | 7568 | 덩치 | ??? | [7568](https://www.acmicpc.net/problem/7568) |
| 483 | 10814 | 나이순 정렬 | ??? | [10814](https://www.acmicpc.net/problem/10814) |
| 484 | 11650 | 좌표 정렬하기 | ??? | [11650](https://www.acmicpc.net/problem/11650) |
| 485 | 11651 | 좌표 정렬하기 2 | ??? | [11651](https://www.acmicpc.net/problem/11651) |

<br>

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: ???
- 시간복잡도 계산 및 개선 방법.

## 문제 해설
- **Problem 463 :** 직각삼각형<br>O(1), 수학<br>정렬후 낮은값들의 제곱의합 == 큰값의 제곱의합을비교<br>
- **Problem 464 :** 웰컴 키트<br>O(1), 수학<br>입력값배열6개를 T로 나누어 몫,나머지를더한다, 펜을 N에 몫, 나머지를 구한다<br>
- **Problem 465 :** 소수 찾기<br>O(N log log N), 정수론<br>에라토스테네스의체를 이용한다<br>
- **Problem 466 :** 분해합<br>O(1'000'000*7), 완탐<br>가장 작은수를 찾으므로 N부터 시작해 0까지 차감하면서 내려간다<br>
- **Problem 467 :** 벌집<br>O(1), 수학<br>부등식을전개한 근의공식으로 해를 계산한다 ![image](https://github.com/user-attachments/assets/f4f00687-06b3-4dc3-bc9c-b323a09c3f7e)
<br>
- **Problem 468 :** 블랙잭<br>O(N^2 * logN), 조합, 이분탐색<br>N^2까지 조합수로 찾고 나머지 하나의수를 이분탐색으로 빠르게찾는다<br>
- **Problem 469 :** hasing<br>O(N^2), 해시, 수학<br>공식대로 자리수를 기반으로 곱과 모듈러연산을 이용해 계산한다<br>
- **Problem 470 :** 팰린드롬수<br>O(N), 구현<br>양쪽 끝단을 비교하면서 회문인지 판별한다<br>
- **Problem 471 :** 평균<br>O(N), 수학<br>평균값을계산한다<br>
- **Problem 472 :** 최대공약수와 최소공배수<br>O(logN), 정수론<br>유클리드호제법을 이용해 lcm, gcd를 구한다<br>
- **Problem 473 :** 부녀회장이 될테야<br>O(N^2), 동적프로그래밍<br>DP를 이용해 바텀업방식으로 배열을구성하고출력<br>
- **Problem 474 :** 달팽이는 올라가고 싶다<br>O(1), 수학<br>몫,나머지연산을 이용해 계산<br>
- **Problem 475 :** 수 정렬하기 3<br>O(10'000*N), 정렬<br>계수정렬을 이용해 출력<br>
- **Problem 476 :** 이항 계수1<br>O(NK), DP,재귀<br>이항계수를 메모이제이션을 이용한 DP로구현<br>
- **Problem 477 :** FizzBuzz<br>O(1), 문자열<br>규칙상 무조건 하나는 수가 들어오므로 이를 이용해 판별<br>
- **Problem 478 :** 단어 정렬<br>O(NlogN), 문자열<br>정렬후 unique이용해 중복판별후 제거해주고 사이즈순으로 재정렬<br>
- **Problem 479 :** 영화감독 숌<br>O(10'000*5), 구현<br>숫자를 나누어 6이연속해서 3개인지체크한다<br>
- **Problem 480 :** 팩토리얼 0의 개수<br>O(NlogN), 구현<br>뒤에0은 2*5, 10의갯수이므로 더 적은 5의갯수만을센다<br>
- **Problem 481 :** 수 정렬하기 2<br>O(NlogN)<br>정렬<br>
- **Problem 482 :** 덩치<br>O(NlogN)<br>정렬<br>
- **Problem 483 :** 나이순 정렬<br>O(NlogN)<br>정렬<br>
- **Problem 484 :** 좌표 정렬하기<br>O(NlogN)<br>정렬<br>
- **Problem 485 :** 좌표 정렬하기2<br>O(NlogN)<br>정렬<br>

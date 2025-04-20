# Java_coding_factory : 26th Week

---

## BackJoon : Problems of class 4 in Backjoon

| 인덱스 | 문제 번호 | 문제 제목                   | 자료구조/알고리즘 | URL |
|--------|------------|-----------------------------|------------------|------------------------------------------------|
| 530    | 9251       | LCS                         |                  | [9251](https://www.acmicpc.net/problem/9251)   |
| 531    | 13549      | 숨바꼭질 3                  |                  | [13549](https://www.acmicpc.net/problem/13549) |
| 532    | 15686      | 치킨 배달                   |                  | [15686](https://www.acmicpc.net/problem/15686) |
| 533    | 1043       | 거짓말                      |                  | [1043](https://www.acmicpc.net/problem/1043)   |
| 534    | 1504       | 특정한 최단 경로            |                  | [1504](https://www.acmicpc.net/problem/1504)   |
| 535    | 1753       | 최단경로                    |                  | [1753](https://www.acmicpc.net/problem/1753)   |
| 536    | 2448       | 별 찍기 - 11                |                  | [2448](https://www.acmicpc.net/problem/2448)   |
| 537    | 9663       | N-Queen                     |                  | [9663](https://www.acmicpc.net/problem/9663)   |
| 538    | 12851      | 숨바꼭질 2                  |                  | [12851](https://www.acmicpc.net/problem/12851) |
| 539    | 14502      | 연구소                      |                  | [14502](https://www.acmicpc.net/problem/14502) |
| 540    | 1238       | 파티                        |                  | [1238](https://www.acmicpc.net/problem/1238)   |
| 541    | 1865       | 웜홀                        |                  | [1865](https://www.acmicpc.net/problem/1865)   |
| 542    | 2206       | 벽 부수고 이동하기          |                  | [2206](https://www.acmicpc.net/problem/2206)   |
| 543    | 11779      | 최소비용 구하기 2           |                  | [11779](https://www.acmicpc.net/problem/11779) |
| 544    | 1918       | 후위 표기식                 |                  | [1918](https://www.acmicpc.net/problem/1918)   |
| 545    | 11660      | 구간 합 구하기 5            |                  | [11660](https://www.acmicpc.net/problem/11660) |

<br>

---

## 개념 설명 블로그 링크 : <br><br>

---

## 문제 해설 예시 :

- 문제 번호 : (문제 이름?)
- 문제 해설 : ...
- 문제별 사용 알고리즘과 자료구조: ???
- 시간복잡도 계산 및 개선 방법.

---

## 문제 해설

- **Problem 530:** [9251 - LCS](https://www.acmicpc.net/problem/9251) | 문자열, DP
<br>O(n^2)<br>최장공통부분수열문제, n^2의 바텀업 dp를 이용하여 dp[문자열1][문자열2]중의 최장길이 로 갱신시켜간다<br>

- **Problem 531:** [13549 - 숨바꼭질 3](https://www.acmicpc.net/problem/13549) | BFS
<br>O(V+E)<br>0_1BFS 혹은 BFS를 이용하되 *2의 경우 서순상 가장위에 위치한다, 이때 그리디적인 판단을 제거하기위해 서순상이 아니게끔하기위해 DIST를 최소값으로 갱신하는식으로 BFS한다<br>

- **Problem 532:** [15686 - 치킨 배달](https://www.acmicpc.net/problem/15686) | 백트래킹
<br>O(2^N)<br>치킨집의 위치를 조합으로 구성하여 이에대한 해밀턴거리를 측정해 합의 최소값을 구한다<br>

- **Problem 533:** [1043 - 거짓말](https://www.acmicpc.net/problem/1043) | UnionFind
<br>O(N)<br>노드간의 연관성을 체크해야되기때문에 UnionFind를 이용해 노드간의 연결조합을 전부 체크하여 이때 liar집합에 속해있는경우 해당파티는 성립되지아니함을 이용한다<br>

- **Problem 534:** [1504 - 특정한 최단 경로](https://www.acmicpc.net/problem/1504) | 다익스트라
<br>O(2 * E * logV)<br>다익스트라를 1-> N-> 로 양방향으로 두번돌려 1 to u, n to v / 1 to v, n to u 의 최소합을 찾고 u to v 의 최소값을 더해 구한다<br>

- **Problem 535:** [1753 - 최단경로](https://www.acmicpc.net/problem/1753) | 다익스트라
<br>O(E * logV)<br>다익스트라 알고리즘을 이용해 최단경로를 출력한다<br>

- **Problem 536:** [2448 - 별 찍기 - 11](https://www.acmicpc.net/problem/2448) | 분할정복
<br>O(N^2, logK)<br>프랙탈 패턴의 y,x 좌표위치를 파악해 이를 재귀적으로 분할정복해 원소를 바꾼다<br>

- **Problem 537:** [9663 - N-Queen](https://www.acmicpc.net/problem/9663) | 백트래킹
<br>O(N^N)<br>여왕말문제, 백트래킹을 이용해 구현한다, 이때 놓을수있는 말의 위치를 최적화해 시간복잡도를 최적화시킨다<br>

- **Problem 538:** [12851 - 숨바꼭질 2](https://www.acmicpc.net/problem/12851) | BFS
<br>O(V + E)<br>BFS를 이용해 최단거리를 찾는다 N to K 혹은 K to N으로 구현<br>

- **Problem 539:** [14502 - 연구소](https://www.acmicpc.net/problem/14502) | 시뮬레이션
<br>O(nC3 * (n^2 + (v+e)))<br>조합으로 세울 벽 위치 세개를 찾고 해당 경우에서 bfs 및 안전영역의 갯수를 센다<br>

- **Problem 540:** [1238 - 파티](https://www.acmicpc.net/problem/1238) | 다익스트라
<br>O(2 * E * logV)<br>양방향 다익스트라를 수행하여 양방향기준의 최단거리를 구해 더하여 최장길이값을구한다<br>

- **Problem 541:** [1865 - 웜홀](https://www.acmicpc.net/problem/1865) | 벨만포드
<br>O(N*E)<br>벨만포드 알고리즘을 이용해 음의가중치를 이용한 음의 사이클의 여부를 체크한다<br>

- **Problem 542:** [2206 - 벽 부수고 이동하기](https://www.acmicpc.net/problem/2206) | BFS
<br>O(V*4)<br>정점의갯수*4개, 벽에대한 체크를 하기위해 dist를 3차원배열dist[부신벽갯수][y][x]로구성한다 <br>

- **Problem 543:** [11779 - 최소비용 구하기 2](https://www.acmicpc.net/problem/11779) | 다익스트라
<br>O(V * logE)<br>다익스트라를 이용해 최단거리를 계산하면서 이전노드를 기억하는 prev배열을 두어 역추적해 경로를 체크한다<br>

- **Problem 544:** [1918 - 후위 표기식](https://www.acmicpc.net/problem/1918) | 스택
<br>O(N^2)<br>스택을 이용해 중위표기식을 후위표기식으로 변환한다, 문자열은 그대로결과문자열에삽입, 나머지경우 -+, */, ()를 우측방향으로 우선순위를 두고 스택의top이 새로운문자보다 높거나같을경우 POP을계속한다, 이후 삽입<br>

- **Problem 545:** [11660 - 구간 합 구하기 5](https://www.acmicpc.net/problem/11660) | dp
<br>O(N^2)<br>바텀업 dp를 이용하여 누적한 구간합을 기반으로 특정 값 까지의 합을 구한다, 이때 dp[ny][nx]는 1,1~ny,nx까지의 누적합 이므로 점화식의 누적합에서 왼쪽구간까지의누적합과 위쪽구간까지의 누적합을 더하고 겹치는값인 i-1, j-1을 빼준다 결과인 특정구간의 누적합의경우 반대로 중복되는 dp[i][j]에서 j-1, i-1에대한 누적값을 빼고 중복을 빼준 dp[i-1][j-1]값을 다시더하여 구간합을출력<br>

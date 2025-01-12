# Java_codingTest_14thWeek

---

**Solving BaekJoon : DFS/BFS, DP and Simulation Problems : 300 - 324**

---

**Problems and Links**

**문제 목록**

| 인덱스 | 문제 번호 | 문제 제목 | 자료구조/알고리즘 | 정답 비율 | URL |
| --- | --- | --- | --- | --- | --- |
| 300 | 14442 | 벽 부수고 이동하기 2 | DFS/BFS | 27.110% | [https://www.acmicpc.net/problem/14442](https://www.acmicpc.net/problem/14442) |
| 301 | 16933 | 벽 부수고 이동하기 3 | DFS/BFS | 23.052% | [https://www.acmicpc.net/problem/16933](https://www.acmicpc.net/problem/16933) |
| 302 | 16920 | 확장 게임 | DFS/BFS | 22.939% | [https://www.acmicpc.net/problem/16920](https://www.acmicpc.net/problem/16920) |
| 303 | 11967 | 불켜기 | DFS/BFS | 27.762% | [https://www.acmicpc.net/problem/11967](https://www.acmicpc.net/problem/11967) |
| 304 | 17071 | 숨바꼭질 5 | DFS/BFS | 24.195% | [https://www.acmicpc.net/problem/17071](https://www.acmicpc.net/problem/17071) |
| 305 | 9328 | 열쇠 | DFS/BFS | 27.432% | [https://www.acmicpc.net/problem/9328](https://www.acmicpc.net/problem/9328) |
| 306 | 3197 | 백조의 호수 | DFS/BFS | 19.417% | [https://www.acmicpc.net/problem/3197](https://www.acmicpc.net/problem/3197) |
| 307 | 20304 | 비밀번호 제작 | DFS/BFS | 34.135% | [https://www.acmicpc.net/problem/20304](https://www.acmicpc.net/problem/20304) |
| 308 | 1915 | 가장 큰 정사각형 | DP | 30.028% | [https://www.acmicpc.net/problem/1915](https://www.acmicpc.net/problem/1915) |
| 309 | 10942 | 팰린드롬? | DP | 30.337% | [https://www.acmicpc.net/problem/10942](https://www.acmicpc.net/problem/10942) |
| 310 | 9655 | 돌 게임 | DP | 66.583% | [https://www.acmicpc.net/problem/9655](https://www.acmicpc.net/problem/9655) |
| 311 | 2011 | 암호코드 | DP | 20.656% | [https://www.acmicpc.net/problem/2011](https://www.acmicpc.net/problem/2011) |
| 312 | 2294 | 동전 2 | DP | 30.139% | [https://www.acmicpc.net/problem/2294](https://www.acmicpc.net/problem/2294) |
| 313 | 2133 | 타일 채우기 | DP | 36.659% | [https://www.acmicpc.net/problem/2133](https://www.acmicpc.net/problem/2133) |
| 314 | 1520 | 내리막 길 | DP | 28.364% | [https://www.acmicpc.net/problem/1520](https://www.acmicpc.net/problem/1520) |
| 315 | 9657 | 돌 게임 3 | DP | 46.407% | [https://www.acmicpc.net/problem/9657](https://www.acmicpc.net/problem/9657) |
| 316 | 11660 | 구간 합 구하기 5 | DP | 43.952% | [https://www.acmicpc.net/problem/11660](https://www.acmicpc.net/problem/11660) |
| 317 | 2482 | 색상환 | DP | 36.169% | [https://www.acmicpc.net/problem/2482](https://www.acmicpc.net/problem/2482) |
| 318 | 14888 | 연산자 끼워넣기 | 시뮬레이션 | 47.014% | [https://www.acmicpc.net/problem/14888](https://www.acmicpc.net/problem/14888) |
| 319 | 14889 | 스타트와 링크 | 시뮬레이션 | 46.305% | [https://www.acmicpc.net/problem/14889](https://www.acmicpc.net/problem/14889) |
| 320 | 14890 | 경사로 | 시뮬레이션 | 57.693% | [https://www.acmicpc.net/problem/14890](https://www.acmicpc.net/problem/14890) |
| 321 | 15684 | 사다리 조작 | 시뮬레이션 | 22.239% | [https://www.acmicpc.net/problem/15684](https://www.acmicpc.net/problem/15684) |
| 322 | 15685 | 드래곤 커브 | 시뮬레이션 | 56.256% | [https://www.acmicpc.net/problem/15685](https://www.acmicpc.net/problem/15685) |
| 323 | 17281 | ⚾ | 시뮬레이션 | 43.900% | [https://www.acmicpc.net/problem/17281](https://www.acmicpc.net/problem/17281) |

---

**개념 설명 블로그 링크 :**

---

**문제 해설 예시 :**

- 문제 번호 : (문제 이름?)
- 문제 해설 : ....
- 문제별 사용 알고리즘과 자료구조: BFS, DFS, DP, 시뮬레이션.
- 시간복잡도 계산 및 개선 방법.

---

**문제 해설**

- **Problem 300:**
    - 문제 해설 : 이전에 풀었던 한번만 벽을 넘는 문제에서 이제 벽을 넘는 횟수만 커지게 하면 되는 문제
    - 시간 복잡도 : O(N M K)

- **Problem 301:**
    - 문제 해설 : 300번과 똑같은 문제에 밤에는 벽을 넘을 수 없다는 조건이 들어가있다. 현재 움직이는 시간에 대해서 홀짝성 유무만 체크하면 되므로 30번 문제와 시간복잡도가 거의 동일하다.
    - 시간복잡도 : O(N M K)

- **Problem 302:**
    - 문제 해설 : 일종의 땅따먹기처럼 땅을 전부 가져갈 수 있으면 끝난다. 주의해야 할 점은 벽에 막혀 어느 누구도 가져갈 수 없는 지점이 존재할 수 있다는 점과 플레이어마다 한턴에 움직일 수 있는 범위가 다르다는 점인데 이값이 $10^9$가 되기 때문에 시간초과가 날 수 있다는 점만 조심하면 된다.
    - 시간복잡도 : O(N M)

- **Problem 303:**

- **Problem 304:**

- **Problem 305:**

- **Problem 306:**

- **Problem 307:**

- **Problem 308: 가장 큰 직사각형**
    
    문제 이해 : DP의 정의를 현재 위치에서 올 수 있는 가장 큰 정사각형의 길이로 정의했다. 현재 위치에서 길이를 늘이기 전에 체크해야 먼저 체크해야 하는 부분은 
    

- **Problem 309:**

- **Problem 310:**

- **Problem 311:**
- **Problem 312:**
- **Problem 313:**
- **Problem 314:**
- **Problem 315:**
- **Problem 316:**
- **Problem 317:**
- **Problem 318:**
- **Problem 319:**
- **Problem 320:**
- **Problem 321:**
- **Problem 322:**
- **Problem 323:**
- **Problem 324:**
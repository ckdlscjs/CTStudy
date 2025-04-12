# Java_coding_factory : 25th Week

---
 
## BackJoon : Problems of class 4 in Backjoon 

| 인덱스 | 문제 번호 | 문제 제목                 | 자료구조/알고리즘 | URL |
|--------|------------|---------------------------|------------------|------------------------------------------------|
| 515    | 1167       | 트리의 지름               |                  | [1167](https://www.acmicpc.net/problem/1167)   |
| 516    | 11444      | 피보나치 수 6             |                  | [11444](https://www.acmicpc.net/problem/11444) |
| 517    | 15650      | N과 M (2)                 |                  | [15650](https://www.acmicpc.net/problem/15650) |
| 518    | 15652      | N과 M (4)                 |                  | [15652](https://www.acmicpc.net/problem/15652) |
| 519    | 15654      | N과 M (5)                 |                  | [15654](https://www.acmicpc.net/problem/15654) |
| 520    | 11053      | 가장 긴 증가하는 부분 수열 |                 | [11053](https://www.acmicpc.net/problem/11053) |
| 521    | 11725      | 트리의 부모 찾기         |                  | [11725](https://www.acmicpc.net/problem/11725) |
| 522    | 15663      | N과 M (9)                 |                  | [15663](https://www.acmicpc.net/problem/15663) |
| 523    | 15666      | N과 M (12)                |                  | [15666](https://www.acmicpc.net/problem/15666) |
| 524    | 16953      | A → B                     |                  | [16953](https://www.acmicpc.net/problem/16953) |
| 525    | 1149       | RGB거리                   |                  | [1149](https://www.acmicpc.net/problem/1149)   |
| 526    | 1629       | 곱셈                      |                  | [1629](https://www.acmicpc.net/problem/1629)   |
| 527    | 1932       | 정수 삼각형               |                  | [1932](https://www.acmicpc.net/problem/1932)   |
| 528    | 1991       | 트리 순회                 |                  | [1991](https://www.acmicpc.net/problem/1991)   |
| 529    | 9465       | 스티커                    |                  | [9465](https://www.acmicpc.net/problem/9465)   |




<br>

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: ???
- 시간복잡도 계산 및 개선 방법.

## 문제 해설
 

- **Problem 515:** [1167 - 트리의 지름](https://www.acmicpc.net/problem/1167) | 트리, bfs
<br>O(2 * (V+E))<br>특정노드에서 시작해 리프노드를찾고 다시리프노드를 찾아 트리의 지름(리프노드<->리프노드)를 찾는다<br>

- **Problem 516:** [11444 - 피보나치 수 6](https://www.acmicpc.net/problem/11444) | 행렬, 분할정복
<br>O(log K * 2^3)<br>행렬곱을 이용해 피보나치수열을 구성하고 분할정복을 이용하여 같은 행렬곱 횟수를 줄인다 {{N+1, N}, {N, N-1}} 로 구성시키므로 N-1로 스타트한다<br>

- **Problem 517:** [15650 - N과 M (2)](https://www.acmicpc.net/problem/15650) | 순열, 조합, 재귀
<br>O(2^N)<br>재귀를 이용하여 조건에맞는 수열을 구현, 기저조건에서 출력한다<br>

- **Problem 518:** [15652 - N과 M (4)](https://www.acmicpc.net/problem/15652) | 순열, 조합, 재귀
<br>O(2^N)<br>재귀를 이용하여 조건에맞는 수열을 구현, 기저조건에서 출력한다<br>

- **Problem 519:** [15654 - N과 M (5)](https://www.acmicpc.net/problem/15654) | 순열, 조합, 재귀
<br>O(2^N)<br>재귀를 이용하여 조건에맞는 수열을 구현, 기저조건에서 출력한다<br>

- **Problem 520:** [11053 - 가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053) | LIS, DP, 이분탐색
<br>O(N^2, NlogN)<br>DP혹은 이분탐색을 이용해 LIS를 구한다, 이전에 기록된 최장값을 이용하여 새로들어온 입력값을 기준으로 이전값들중 현재값보다 작은값들의 최장길이값 + 1로 기록하는것<br>

- **Problem 521:** [11725 - 트리의 부모 찾기](https://www.acmicpc.net/problem/11725) | 트리, DFS
<br>O(V+E)<br>DFS를 이용해 루트(1)부터 시작하여 시작노드를 부모로잡고 다음정점을 탐색하기전 현재노드를 부모로기록하여 DFS한다<br>

- **Problem 522:** [15663 - N과 M (9)](https://www.acmicpc.net/problem/15663) | 순열, 조합, 재귀
<br>O(2^N)<br>재귀를 이용하여 조건에맞는 수열을 구현, 기저조건에서 출력한다, 중복수열을 막기위해 임시변수를 두어 마지막값을 기록해두면 백트래킹하여 콜스택을통해 다시 돌아왔을때 중복된수열(끝값)이면 넘어가지않는다<br>

- **Problem 523:** [15666 - N과 M (12)](https://www.acmicpc.net/problem/15666) | 순열, 조합, 재귀
<br>O(2^N)<br>재귀를 이용하여 조건에맞는 수열을 구현, 기저조건에서 출력한다, 중복수열을 막기위해 임시변수를 두어 마지막값을 기록해두면 백트래킹하여 콜스택을통해 다시 돌아왔을때 중복된수열(끝값)이면 넘어가지않는다<br>

- **Problem 524:** [16953 - A → B](https://www.acmicpc.net/problem/16953) | BFS
<br>(V+E)<br>시작노드A 혹은 역순이면 B를 기준으로 잡고 BFS를 통해 최단거리를 찾는다정방향일경우 *2, *10 + 1 이며 역방향일경우 %2 == 0, %10 == 1( * 10 + 1이므로) 으로 찾는다<br>

- **Problem 525:** [1149 - RGB거리](https://www.acmicpc.net/problem/1149) | DP
<br>(N^2)<br>바텀업DP, 현재 노드기준으로 같은 열의 값을 제외한 이전행의 최소값을 기준으로 누적계를 가장 작게만든다<br>

- **Problem 526:** [1629 - 곱셈](https://www.acmicpc.net/problem/1629) | 분할정복
<br>O(logK)<br>분할정복을 이용해 빠르게 N^M을 계산한다, /2씩(log2)로 나누어 곱셈을 하며 이때 중간결과를 한번만 곱하므로 빠른곱셈이 가능, 모듈러연산을 잊지 않는다<br>

- **Problem 527:** [1932 - 정수 삼각형](https://www.acmicpc.net/problem/1932) | DP
<br>O(N^2)<br>파스칼의삼각형형태를 바텀업DP를 이용해 구현한다 DP[i][j] += max(dp[i-1][j-1], dp[i-1][j])로 구성한다<br>

- **Problem 528:** [1991 - 트리 순회](https://www.acmicpc.net/problem/1991) | 트리, 재귀
<br>O(3 * N)<br>입력받은 그래프의 구성정보를 기반으로 재귀를 이용해 전위순회(DLR), 중위순회(LDR), 후위순회(LRD)를 재귀로 탐색한다<br>

- **Problem 529:** [9465 - 스티커](https://www.acmicpc.net/problem/9465) | DP
<br>O(N^2)<br>바텀업DP를 이용해 특정 DP[0,1행][j열의스티커선택]으로 두고 max(dp[i][j-1]이전열의최댓값, dp[opposite i][j-1]이전열 반대행의 최댓값 + arr[i][j]) 으로 최대값을 누계한다<br>

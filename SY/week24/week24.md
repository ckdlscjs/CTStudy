# Java_coding_factory : 24th Week

---

## BackJoon : Problems of class 4 in Backjoon  

| 인덱스 | 문제 번호 | 문제 제목                   | 자료구조/알고리즘 | URL |
|--------|------------|-----------------------------|------------------|------------------------------------------------|
| 500    | 2096       | 내려가기                   |                  | [2096](https://www.acmicpc.net/problem/2096)   |
| 501    | 12865      | 평범한 배낭                 |                  | [12865](https://www.acmicpc.net/problem/12865) |
| 502    | 17070      | 파이프 옮기기 1            |                  | [17070](https://www.acmicpc.net/problem/17070) |
| 503    | 1967       | 트리의 지름                 |                  | [1967](https://www.acmicpc.net/problem/1967)   |
| 504    | 1987       | 알파벳                     |                  | [1987](https://www.acmicpc.net/problem/1987)   |
| 505    | 5639       | 이진 검색 트리             |                  | [5639](https://www.acmicpc.net/problem/5639)   |
| 506    | 9935       | 문자열 폭발                 |                  | [9935](https://www.acmicpc.net/problem/9935)   |
| 507    | 10830      | 행렬 제곱                   |                  | [10830](https://www.acmicpc.net/problem/10830) |
| 508    | 11054      | 가장 긴 바이토닉 부분 수열 |                  | [11054](https://www.acmicpc.net/problem/11054) |
| 509    | 11404      | 플로이드                   |                  | [11404](https://www.acmicpc.net/problem/11404) |
| 510    | 13172      | Σ                          |                  | [13172](https://www.acmicpc.net/problem/13172) |
| 511    | 14938      | 서강그라운드               |                  | [14938](https://www.acmicpc.net/problem/14938) |
| 512    | 17144      | 미세먼지 안녕!             |                  | [17144](https://www.acmicpc.net/problem/17144) |
| 513    | 30805      | 사전 순 최대 공통 부분 수열 |                 | [30805](https://www.acmicpc.net/problem/30805) |
| 514    | 2638       | 치즈                        |                 | [2638](https://www.acmicpc.net/problem/2638)   |


<br>

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: ???
- 시간복잡도 계산 및 개선 방법.

## 문제 해설
- **Problem 500:** [2096 - 내려가기](https://www.acmicpc.net/problem/2096) | DP
<br>O(N)<br>바텀업으로 2차원 DP배열을 구성한다<br>

- **Problem 501:** [12865 - 평범한 배낭](https://www.acmicpc.net/problem/12865) | DP
<br>O(N^2)<br>냅색문제, 바텀업 혹은 탑다운으로 구성이가능, DP[현재물건][현재무게] -> 담을수있는 최대의값 으로 구성하되 이전값에서 갱신시 현재물건을 담을 수 없다면 이전값을 그대로 가져온다<br>

- **Problem 502:** [17070 - 파이프 옮기기 1](https://www.acmicpc.net/problem/17070) | DP
<br>O(N^2)<br>바텀업으로해결, 3차원DP배열을 구성하고 DP[들어오는방향][Y][X]로 모든 경우의수를 누적해 센다<br>

- **Problem 503:** [1967 - 트리의 지름](https://www.acmicpc.net/problem/1967) | 트리, BFS
<br>O(2* N * E)<br>트리의 지름 은 최장리프노드<->최장리프노드 이므로 특정정점에서 BFS하여 리프노드를 찾고 이를 기준으로 다시 BFS하여 최장 리프노드를 찾는다<br>

- **Problem 504:** [1987 - 알파벳](https://www.acmicpc.net/problem/1987) | DFS, DP
<br>O(4^N)<br>DFS를 통해서 갈수있는 거리의 최대값을 구한다, 백트래킹등을 이용해 최적화가 가능(DP가능)<br>

- **Problem 505:** [5639 - 이진 검색 트리](https://www.acmicpc.net/problem/5639) | 분할정복
<br>(NlogN)<br>전위순회값은 들어온 그대로의값이므로 이를 재귀적으로 분할정복하여 후위순회(LRD)로 재탐색, BST의 특성상 분할정복의 기준을 현재노드(S)보다 커지면 우측서브트리로 삼고 재귀탐색<br>

- **Problem 506:** [9935 - 문자열 폭발](https://www.acmicpc.net/problem/9935) | 스택,문자열
<br>O(N ^ 2)<br>문자열의 끝단을 패턴문자열과 비교해 없애가면서 체크한다<br>

- **Problem 507:** [10830 - 행렬 제곱](https://www.acmicpc.net/problem/10830) | 분할정복
<br>O(N^3logK)<br>분할정복으로 행렬곱을 구현한다, 중복되는 행렬곱은 분할정복의 임시반환값으로 기록해두고 이외의값은 행렬곱 Multiply를 통해 행렬곱한다<br>

- **Problem 508:** [11054 - 가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054) | DP
<br>O(2*N^2)<br>LR DP와 RL DP를 두개두어 LIS를 양측에서 찾고 두 합 - 1 로 최대값을찾는다<br>

- **Problem 509:** [11404 - 플로이드](https://www.acmicpc.net/problem/11404) | 플로이드워셜
<br>O(N^3)<br>플로이드워셜로 최단거리를 갱신한 배열을 출력한다<br>

- **Problem 510:** [13172 - Σ](https://www.acmicpc.net/problem/13172) | ???
<br><br><br>

- **Problem 511:** [14938 - 서강그라운드](https://www.acmicpc.net/problem/14938) | 플로이드워셜
<br>O(N^3)<br>입력값이 작으므로 플로이드워셜로 특정정점에대한 범위를 찾고 이를기반으로 누계의 MAX를 계산한다 <br>

- **Problem 512:** [17144 - 미세먼지 안녕!](https://www.acmicpc.net/problem/17144) | 시뮬레이션
<br>O(N^2)<br>배열전체범위에따른 시뮬레이션을 수행한다, 공기청정기의 바람으로인한 먼지의 전파를 구현<br>

- **Problem 513:** [30805 - 사전 순 최대 공통 부분 수열](https://www.acmicpc.net/problem/30805) | 그리디
<br>O(N^2)<br>큰값을 찾고 이에기반해 사전순 끝값은 우측값이 작거나 같을수밖에 없으므로 이를기반으로 MAX값의 앞값들을 제거해가면서 컨테이너를 갱신한다<br>

- **Problem 514:** [2638 - 치즈](https://www.acmicpc.net/problem/2638) | 시뮬레이션, BFS
<br>O(N^2)<br>좌측상단의 0부터 시작해 누적 접촉면이 2이상인 값들을 delete 컨테이너에 저장시키고 탐색할면이 없어질때 delete에서 삭제하면서 해당공간을 큐에다시집어넣는다, cnts에 누적되는 면을 계속 저장하므로 순서에영향을받지않는다<br>

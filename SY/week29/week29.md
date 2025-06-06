## BackJoon : Week29th Problems of class 5 in Backjoon

| 인덱스 | 문제 번호 | 문제 제목           | 자료구조/알고리즘 | URL |
|--------|-----------|---------------------|--------------------|------------------------------------------------|
| 566    | 9527      | 1의 개수 세기       |                    | [9527](https://www.acmicpc.net/problem/9527)   |
| 567    | 10775     | 공항                |                    | [10775](https://www.acmicpc.net/problem/10775) |
| 568    | 16946     | 벽 부수고 이동하기 4 |                    | [16946](https://www.acmicpc.net/problem/16946) |
| 569    | 17387     | 선분 교차 2         |                    | [17387](https://www.acmicpc.net/problem/17387) |
| 570    | 20303     | 할로윈의 양아치     |                    | [20303](https://www.acmicpc.net/problem/20303) |
| 571    | 1509      | 팰린드롬 분할       |                    | [1509](https://www.acmicpc.net/problem/1509)   |
| 572    | 1562      | 계단 수             |                    | [1562](https://www.acmicpc.net/problem/1562)   |
| 573    | 2263      | 트리의 순회         |                    | [2263](https://www.acmicpc.net/problem/2263)   |
| 574    | 9328      | 열쇠                |                    | [9328](https://www.acmicpc.net/problem/9328)   |
| 575    | 17143     | 낚시왕              |                    | [17143](https://www.acmicpc.net/problem/17143) |

---

## 문제 해설

- **Problem 566:** 1의 개수 세기  dp, 비트마스크
  - 풀이 및 해설 :  10^16승 까지에 대한 대략적 2^n의 개수까지 규칙성을 체크해 1의 갯수를 기록하는 누적합 배열을 채워넣고 이를기반으로 특정비트까지의 앞자리의1의갯수를 체크하고 이전은 누적합의갯수를 더해 1의누적계를센다
  - 시간 복잡도 :  O(최대자릿수(60) * 3)

- **Problem 567:** 공항  UnionFind, 그리디
  - 풀이 및 해설 :  끝자리값부터 가능한게이트에 채우는방식으로 그리디하게 게이트에비행기를 안착시킨다, 이를 위해 UnionFind의 경로압축을 이용하여 빠르게 부모노드형식으로 가능한 앞번호 게이트를체크하는식으로 안착시킨다
  - 시간 복잡도 :  O(3*N + N(Find함수, 아커만함수))

- **Problem 568:** 벽 부수고 이동하기 4  탐색 ,플루드필
  - 풀이 및 해설 :  특정 0칸을 영역단위로 미리세두고 1일때 해당영역을 다더하면서 중복없는 영역범위를 출력한다
  - 시간 복잡도 :  O(N^2)

- **Problem 569:** 선분 교차 2  기하, ccw
  - 풀이 및 해설 :  선분 l1, l2를 기반으로 선분l1의 정점2개에 l2의 시작점 두개를 각각 벡터를 두개만들어 ccw를 체크한다, 그러면 두개의ccw결과가 나오고 이때 서로 곱했을때 -1이면 대칭상태이므로 이를 두개의결과를 다 체크하여 결과를도출한다
  - 시간 복잡도 :  O(1)

- **Problem 570:** 할로윈의 양아치  UnionFind, DP
  - 풀이 및 해설 :  입력값을 집합단위로 만들어 모든 크기를 더하고 이에대한 경우의수 최대합을 냅색방식을 이용해 특정 무게일때 최대값을 체크해 결과를 출력한다 K-1일때의 최대값을 구하면 결과가도출된다
  - 시간 복잡도 :  O(N + M + N(UnionFind) + N + 3000 * 3000) 대략 O(N * K)

- **Problem 571:** 팰린드롬 분할  DP
  - 풀이 및 해설 :  dp(n^2)을 이용해 문자열에대한 팰린드롬 여부를 찾고 1~특정문자위치 까지를 기록하는 추가적인 기록배열 cnt를 이용해 1~N까지의 최소팰린드롬수를 찾는다 i to j가 팰린드롬이면 최소값1이므로 1 to i + i to j의 갯수가 팰린드롬수가된다, 이에대한최소값을 갱신시키며 1 to N까지의 최소갯수를 찾는다
  - 시간 복잡도 :  O(N^2)

- **Problem 572:** 계단 수  DP, 비트마스킹
  - 풀이 및 해설 :  0 ~ 9, 즉 10개의 숫자를 N개의길이에서 전부 체크해야하므로 DP[길이][마지막에사용한숫자][숫자사용여부(1<<10)] 의 누적계로 두어 탑다운DP로 구성해 풀이한다, 재귀함수에 기저조건에 도달했을때(N <= 0) 10개의 비트가 전부 1 이어야 0~9까지의 10개수를 사용했다는 소리이므로 1을리턴하면서 갯수를 누계시킨다
  - 시간 복잡도 :  O(100*10*1024)

- **Problem 573:** 트리의 순회  탐색, 트리, DLR, LDR, LRD, 분할정복
  - 풀이 및 해설 :  전위,중위,후위 순회의 특성을 이용한다, 중위순회는 루트노드의 왼쪽이서브트리, 오른쪽이서브트리 임을 이용하며 후위순회는 루트노드가 항상 특정트리의 루트임을 이용한다
  - 시간 복잡도 :  O(N)

- **Problem 574:** 열쇠  그래프, 탐색, 시뮬레이션
  - 풀이 및 해설 :  시뮬레이션 구현에 따른 탐색을 하며 이를위해 BFS방식을 이용해 탐색을한다, 열쇠의 변화가없으면 탐색이 끝났으므로 반복문을 종료시킨다
  - 시간 복잡도 :  

- **Problem 575:** 낚시왕  시뮬레이션
  - 풀이 및 해설 :  상어들이 이동할때 다시 자신의 위치로 돌아오는 계산을 (길이-1)*2만큼 움직이면 자신위치로 다시 돌아오기때문에 이를 모듈러연산을 이용해 시뮬레이션횟수를 줄인다
  - 시간 복잡도 :

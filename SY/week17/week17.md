17th Week
---

## 1. Solving BaekJoon : Dijstra, MST(Minimum Spanning Tree), Floyd Warshall & Bellman-Ford Problems : 354 - 368
---

## Problems and Links

### 문제 목록
| 인덱스 | 문제 번호 | 문제 제목              | 자료구조/알고리즘           | 정답 비율  | URL                                      |
|--------|----------|-----------------------|---------------------------|-----------|------------------------------------------|
| 354    | 1753     | 최단경로              | 다익스트라                | 26.115%   | [문제 링크](https://www.acmicpc.net/problem/1753)   |
| 355    | 11779    | 최소비용 구하기 2      | 다익스트라, 경로 추적     | 37.082%   | [문제 링크](https://www.acmicpc.net/problem/11779)  |
| 356    | 1238     | 파티                  | 다익스트라, 역방향 그래프 | 49.096%   | [문제 링크](https://www.acmicpc.net/problem/1238)   |
| 357    | 1504     | 특정한 최단 경로       | 다익스트라                | 25.407%   | [문제 링크](https://www.acmicpc.net/problem/1504)   |
| 358    | 1916     | 최소비용 구하기        | 다익스트라                | 32.751%   | [문제 링크](https://www.acmicpc.net/problem/1916)   |
| 359    | 1261     | 알고스팟              | 다익스트라, 0-1 BFS       | 43.287%   | [문제 링크](https://www.acmicpc.net/problem/1261)   |
| 360    | 17835    | 면접보는 승범이네      | 다익스트라, 다중 출발     | 24.984%   | [문제 링크](https://www.acmicpc.net/problem/17835)  |
| 361    | 1647     | 도시 분할 계획         | MST (크루스칼, 프림)      | 48.767%   | [문제 링크](https://www.acmicpc.net/problem/1647)   |
| 362    | 13418    | 학교 탐방하기          | MST, 간선 가중치         | 37.830%   | [문제 링크](https://www.acmicpc.net/problem/13418)  |
| 363    | 1774     | 우주신과의 교감        | MST, 유클리드 거리       | 31.344%   | [문제 링크](https://www.acmicpc.net/problem/1774)   |
| 364    | 10423    | 전기가 부족해          | MST, 유니온 파인드       | 69.544%   | [문제 링크](https://www.acmicpc.net/problem/10423)  |
| 365    | 2887     | 행성 터널             | MST, 좌표 압축           | 35.825%   | [문제 링크](https://www.acmicpc.net/problem/2887)   |
| 366    | 1956     | 운동                  | 플로이드-워셜            | 36.921%   | [문제 링크](https://www.acmicpc.net/problem/1956)   |
| 367    | 11562    | 백양로 브레이크        | 플로이드-워셜            | 47.765%   | [문제 링크](https://www.acmicpc.net/problem/11562)  |
| 368    | 1507     | 궁금한 민호           | 플로이드-워셜, 간선 제거 | 54.775%   | [문제 링크](https://www.acmicpc.net/problem/1507)   |
| 369    | 1719     | 택배                  | 플로이드-워셜, 경로 출력 | 58.192%   | [문제 링크](https://www.acmicpc.net/problem/1719)   |
| 370    | 13314    | 플로이드에 오타가?    | 플로이드-워셜            | 53.201%   | [문제 링크](https://www.acmicpc.net/problem/13314)  |
| 371    | 23286    | 허들 넘기             | 플로이드-워셜, 경로 제한 | 53.968%   | [문제 링크](https://www.acmicpc.net/problem/23286)  |
| 372    | 11657    | 타임머신             | 벨만-포드               | 26.058%   | [문제 링크](https://www.acmicpc.net/problem/11657)  |
| 373    | 1865     | 웜홀                 | 벨만-포드, 음수 사이클  | 20.982%   | [문제 링크](https://www.acmicpc.net/problem/1865)   |
| 374    | 1219     | 오민식의 고민         | 벨만-포드, 경로 확인    | 18.843%   | [문제 링크](https://www.acmicpc.net/problem/1219)   |
| 375    | 1738     | 골목길               | 벨만-포드, 경로 복원    | 18.285%   | [문제 링크](https://www.acmicpc.net/problem/1738)   |
| 376    | 3860     | 할로윈 묘지          | 벨만-포드, 다국어       | 15.902%   | [문제 링크](https://www.acmicpc.net/problem/3860)   |
<br>

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: BST, Topological Sort, PQ.
- 시간복잡도 계산 및 개선 방법.

## 문제 해설

- **Problem 339:** 최단경로<br>-O(E logV)<br>-다익스트라알고리즘을 이용해 그리디적으로 최단경로를 찾고 비용을 기록 및 출력한다<br>
- **Problem 340:** 최소비용구하기2<br>-O(E logV)<br>-다익스트라를 이용해 최단경로를 찾으면서 비용갱신시마다 이전노드를 부모로 기억해 경로또한 기입, costs를 찾고 그에따라 역순으로 시작노드까지 찾아간다<br>
- **Problem 341:** 파티<br>-O(2*E logV)<br>-단방향그래프일때 역순이어도 최단경로는 유지되는 특성을 이용해 두번 다익스트라를 이용하여 x->v, x->u를 찾아 이를 더한다<br>
- **Problem 342:** 특정한 최단경로<br>-O(3*E logV)<br>-양방향그래프, U<->V는 고정적, 이외는 1->U+N->V 와 1->V+N->U를 비교해 적은값으로 더한뒤 그중 최소를 구해 둘을 더해서 최단경로를 구한다<br>
- **Problem 343:** 최소비용 구하기<br>-O(E logV)<br>-다익스트라알고리즘을 이용해 그리디적으로 최단경로를 찾고 비용을 기록 및 출력한다<br>
- **Problem 344:** 알고스팟<br><br><br>
- **Problem 345:** 면접보는 승범이네<br>-O(E logV)<br>-면접지점들 K를 기준으로 다익스트라를 실행해야하므로 그래프를 역으로기록, 최단경로의특성을 보여주는 다익스트라의 구조를 이용해 한번의다익스트라로 최장거리를 갱신한다<br>
- **Problem 346:** <br><br><br>
- **Problem 347:** <br><br><br>
- **Problem 348:** <br><br><br>
- **Problem 349:** <br><br><br>
- **Problem 350:** <br><br><br>
- **Problem 351:** <br><br><br>
- **Problem 352:** <br><br><br>
- **Problem 353:** <br><br><br>


## 2. Review week6 => prepare to say something new
---

<br>

## 이전 문제 리뷰(예시)

### 문제 1: [11725](https://www.acmicpc.net/problem/11725)  
1. **새로 배운 점**: BFS로 트리의 부모를 찾는 방법.  
2. **보완한 부분**: DFS와 BFS 간 효율성 비교.  
3. **유사 문제 탐색**: [1240](https://www.acmicpc.net/problem/1240) 노드 사이의 거리.  

### 문제 2: [1991](https://www.acmicpc.net/problem/1991)  
1. **새로 배운 점**: 트리 순회 방식 (전위, 중위, 후위).  
2. **보완한 부분**: 순회 구현 중 실수한 재귀 호출 구조 수정.  
3. **유사 문제 탐색**: 트라이와 관련된 순회 문제 탐구.

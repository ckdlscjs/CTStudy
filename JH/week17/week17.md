# Java_CodingTest_17thWeek

---

## 1. Solving BaekJoon : Dijstra, MST(Minimum Spanning Tree), Floyd Warshall & Bellman-Ford Problems : 354 - 376

---

## Problems and Links

### 문제 목록

| 인덱스 | 문제 번호 | 문제 제목 | 자료구조/알고리즘 | 정답 비율 | URL |
| --- | --- | --- | --- | --- | --- |
| 354 | 1753 | 최단경로 | 다익스트라 | 26.115% | [1753](https://www.acmicpc.net/problem/1753) |
| 355 | 11779 | 최소비용 구하기 2 | 다익스트라, 경로 추적 | 37.082% | [11779](https://www.acmicpc.net/problem/11779) |
| 356 | 1238 | 파티 | 다익스트라, 역방향 그래프 | 49.096% | [1238](https://www.acmicpc.net/problem/1238) |
| 357 | 1504 | 특정한 최단 경로 | 다익스트라 | 25.407% | [1504](https://www.acmicpc.net/problem/1504) |
| 358 | 1916 | 최소비용 구하기 | 다익스트라 | 32.751% | [1916](https://www.acmicpc.net/problem/1916) |
| 359 | 1261 | 알고스팟 | 다익스트라, 0-1 BFS | 43.287% | [1261](https://www.acmicpc.net/problem/1261) |
| 360 | 17835 | 면접보는 승범이네 | 다익스트라, 다중 출발 | 24.984% | [17835](https://www.acmicpc.net/problem/17835) |
| 361 | 1647 | 도시 분할 계획 | MST (크루스칼, 프림) | 48.767% | [1647](https://www.acmicpc.net/problem/1647) |
| 362 | 13418 | 학교 탐방하기 | MST, 간선 가중치 | 37.830% | [13418](https://www.acmicpc.net/problem/13418) |
| 363 | 1774 | 우주신과의 교감 | MST, 유클리드 거리 | 31.344% | [1774](https://www.acmicpc.net/problem/1774) |
| 364 | 10423 | 전기가 부족해 | MST, 유니온 파인드 | 69.544% | [10423](https://www.acmicpc.net/problem/10423) |
| 365 | 2887 | 행성 터널 | MST, 좌표 압축 | 35.825% | [2887](https://www.acmicpc.net/problem/2887) |
| 366 | 1956 | 운동 | 플로이드-워셜 | 36.921% | [1956](https://www.acmicpc.net/problem/1956) |
| 367 | 11562 | 백양로 브레이크 | 플로이드-워셜 | 47.765% | [11562](https://www.acmicpc.net/problem/11562) |
| 368 | 1507 | 궁금한 민호 | 플로이드-워셜, 간선 제거 | 54.775% | [1507](https://www.acmicpc.net/problem/1507) |
| 369 | 1719 | 택배 | 플로이드-워셜, 경로 출력 | 58.192% | [1719](https://www.acmicpc.net/problem/1719) |
| 370 | 13314 | 플로이드에 오타가? | 플로이드-워셜 | 53.201% | [13314](https://www.acmicpc.net/problem/13314) |
| 371 | 23286 | 허들 넘기 | 플로이드-워셜, 경로 제한 | 53.968% | [23286](https://www.acmicpc.net/problem/23286) |
| 372 | 11657 | 타임머신 | 벨만-포드 | 26.058% | [11657](https://www.acmicpc.net/problem/11657) |
| 373 | 1865 | 웜홀 | 벨만-포드, 음수 사이클 | 20.982% | [1865](https://www.acmicpc.net/problem/1865) |
| 374 | 1219 | 오민식의 고민 | 벨만-포드, 경로 확인 | 18.843% | [1219](https://www.acmicpc.net/problem/1219) |
| 375 | 1738 | 골목길 | 벨만-포드, 경로 복원 | 18.285% | [1738](https://www.acmicpc.net/problem/1738) |
| 376 | 3860 | 할로윈 묘지 | 벨만-포드 | 15.902% | [3860](https://www.acmicpc.net/problem/3860) |
| <br> |  |  |  |  |  |

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 :

- 문제 번호 : (문제 이름?)
- 문제 해설 : ....
- 문제별 사용 알고리즘과 자료구조: BST, Topological Sort, PQ.
- 시간복잡도 계산 및 개선 방법.

## 문제 해설

- **Problem 354:** 최단경로
    - 문제해설 : 전형적인 다익스트라 문제
    - 시간복잡도 : O($N\log{N}$)

- **Problem 355: 최소비용 구하기 2**
    - 문제해설 : 다익스트라 + 경로추적, 다익스트라 과정 중 최단거리 갱신이 될 때 prev 배열을 기록해줘서 경로를 추적하면 된다.
    - 시간복잡도 : $O(N \log{N} + N)$

- **Problem 356:** 파티
    - 문제해설 : 주어진 단방향 간선에 대한 다익스트라 한번, 역방향 간선에 대한 다익스트라 한번을 해서 X에서 다른 도시로, 다른 도시에서 X로 가는 거리의 최댓값을 구하면 되는 문제다.
    - 시간복잡도 : $O(N\log{N})$

- **Problem 357:** 특정한 최단 경로
    - 문제해설 : 전형적인 다익스트라 문제, 마지막에 주어진 V를 기준으로 dijstra를 실행해서 E에 대한 dist를 출력한다.
    - 시간복잡도 : $O(N\log{N})$

- **Problem 358:** 최소 비용 구하기
    - 문제해설 : 전형적인 다익스트라 문제, 마지막에 주어진 V를 기준으로 dijstra를 실행해서 E에 대한 dist를 출력한다.
    - 시간복잡도 : $O(N\log{N})$

- **Problem 359:** 알고스팟
    - 문제해설 : 나는 이 문제를 다익스트라 개념을 버무린 BFS로 풀었다.
    - 시간복잡도 : $O(4nm)\approx$ $O(E+V)$

- **Problem 360 :** 면접 보는 승범이네
    - 문제해설 : 여러곳에서 출발하는 다익스트라 문제
    - 시간복잡도 : $O(N\log{N})$

- **Problem 361:** 도시 분할 계획
    - 문제해설 : MST를 하면서 그중 가장 가중치를 가진 엣지를 찾고, MST의 가중치에서 뺀다.
        - 근거는 Minimum Spanning Tree 역시 Tree 이기 때문에 모든 edge가 bridge(단절선)이기 때문이다.
    - 시간복잡도 : $O(E\log{E})$

- **Problem 362:** 학교 탐방하기
    - 문제해설 : MST 문제이다. 한번은 오르막길이 먼저 오도록 정렬해서 MST, 다른 한번은 내리막길이 먼저 오게 해서 MST를 해야 한다.
    - 시간복잡도 : $O(E\log{E} + E\log{E})$

- **Problem 363:** 우주신과의 교감
    - 문제해설 : 노드와 노드 사이의 거리를 이용해서 pq를 만든 후에 MST를 진행했다.
    - 시간복잡도 : $O(N^2 + N^2 \log{N^2})$

- **Problem 364:** 전기가 부족해
    - 문제해설 : 발전기를 전부 하나의 그룹으로 만든 후에 Kruskal MST를 진행했다.
    - 시간복잡도 : $O(E\log{E})$

- **Problem 365:** 행성터널
    - 문제해설 : 행성의 좌표를 x축, y축, z축으로 각각 정렬하고, 바로 현재 노드와 바로 앞(혹은 전) 노드와 변형된 맨해튼 거리를 계산해서 pq에 넣어주고, 이를 기반으로 MST를 돌리면 되는 문제.
    - 시간복잡도 : $O(E\log{E} + E\log{E} + E\log{E}  + 3E\log{3E})$

- **Problem 366:** 운동
    - 문제해설 : 플로이드 와샬 + 사이클 성질 (dist[i][i])
    - 시간복잡도 : $O(N^3)$

- **Problem 367:** 백양로 브레이크
    - 문제해설 : 플로이드 와셜에서 가중치가 역방향 간선의 수로 바뀐 경우이다. 입력할 때 각각의 역방향 간선마다 간선의 가중치를 1로 저장해주고 플로이드 와샬을 돌리면 된다.
    - 시간복잡도 : $O(N^3)$

- **Problem 368:** 궁금한 민호
    - 문제해설 : 플로이드 와샬 + 간선 삭제 : 직접 연결해야”만” 하는 간선만을 찾아야 하는 문제
        - 다른 간선을 통해 경유해도 같은 가중치가 나오는 경우는 break하여 패스한다.
    - 시간복잡도 : $O(N^3)$

- **Problem 369:** 택배
    - 문제해설 : 플로이드 와샬 + 간선 연결 : 가장 처음에 등장하는 간선을 연결해야 하기 때문에 갱신할 때마다 i→k의 간선에 저장된 간선을 i→j 간선에 계속 갱신해준다. 그리고 처음 초기화된 값이 변화가 없으면 숫자가 아닌 -를 출력한다.
    - 시간복잡도 : $O(N^3)$

- **Problem 370:** 플로이드에 오타가
    - 문제해설 : 아직 X
    - 시간복잡도 :

- **Problem 371:** 허들 넘기
    - 문제해설 : 플로이드 와샬 & 갱신 : 택배랑 비슷한 문제라고 생각한다. 간선을 갱신할 때마다 최댓값의 최솟값을 계속 갱신해주면 된다.
    - 시간복잡도 : $O(N^3)$

- **Problem 372:** 타임머신
    - 문제해설 : 전형적인 벨만 포드 문제
    - 시간복잡도 : $O(VE)$

- **Problem 373:** 웜홀
    - 문제해설 : 마찬가지로 372번 문제에서 경로 갱신만 추가된 문제
    - 시간복잡도 : $O(VE)$

- **Problem 374:** 오민식의 고민
    - 문제해설 : 벨만 포드를 하면서 양의 사이클 안에 목적지가 있는지, 아니면 사이클에 있든, 없든 도달할 수가 없는지, 아니면 정상적으로 싸이클이 없으면서 도달할 수 있는지
    - 시간복잡도 : $O(VE)$

- **Problem 375:** 골목길
    - 문제해설 : 아직 X
    - 시간복잡도 :

- **Problem 375:** 할로윈 묘지
    - 문제해설 : 아직 X
    - 시간복잡도 :

## 2. Review week9 => prepare to say something new

---



## 이전 문제 리뷰(예시)

### 문제 1: [14956](https://www.acmicpc.net/problem/14956)

1. **새로 배운 점**: 재귀를 이용해서 어떻게 반복된 모양을 쉽게 재현할지.
2. **보완한 부분**: 패턴의 구현 방식 <- 아직도 완벽하게 이해했다고 말할 정도는 아니다. 
3. **유사 문제 탐색**: [2448](https://www.acmicpc.net/problem/2448) 별찍기 11.

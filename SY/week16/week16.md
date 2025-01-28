## 1. Solving BaekJoon : BST, Topological Sort, PQ Problems : 339 - 353
---

## Problems and Links

### 문제 목록

| 인덱스 | 문제 번호 | 문제 제목                  | 자료구조/알고리즘      | 정답 비율  | URL                                     |
|--------|----------|---------------------------|----------------------|-----------|-----------------------------------------|
| 339    | [7662](https://www.acmicpc.net/problem/7662) | 이중 우선순위 큐       | 다국어, 우선순위 큐    | 22.161%   | https://www.acmicpc.net/problem/7662   |
| 340    | [1202](https://www.acmicpc.net/problem/1202) | 보석 도둑             | 다국어, 그리디 알고리즘 | 22.711%   | https://www.acmicpc.net/problem/1202   |
| 341    | [21939](https://www.acmicpc.net/problem/21939) | 문제 추천 시스템 Version 1 | 알고리즘, 힙           | 32.738%   | https://www.acmicpc.net/problem/21939   |
| 342    | [23326](https://www.acmicpc.net/problem/23326) | 홍익 투어리스트        | 알고리즘, 다익스트라    | 29.626%   | https://www.acmicpc.net/problem/23326   |
| 343    | [21944](https://www.acmicpc.net/problem/21944) | 문제 추천 시스템 Version 2 | 알고리즘, 그리디 알고리즘 | 27.732%   | https://www.acmicpc.net/problem/21944   |
| 344    | [2252](https://www.acmicpc.net/problem/2252) | 줄 세우기             | 위상 정렬, 알고리즘    | 57.536%   | https://www.acmicpc.net/problem/2252    |
| 345    | [2623](https://www.acmicpc.net/problem/2623) | 음악프로그램           | 위상 정렬, 알고리즘    | 51.236%   | https://www.acmicpc.net/problem/2623    |
| 346    | [21276](https://www.acmicpc.net/problem/21276) | 계보 복원가 호석      | 위상 정렬, 알고리즘    | 47.922%   | https://www.acmicpc.net/problem/21276   |
| 347    | [1766](https://www.acmicpc.net/problem/1766) | 문제집                 | 위상 정렬, 알고리즘    | 49.419%   | https://www.acmicpc.net/problem/1766    |
| 348    | [2056](https://www.acmicpc.net/problem/2056) | 작업                   | 위상 정렬, 알고리즘    | 44.327%   | https://www.acmicpc.net/problem/2056    |
| 349    | [1005](https://www.acmicpc.net/problem/1005) | ACM Craft              | 위상 정렬, 알고리즘    | 29.693%   | https://www.acmicpc.net/problem/1005    |
| 350    | [1715](https://www.acmicpc.net/problem/1715) | 카드 정렬하기          | 우선순위 큐, 알고리즘  | 35.041%   | https://www.acmicpc.net/problem/1715    |
| 351    | [13975](https://www.acmicpc.net/problem/13975) | 파일 합치기 3         | 우선순위 큐, 그리디 알고리즘 | 48.770%   | https://www.acmicpc.net/problem/13975   |
| 352    | [1655](https://www.acmicpc.net/problem/1655) | 가운데를 말해요        | 우선순위 큐, 알고리즘  | 30.625%   | https://www.acmicpc.net/problem/1655    |
| 353    | [1781](https://www.acmicpc.net/problem/1781) | 컵라면                 | 우선순위 큐, 그리디 알고리즘 | 33.595%   | https://www.acmicpc.net/problem/1781    |

## 개념 설명 블로그 링크 : <br><br>
-https://blog.naver.com/syl610/223741120307(BST)<br>
-https://blog.naver.com/syl610/223741112781(PQ)<br>
-https://blog.naver.com/syl610/223741115502(TPSort)<br>

## 문제 해설 예시 : 


## 문제 해설

- **Problem 339:** 이중 우선순위 큐 <br>
-O(NlogN)<br>
-중복원소를 포함해 정렬하는 multiset을 이용 혹은 최소힙,최대힙의 우선순위큐 두개를 이용해 구현한다, 두개의힙 사용시 갯수를 기록하는 배열을 이용해 제거된 원소는 반복문을이용해처리<br>
- **Problem 340:** 보석 도둑 <br>-O(NlogN)<br>-우선순위큐문제, 오름차순으로정렬시킨 가방의 무게를 기준으로 해당가방이 감당가능한 모든무게를 다집어넣고 그중 가장 큰녀석만 해당가방에 넣는식으로 PQ를이용, 해당무게에서 넣을수 있는 가장 큰 녀석을 넣는것<br>
- **Problem 341:** 문제 추천 시스템 Version 1<br>-O(NlogN)<br>-트리, 혹은 두개의 우선순위큐를 이용하여 구현 힙을이용시 별도의 체크를위한추가배열을이용, 트리이용시 문제난이도,번호만를 저장할배열이용<br>
- **Problem 342:** 홍익 투어리스트 <br>-O(NlogN)<br>-트리(SET)을 이용해구현, 현재위치를 기준으로 명소자리만 set에넣고 정렬된값을이용해 위치를찾는다, 명소가뒤에있다면 lowerbound값-위치, 아니라면 끝값-현재위치+가장빠른명소위치(begin)<br>
- **Problem 343:** 문제 추천 시스템 Version 2<br>-O(NlogN)<br>-힙은 내부정렬이 아니므로 recommend3을위해 트리를써야한다. 이외는 version1과동일<br>
- **Problem 344:** 줄 세우기<br>-O(N)<br>-위상정렬을 이용해 순서를 찾는다, 기입순서에따라 탐색정보는 다를 수 있으나 순서는 유지되는 출력결과<br>
- **Problem 345:** 음악프로그램 <br>-O(N)<br>-위상정렬을 이용해 순서를 찾는다, 기입순서에따라 탐색정보는 다를 수 있으나 순서는 유지되는 출력결과<br>
- **Problem 346:** 계보 복원가 호석<br>-O(N)<br>-위상정렬을 이용해 순서를찾는다, 이때 각 구분되는 진입차수0에따라 가문이 나뉘며 이를기록하기위해 별도의 vector및 진입차수가 감소해 0이되어서 추가로 큐에집어넣을때만 자식이 되므로 이를 기록하는 별도의 컨테이너배열을 추가로사용<br>
- **Problem 347:** 문제집<br>-O(N)<br>-위상정렬을 이용해 순서를 찾는다, 기입순서에따라 탐색정보는 다를 수 있으나 순서는 유지되는 출력결과<br>
- **Problem 348:** 작업<br>-O(N)<br>-위상정렬을 이용해 순서를 찾는다, 해당과정에서 특정작업을 하기위한 시간의 끝값을찾기위해 특정구간의 최대진입시간을 찾는 별도의기입배열 dp를 이용해 동시에 작업되는 특정작업시간을 고려해 진입시간을체크<br>
- **Problem 349:** ACM Craft<br>-O(N)<br>-위상정렬을 이용해 순서를 찾는다, 해당과정에서 특정작업을 하기위한 시간의 끝값을찾기위해 특정구간의 최대진입시간을 찾는 별도의기입배열 dp를 이용해 동시에 작업되는 특정작업시간을 고려해 진입시간을체크<br>
- **Problem 350:** 카드 정렬하기 <br>-O(NlogN)<br>-그리디, 우선순위큐를 이용해 작은값끼리 뭉쳐야 누적합이 작아진다<br>
- **Problem 351:** 파일 합치기 3<br>-O(NlogN)<br>-그리디, 우선순위큐를 이용해 작은값끼리 뭉쳐야 누적합이 작아진다, 자료형에주의<br>
- **Problem 352:** 가운데를 말해요 <br>-O(NlogN)<br>-중간값을 찾기위해 우선순위큐를 두개를 이용해 low high(root) low(root) high 구조의 형태로 중간값이 top이되는형태로 최대힙, 최소힙을 이용해 중간의 작은값인 최대힙쪽의값을이용 <br>
- **Problem 353:** 컵라면<br>-O(NlogN)<br>-그리디,우선순위큐, 일자당 한 문제만 풀 수 있는점을 이용해 해당일자에 풀 수있는 모든문제중 가장 큰값만을 더하거나  혹은 pq의원소갯수를 푼 문제의 갯수로 두고 문제의갯수를 넘겼을때 가장작은값을 제하는방식중 선택<br>

## 2. Review week7 => prepare to say something new
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

## 1. Solving BaekJoon : Tree, Trie, and Union-find Problems : 324 - 338

---

## Problems and Links

### 문제 목록

| 인덱스 | 문제 번호 | 문제 제목                  | 자료구조/알고리즘 | 정답 비율  | URL                                     |
|--------|----------|---------------------------|------------------|-----------|-----------------------------------------|
| 324    | [11725](https://www.acmicpc.net/problem/11725) | 트리의 부모 찾기      | Tree, BFS/DFS    | 43.064%   | https://www.acmicpc.net/problem/11725   |
| 325    | [1991](https://www.acmicpc.net/problem/1991)  | 트리 순회             | Tree, 순회       | 67.054%   | https://www.acmicpc.net/problem/1991    |
| 326    | [4803](https://www.acmicpc.net/problem/4803)  | 트리                 | Tree, 사이클 판별 | 33.057%   | https://www.acmicpc.net/problem/4803    |
| 327    | [15681](https://www.acmicpc.net/problem/15681) | 트리와 쿼리          | Tree, 서브트리 합 | 45.377%   | https://www.acmicpc.net/problem/15681   |
| 328    | [1240](https://www.acmicpc.net/problem/1240)  | 노드 사이의 거리      | Tree, BFS/DFS    | 54.611%   | https://www.acmicpc.net/problem/1240    |
| 329    | [14426](https://www.acmicpc.net/problem/14426) | 접두사 찾기          | Trie, 문자열      | 36.114%   | https://www.acmicpc.net/problem/14426   |
| 330    | [5052](https://www.acmicpc.net/problem/5052)  | 전화번호 목록        | Trie, 문자열      | 31.325%   | https://www.acmicpc.net/problem/5052    |
| 331    | [7432](https://www.acmicpc.net/problem/7432)  | 디스크 트리          | Trie, 구현        | 57.636%   | https://www.acmicpc.net/problem/7432    |
| 332    | [14725](https://www.acmicpc.net/problem/14725) | 개미굴              | Trie, 문자열      | 66.931%   | https://www.acmicpc.net/problem/14725   |
| 333    | [16934](https://www.acmicpc.net/problem/16934) | 게임 닉네임          | Trie, 문자열      | 53.880%   | https://www.acmicpc.net/problem/16934   |
| 334    | [1717](https://www.acmicpc.net/problem/1717)  | 집합의 표현          | Union-find        | 28.490%   | https://www.acmicpc.net/problem/1717    |
| 335    | [7511](https://www.acmicpc.net/problem/7511)  | 소셜 네트워킹 어플리케이션 | Union-find   | 40.464%   | https://www.acmicpc.net/problem/7511    |
| 336    | [1976](https://www.acmicpc.net/problem/1976)  | 여행 가자            | Union-find        | 37.377%   | https://www.acmicpc.net/problem/1976    |
| 337    | [20040](https://www.acmicpc.net/problem/20040) | 사이클 게임          | Union-find        | 50.270%   | https://www.acmicpc.net/problem/20040   |
| 338    | [18116](https://www.acmicpc.net/problem/18116) | 로봇 조립            | Union-find        | 28.482%   | https://www.acmicpc.net/problem/18116   |

---

## 개념 설명 블로그 링크 : <br><br>
https://blog.naver.com/syl610/223729038308 트리<br>
https://blog.naver.com/syl610/223729041889 트라이<br>
https://blog.naver.com/syl610/223729047217 UnionFind<br>
---

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: Tree, Trie, Union-find.
- 시간복잡도 계산 및 개선 방법.

---

## 문제 해설

- **Problem 324:** 트리의 부모 찾기 <br>
-O(N)<br>
-DFS로 탐색하면서 2번노드부터 이전호출스택에서 부모의 위치를 기록하면서 탐색<br>

- **Problem 325:** 트리 순회<br>
-O(3N)<br>
-전위,중위,후위순회를 재귀로 구현후 출력<br>

- **Problem 326:** 트리<br>
-O(T * N)<br>
-입력받은 트리를 DFS로 순회하면서 부모위치를 다시 탐색하는부분만 인자를 통해서 continue시키고 이외 추가로 탐색하려할시 싸이클이므로 체크<br>

- **Problem 327:** 트리와 쿼리<br>
-O(N*M)<br>
-정점의갯수와 입력쿼리를 곱해도 최대1'000'000이므로 쿼리마다 DFS로 찾는다<br>

- **Problem 328:** 노드사이의 거리<br>
-O(N)<br>
-DFS를이용하여 탐색중 거리를 더해가며 위치를 체크한다, 트리이므로 싸이클이없기때문에 길이 하나뿐이므로 정확한거리를 체크가능<br>

- **Problem 329:** 접두사 찾기<br>
-O(N * maxlen(500))<br>
-트라이를 구현하고 이를 이용해 문자의 접두사여부를 찾는다, 같은 문자열이어도 접두사로 체크하므로 탐색인덱스가 문자열의길이랑 같거나 크면 끝까지체크한것이므로 접두사이다<br>

- **Problem 330:** 전화번호 목록<br>
-O(t * n * maxlen)<br>
-트라이를 통해 탐색하면서 문자열의탐색이 끝나지 않았는데 중간에 멤버변수 boolean이 true라면 접두사가 있다는 뜻이 되므로 체크한다<br>

- **Problem 331:** 디스크 트리<br>
-O(n * maxlen)<br>
-트라이를 이용하여 탐색한다, 트라이의 문자요소가 문자열이므로 map을이용해 트라이를구현해 디렉토리를 구현, \\에맞게 스플릿한다, level에따라 공백출력<br>

- **Problem 332:** 개미굴<br>
-O(n * maxlen)<br>
-트라이를이용해 탐색, 입력에맞게 스플릿하면서 map을이용, level에따라 --를출력<br>

- **Problem 333:** 게임 닉네임<br>
-O(n * maxlen)<br>
-트라이를이용해 탐색, int형 정수 cnt를 문자열의 탐색끝으로 이용하여 접두사 판별및 갯수를 리턴하여 닉네임을 체크한다, cnt가1이면 처음들어온수로 끝나므로 참조변수로 넘긴 ret의인덱스를 별명으로, 아니면 전체문자열+cnt값<br>

- **Problem 334:** 집합의 표현<br>
-O(N)<br>
-UnionFind를 이용하여 서로 속해있는지 여부를 체크한다<br>

- **Problem 335:** 소셜 네트워킹 어플리케이션<br>
-O(N)<br>
-UnionFind를 이용하여 경로가 존재하는지를 체크한다, parent가 같지 않으면 경로가 없는것 <br>

- **Problem 336:** 여행 가자<br>
-O(N)<br>
-UnionFind를 이용해 체크하고 입력값을 a[0], a[1], a[2]...에따라 두개씩 체크해가며 전부 속해있어야만 여행경로가 가능하므로 find연산을 이용해 같은그룹에속해있는지체크한다<br>

- **Problem 337:** 싸이클 게임<br>
-O(N)<br>
-UnionFind를 이용해 중간에 싸이클이 있다면 체크<br>

- **Problem 338:** 로봇 조립<br>
-O(N)<br>
-UnionFind를 이용해 집합여부를 체크하면서 Union시에 갯수를 기록하는 별도의배열을 같이 union시키면서
갯수를 계산해 이를 질문의 대답에 사용한다.
경로압축을 이용했으므로 Find연산을 이용해 주어진 입력 c의 부모에 해당하는 노드를 끄집어내어 이를 sizes의 인덱스에 맞게 찾아내면 최종부모의 갯수의 나오게 되므로 정답을 추론할 수 있다.<br>

---
<br>
## 2. Review week6 => prepare to say something new

## 이전 문제 리뷰(예시)

### 문제 1: 오큰수 https://www.acmicpc.net/problem/17298
1. **새로 배운 점**: BFS로 트리의 부모를 찾는 방법.  
2. **보완한 부분**: DFS와 BFS 간 효율성 비교.  
3. **유사 문제 탐색**:

### 문제 2: 오아시스 재결합 https://www.acmicpc.net/problem/3015 
1. **새로 배운 점**: 트리 순회 방식 (전위, 중위, 후위).  
2. **보완한 부분**: 순회 구현 중 실수한 재귀 호출 구조 수정.  
3. **유사 문제 탐색**:

### 문제 3: 히스토그램에서 가장 큰 직사각형 https://www.acmicpc.net/problem/6549
1. **새로 배운 점**: 트리 순회 방식 (전위, 중위, 후위).  
2. **보완한 부분**: 순회 구현 중 실수한 재귀 호출 구조 수정.  
3. **유사 문제 탐색**:

### 문제 4: 오아시스 재결합 https://www.acmicpc.net/problem/3015
1. **새로 배운 점**: 트리 순회 방식 (전위, 중위, 후위).  
2. **보완한 부분**: 순회 구현 중 실수한 재귀 호출 구조 수정.  
3. **유사 문제 탐색**:


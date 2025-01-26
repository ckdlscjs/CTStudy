# Java_coding_factory : 15th Week
---


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



## 개념 설명 블로그 링크 : <br><br>



## 문제 해설 예시 :
- 문제 번호 : (문제 이름?)
- 문제 해설 : ....
- 문제별 사용 알고리즘과 자료구조: Tree, Trie, Union-find.
- 시간복잡도 계산 및 개선 방법.


## 문제 해설

- **Problem 324:** 트리 부모 찾기
  - 문제 해설 : parent 배열을 만ㄷ글고 dfs
  - 시간복잡도 : O(E + V) DFS 시간복잡도
- **Problem 325:** 트리순회
  - 문제해설 : 주어진 입력값을 그래프에 맞게 자료화하여 1. preorder(cur, 왼, 오), 2. inorder(왼, cur, 오) 3. postorder(왼, 오, cur)를 한 결과를 출력해야 한다.
  - 시간복잡도 : O(3*V)
  - <br><br><br>
- **Problem 326:** 트리 
  - 문제해설 : 사이클 찾기, DFS를 돌리는 과정에서 1 : 현재 DFS가 돌아가지면 아직 끝나진 않은 상황, 2 : DFS가 종료한 노드로 구분하여 사이클을 탐색
  - 시간복잡도 : O(E +V) 
  - <br><br><br>
- **Problem 327:** <br><br><br>
- **Problem 328:** <br><br><br>
- **Problem 329:** <br><br><br>
- **Problem 330:** <br><br><br>
- **Problem 331:** <br><br><br>
- **Problem 332:** 개미굴
  - 문제해설 : 331 문제와 유사하게 " "를 "--"로 바꾸어서 depth 맞게 출력하면 됨.
  - 시간복잡도 : O(NK)

- **Problem 333:** 게임 닉네임
  - 문제해설 : 새로운 접미사가 나오는지 안 나오는지 구분해서 처리 
  - 시간복잡도 : O(NM), N 문자열의 개수, M : 문자열의 길이
    
- **Problem 334:** <br><br><br>
- **Problem 335:** <br><br><br>
- **Problem 336:** <br><br><br>
- **Problem 337:** <br><br><br>
- **Problem 338:** <br><br><br>



## 2. Review week6 => prepare to say something new
---

<br>

## 이전 문제 리뷰(예시)

### 6주차 리뷰 

- 사용한 자료구조 : Queue, Stack, Deque, LinkedList
- 


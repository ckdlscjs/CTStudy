 # Java_coding_factory : 18th Week
---

## 1. Solving BaekJoon : Bitmasking, Hash, KMP, LCA Problems : 377 - 396
---

## Problems and Links

### 문제 목록
| 인덱스 | 문제 번호 | 문제 제목 | 자료구조/알고리즘 | 정답 비율 | URL |
|--------|----------|----------|----------------|----------|----------------|
| 377 | 2064 | IP 주소 | 비트마스킹 | 32.269% | [2064](https://www.acmicpc.net/problem/2064) |
| 378 | 17114 | 하이퍼 토마토 | 비트마스킹 | 23.641% | [17114](https://www.acmicpc.net/problem/17114) |
| 379 | 15787 | 기차가 어둠을 헤치고 은하수를 | 비트마스킹 | 29.154% | [15787](https://www.acmicpc.net/problem/15787) |
| 380 | 24389 | 2의 보수 | 비트마스킹 | 74.303% | [24389](https://www.acmicpc.net/problem/24389) |
| 381 | 1497 | 기타콘서트 | 비트마스킹 | 34.512% | [1497](https://www.acmicpc.net/problem/1497) |
| 382 | 16165 | 걸그룹 마스터 준석이 | 해시 | 69.647% | [16165](https://www.acmicpc.net/problem/16165) |
| 383 | 11478 | 서로 다른 부분 문자열의 개수 | 해시 | 63.823% | [11478](https://www.acmicpc.net/problem/11478) |
| 384 | 19583 | 싸이버개강총회 | 해시 | 40.985% | [19583](https://www.acmicpc.net/problem/19583) |
| 385 | 20166 | 문자열 지옥에 빠진 호석 | 해시 | 36.878% | [20166](https://www.acmicpc.net/problem/20166) |
| 386 | 1351 | 무한 수열 | 해시 | 37.505% | [1351](https://www.acmicpc.net/problem/1351) |
| 387 | 1786 | 찾기 | KMP | 30.787% | [1786](https://www.acmicpc.net/problem/1786) |
| 388 | 1893 | 시저 암호 | KMP | 36.979% | [1893](https://www.acmicpc.net/problem/1893) |
| 389 | 1305 | 광고 | KMP | 56.177% | [1305](https://www.acmicpc.net/problem/1305) |
| 390 | 4354 | 문자열 제곱 | KMP | 34.551% | [4354](https://www.acmicpc.net/problem/4354) |
| 391 | 11585 | 속타는 저녁 메뉴 | KMP | 38.343% | [11585](https://www.acmicpc.net/problem/11585) |
| 392 | 11437 | LCA | LCA | 40.976% | [11437](https://www.acmicpc.net/problem/11437) |
| 393 | 17435 | 합성함수와 쿼리 | LCA | 	51.929% | [17435](https://www.acmicpc.net/problem/17435) | 
| 394 | 11438 | LCA2 | LCA | 	32.894% | [11438](https://www.acmicpc.net/problem/11438) |
| 395 | 1761 | 정점들의 거리 | LCA | 36.727% | [1761](https://www.acmicpc.net/problem/1761) | 
| 396 | 13511 | 트리와 쿼리 | LCA | 	28.422% | [13511](https://www.acmicpc.net/problem/13511) | 
<br>

## 개념 설명 블로그 링크 : <br><br>

## 문제 해설 예시 : 
- 문제 번호 : (문제 이름?)
- 문제 해설 : .... 
- 문제별 사용 알고리즘과 자료구조: BST, Topological Sort, PQ.
- 시간복잡도 계산 및 개선 방법.

## 문제 해설
- **Problem 377:** IP주소<br>O(2N)<br>비트마스킹을 이용, ip를 쉼표를찾아 8비트씩 체크하여 기록, 좌측시프트로 32자리를 전부채운다, 이를&연산하여 접두사부분까지 찾고 ip들과 다시 비교할때 xor연산을 이용하여 같은 부분을 제한 prefix인 같은부분을 제한 끝자리부분만이 diff에 모이게끔 한뒤 끝자리이므로 우측시프트를 1씩 하여 어디자리까지 다른가 체크하여 네트워크마스크를 찾는다, 이후 접두사와 마스크를 &연산하면 최소주소, 마스크와같이출력<br>
- **Problem 378:** 하이퍼토마토<br>O(22*1'000'000)<br>BFS, 차원수에따른 배열의 동적할당 혹은 1차원배열로 저장후 인덱스를 계산하여 BFS하여 채워넣으며 갯수를세야한다.<br>
- **Problem 379:** 기차가 어둠을 헤치고 은하수를<br>O(M+N)<br>비트마스킹을 이용하여 기차길이인 20개비트에 입력, 시프트연산일때 20개를 벗어나는경우 사라질비트를 제거해주는것에 유의<br>
- **Problem 380:** 2의보수<br>O(N)<br>2의보수로 만들고 32자리 비트를 비교하여 계수<br>
- **Problem 381:** 기타콘서트<br>O(1<<N + N)<br>입력받은 뒷자리에따라 순서대로 비트마스크화하여 컨테이너에넣고 0~ (1<<N)-1까지 경우의수 이므로 이를 기반으로 사용한 기트의 비트를 OR연산해 현재가능한 마스크를 만들면서, 현재경우의수에서 비트수를 센다, 컨테이너를 순회하면서 &연산해 자기자신, 즉 연주가능한지 체크, 마스크를 만들때 세놨던 비트수를 기반으로 최소값을 찾는다.<br>
- **Problem 382:** 걸그룹 마스터 준석이<br>O()<br><br>
- **Problem 383:** <br><br><br>
- **Problem 384:** <br><br><br>
- **Problem 385:** <br><br><br>
- **Problem 386:** <br><br><br>
- **Problem 387:** <br><br><br>
- **Problem 388:** <br><br><br>
- **Problem 389:** <br><br><br>
- **Problem 390:** <br><br><br>
- **Problem 391:** <br><br><br>
- **Problem 392:** <br><br><br>
- **Problem 393:** <br><br><br>
- **Problem 394:** <br><br><br>
- **Problem 395:** <br><br><br>
- **Problem 396:** <br><br><br>

 
<br>

## 개념 설명 블로그 링크 : <br><br>
 

## 2. Review week10 => prepare to say something new
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

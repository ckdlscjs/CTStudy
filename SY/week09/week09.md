## Solving BaekJoon : Backtracking and recursion Problems : 175 - 204
## Problems and Links

| 인덱스 | 문제 번호 | 문제 제목             | 자료구조/알고리즘   | 정답 비율 | URL                                      |
| ------ | -------- | ------------------- | ---------------- | --------- | --------------------------------------- |
| 175    | 15649    | N과 M (1)           | 백트래킹          | 63.201%   | [15649](https://www.acmicpc.net/problem/15649) |
| 176    | 9663     | N-Queen             | 백트래킹          | 46.687%   | [9663](https://www.acmicpc.net/problem/9663) |
| 177    | 1182     | 부분수열의 합        | 백트래킹          | 43.351%   | [1182](https://www.acmicpc.net/problem/1182) |
| 178    | 15650    | N과 M (2)           | 백트래킹          | 73.917%   | [15650](https://www.acmicpc.net/problem/15650) |
| 179    | 15651    | N과 M (3)           | 백트래킹          | 66.883%   | [15651](https://www.acmicpc.net/problem/15651) |
| 180    | 15652    | N과 M (4)           | 백트래킹          | 78.704%   | [15652](https://www.acmicpc.net/problem/15652) |
| 181    | 15654    | N과 M (5)           | 백트래킹          | 72.461%   | [15654](https://www.acmicpc.net/problem/15654) |
| 182    | 15655    | N과 M (6)           | 백트래킹          | 84.275%   | [15655](https://www.acmicpc.net/problem/15655) |
| 183    | 15656    | N과 M (7)           | 백트래킹          | 78.636%   | [15656](https://www.acmicpc.net/problem/15656) |
| 184    | 15657    | N과 M (8)           | 백트래킹          | 81.288%   | [15657](https://www.acmicpc.net/problem/15657) |
| 185    | 15663    | N과 M (9)           | 백트래킹          | 49.224%   | [15663](https://www.acmicpc.net/problem/15663) |
| 186    | 15664    | N과 M (10)          | 백트래킹          | 79.626%   | [15664](https://www.acmicpc.net/problem/15664) |
| 187    | 15665    | N과 M (11)          | 백트래킹          | 76.410%   | [15665](https://www.acmicpc.net/problem/15665) |
| 188    | 15666    | N과 M (12)          | 백트래킹          | 80.180%   | [15666](https://www.acmicpc.net/problem/15666) |
| 189    | 6603     | 로또                | 백트래킹          | 55.728%   | [6603](https://www.acmicpc.net/problem/6603) |
| 190    | 1759     | 암호 만들기          | 백트래킹          | 44.876%   | [1759](https://www.acmicpc.net/problem/1759) |
| 191    | 1941     | 소문난 칠공주        | 백트래킹          | 51.990%   | [1941](https://www.acmicpc.net/problem/1941) |
| 192    | 16987    | 계란으로 계란치기     | 백트래킹          | 50.907%   | [16987](https://www.acmicpc.net/problem/16987) |
| 193    | 18809    | Gaaaaaaaaaarden      | 백트래킹          | 42.322%   | [18809](https://www.acmicpc.net/problem/18809) |
| 194    | 1799     | 비숍                | 백트래킹          | 24.550%   | [1799](https://www.acmicpc.net/problem/1799) |
| 195    | 1629     | 곱셈                | 재귀              | 27.498%   | [1629](https://www.acmicpc.net/problem/1629) |
| 196    | 11729    | 하노이 탑 이동 순서   | 재귀              | 51.137%   | [11729](https://www.acmicpc.net/problem/11729) |
| 197    | 1074     | Z                   | 재귀              | 42.044%   | [1074](https://www.acmicpc.net/problem/1074) |
| 198    | 17478    | 재귀함수가 뭔가요?    | 재귀              | 39.170%   | [17478](https://www.acmicpc.net/problem/17478) |
| 199    | 1780     | 종이의 개수          | 재귀              | 60.015%   | [1780](https://www.acmicpc.net/problem/1780) |
| 200    | 2630     | 색종이 만들기         | 재귀              | 69.818%   | [2630](https://www.acmicpc.net/problem/2630) |
| 201    | 1992     | 쿼드트리             | 재귀              | 62.317%   | [1992](https://www.acmicpc.net/problem/1992) |
| 202    | 2447     | 별 찍기 - 10         | 재귀              | 55.993%   | [2447](https://www.acmicpc.net/problem/2447) |
| 203    | 2448     | 별 찍기 - 11         | 재귀              | 43.031%   | [2448](https://www.acmicpc.net/problem/2448) |
| 204    | 14956    | Philosopher’s Walk   | 재귀              | 43.705%   | [14956](https://www.acmicpc.net/problem/14956) |
## 배운 것 정리 
  

## 문제 해설 
Problem 175: N과M 1 <br>
-O(P(N, M), N!/(N-M)!)<br>
-재귀를 이용해 순열을 구현, 비트마스킹을 이용해서 체크하여 재귀함수호출<br>

Problem 176: N-Queen<br>
-O(N^N)<br>
-같은 행은 y를 기준으로 체크완료, 이후 해당 행에대한 대각선, 열 을 조건체크후 다음행으로 넘어가면서 말을 놓는다<br>

Problem 177: 부분 수열의 합<br>
-O(2^N)<br>
-idx를기준으로 n까지 쓴것, 안쓴것 구분하여 sum을 더해 sum==s를 체크한다<br>

Problem 178: N과M 2<br>
-O(nCr, 2^N)<br>
-조합을 구현, 비트마스킹구현/idx를이용한반복문/2^n식으로 3가지방법으로구현해봄<br>

Problem 179: N과M 3<br>
-O(N^M)<br>
-재귀로 구현<br>

Problem 180: N과M 4<br>
-O(N^M)<br>
-재귀로구현, 중복을 포함하므로 모든경우를완탐<br>

Problem 181: N과M 5<br>
-O(N!/(N-M)!)<br>
-순열, 입력기반<br>

Problem 182: N과M 6<br>
-O(nCr, 2^N)<br>
-조합, <br>

Problem 183: N과M 7<br>
-O(N^M)<br>
-중복포함재귀<br>

Problem 184: N과M 8<br>
-O(N^M)<br>
-중복포함재귀, 이전인덱스보다는 크게 출력되는 식이므로 i값을 idx로시작하여사용<br>

Problem 185: N과M 9<br>
-O(N^M)<br>
-중복을 제거한 수열을 표현, 이를위해 마지막 값을 기억하는 임시변수를 사용해 중복제거<br>

Problem 186: N과M 10<br>
-O(N^M)<br>
-중복을 제거한 수열, 조합<br>

Problem 187: N과M 11<br>
-O(N!/(N-M)!)<br>
-중복을 제거한수열, 순열<br>

Problem 188: N과M 12<br>
-O(N^M)<br>
-중복을 제거한수열, 중복<br>

Problem 189: 로또<br>
-O(T*N^M)<br>
-조합<br>

Problem 190: 암호만들기<br>
-O(L^C)<br>
-조건을 체크하면서 조합만들기, 모음, 자음의갯수를 세서 부합하지않으면백트래킹<br>

Problem 191: 소문난 칠공주<br>
-O(25 * 25 * 4^7)<br>
-조합을 구성하여 이를 기반으로 전부 이어져 있는가를 체크, 조건과 연결이 전부 부합되있으면 갯수증가, 비트마스킹을 통해 시간복잡도를 대폭 줄일 수 있음, bool배열을 이용한 비트마스킹 체크, 모든 방문경우의수를 체크하면서
조건에 부합하는지 백트래킹<br>

Problem 192: <br><br><br>

Problem 193: <br><br><br>

Problem 194: <br><br><br>

Problem 195: <br><br><br>

Problem 196: <br><br><br>

Problem 197: <br><br><br>

Problem 198: <br><br><br>

Problem 199: <br><br><br>

Problem 200: <br><br><br>

Problem 201: <br><br><br>

Problem 202: <br><br><br>

Problem 203: <br><br><br>

Problem 204: <br><br><br>



 

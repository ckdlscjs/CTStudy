## Solving BaekJoon : Bisect, Two_pointer, Simulation and DP Problems : 275 - 299
## Problems and Links


# 문제 목록

| 인덱스 | 문제 번호 | 문제 제목                  | 자료구조/알고리즘 | 정답 비율  | URL                                     |
|--------|----------|---------------------------|------------------|-----------|-----------------------------------------|
| 275    | 1300     | K번째 수                 | 이분탐색         | 37.948%   | https://www.acmicpc.net/problem/1300    |
| 276    | 17951    | 흩날리는 시험지 속에서 내 평점이 느껴진거야 | 이분탐색         | 50.992%   | https://www.acmicpc.net/problem/17951   |
| 277    | 1114     | 통나무 자르기            | 이분탐색         | 23.752%   | https://www.acmicpc.net/problem/1114    |
| 278    | 1561     | 놀이 공원 다국어          | 이분탐색         | 26.706%   | https://www.acmicpc.net/problem/1561    |
| 279    | 1637     | 날카로운 눈 다국어        | 이분탐색         | 30.326%   | https://www.acmicpc.net/problem/1637    |
| 280    | 2842     | 집배원 한상덕 다국어      | 투포인터         | 24.590%   | https://www.acmicpc.net/problem/2842    |
| 281    | 14572    | 스터디 그룹              | 투포인터         | 36.819%   | https://www.acmicpc.net/problem/14572   |
| 282    | 20181    | 꿈틀꿈틀 호석 애벌레 - 효율성 전체 채점 | 투포인터         | 39.192%   | https://www.acmicpc.net/problem/20181   |
| 283    | 2923     | 숫자 게임 다국어          | 투포인터         | 32.407%   | https://www.acmicpc.net/problem/2923    |
| 284    | 17947    | 상남자 곽철용            | 투포인터         | 16.152%   | https://www.acmicpc.net/problem/17947   |
| 285    | 20056    | 마법사 상어와 파이어볼    | 시뮬레이션       | 36.974%   | https://www.acmicpc.net/problem/20056   |
| 286    | 20057    | 마법사 상어와 토네이도    | 시뮬레이션       | 71.074%   | https://www.acmicpc.net/problem/20057   |
| 287    | 20058    | 마법사 상어와 파이어스톰  | 시뮬레이션       | 41.283%   | https://www.acmicpc.net/problem/20058   |
| 288    | 21610    | 마법사 상어와 비바라기    | 시뮬레이션       | 49.706%   | https://www.acmicpc.net/problem/21610   |
| 289    | 21611    | 마법사 상어와 블리자드    | 시뮬레이션       | 24.508%   | https://www.acmicpc.net/problem/21611   |
| 290    | 11052    | 카드 구매하기            | DP               | 61.652%   | https://www.acmicpc.net/problem/11052   |
| 291    | 9465     | 스티커                  | DP               | 46.954%   | https://www.acmicpc.net/problem/9465    |
| 292    | 11057    | 오르막 수                | DP               | 47.778%   | https://www.acmicpc.net/problem/11057   |
| 293    | 2293     | 동전 1                  | DP               | 47.760%   | https://www.acmicpc.net/problem/2293    |
| 294    | 1904     | 01타일                  | DP               | 31.821%   | https://www.acmicpc.net/problem/1904    |
| 295    | 1788     | 피보나치 수의 확장        | DP               | 33.288%   | https://www.acmicpc.net/problem/1788    |
| 296    | 4883     | 삼각 그래프 다국어        | DP               | 26.272%   | https://www.acmicpc.net/problem/4883    |
| 297    | 9251     | LCS                     | DP               | 41.328%   | https://www.acmicpc.net/problem/9251    |
| 298    | 1699     | 제곱수의 합             | DP               | 40.094%   | https://www.acmicpc.net/problem/1699    |
| 299    | 9084     | 동전                    | DP               | 67.486%   | https://www.acmicpc.net/problem/9084    |


## 배운 것 정리 
  

## 문제 해설 

 
Problem 276: K번째 수<br>
-O(NlogN)<br>
-파라매트릭서치를 이용해 경계값을 찾는다, k번째 수는 특정 배열에서 몇번째행,열에 위치하는가를 찾으므로 이를 NN배열에서 몫으로 취해 계산해 경계값을 찾는데 f/t의 lowerbound를 찾는다<br>

Problem 277: 흩날리는 시험지 속에서 내 평점이 느껴진거야<br>
-O(NlogN)<br>
-파라매트릭서치, 경계점수 이상만을 체크한다, t/f최대 t 를 찾는다<br>

Problem 278: 통나무 자르기<br>
-O(NlogN)<br>
-0부터 정해진 범위까지만 자를 수 있으므로 중복값을 먼저 제거한다, 이후 이분탐색을 통해 자를 경계값을 찾고 뒤에서부터 잘라내어 횟수가 남는가에대한 여부와 최대조각길이 체크를 한다<br>

Problem 279: 날카로운 눈<br>
-O(NlogN)<br>
-파라매트릭서치, 입력값을 기반으로 공차를 기준으로 갯수를 센다, 이때 찾아야되는 경계값까지의 숫자갯수를 센다 입력값이 홀수한개, 나머지는 전부 짝수개 이므로 몫(공차)로 나누어 덧셈하였을때 갯수가 홀수면
해당 경계선 까지의 몫의갯수의 합이 홀수개면 경계선값이 홀수값이라는 역산이 되므로 이를 기반으로 lowerbound로 이분탐색처럼 경계값 f/t/f의 t를 fit하게 찾는다, 이후 fit한 hi값 이므로 hi값까지의 숫자갯수-(hi-1)까지의 숫자갯수를 빼면
정확히 hi에대한 숫자 갯수가 나오므로 ub-lb같은 갯수의셈방식을 이용<br>

Problem 280: <br><br><br>
-O()<br>
-<br>

Problem 281: <br><br><br>
-O()<br>
-<br>

Problem 282: <br><br><br>
-O()<br>
-<br>

Problem 283: <br><br><br>
-O()<br>
-<br>

Problem 284: <br><br><br>
-O()<br>
-<br>

Problem 285: <br><br><br>
-O()<br>
-<br>

Problem 286: <br><br><br>
-O()<br>
-<br>

Problem 287: <br><br><br>
-O()<br>
-<br>

Problem 288: <br><br><br>
-O()<br>
-<br>

Problem 289: <br><br><br>
-O()<br>
-<br>

Problem 290: <br><br><br>
-O()<br>
-<br>

Problem 291: <br><br><br>
-O()<br>
-<br>

Problem 292: <br><br><br>
-O()<br>
-<br>

Problem 293: <br><br><br>
-O()<br>
-<br>

Problem 294: <br><br><br>
-O()<br>
-<br>

Problem 295: <br><br><br>
-O()<br>
-<br>

Problem 296: <br><br><br>
-O()<br>
-<br>

Problem 297: <br><br><br>
-O()<br>
-<br>

Problem 298: <br><br><br>
-O()<br>
-<br>

Problem 299: <br><br><br>
-O()<br>
-<br>

Problem 300: <br><br><br>
-O()<br>
-<br>






 

## Solving Programmers level 1 Problems (3) : 41 - 60
## Problems and Links

| 문제  | URL |
| --- | --- |
| problem 41. | [https://school.programmers.co.kr/learn/courses/30/lessons/68935](https://school.programmers.co.kr/learn/courses/30/lessons/68935) |
| problem 42. | [https://school.programmers.co.kr/learn/courses/30/lessons/68644](https://school.programmers.co.kr/learn/courses/30/lessons/68644) |
| problem 43. | [https://school.programmers.co.kr/learn/courses/30/lessons/67256](https://school.programmers.co.kr/learn/courses/30/lessons/67256) |
| problem 44. | [https://school.programmers.co.kr/learn/courses/30/lessons/64061](https://school.programmers.co.kr/learn/courses/30/lessons/64061) |
| problem 45. | [https://school.programmers.co.kr/learn/courses/30/lessons/42889](https://school.programmers.co.kr/learn/courses/30/lessons/42889) |
| problem 46. | [https://school.programmers.co.kr/learn/courses/30/lessons/42862](https://school.programmers.co.kr/learn/courses/30/lessons/42862) |
| problem 47. | [https://school.programmers.co.kr/learn/courses/30/lessons/42840](https://school.programmers.co.kr/learn/courses/30/lessons/42840) |
| problem 48. | [https://school.programmers.co.kr/learn/courses/30/lessons/42748](https://school.programmers.co.kr/learn/courses/30/lessons/42748) |
| problem 49. | [https://school.programmers.co.kr/learn/courses/30/lessons/42576](https://school.programmers.co.kr/learn/courses/30/lessons/42576) |
| problem 50. | [https://school.programmers.co.kr/learn/courses/30/lessons/17682](https://school.programmers.co.kr/learn/courses/30/lessons/17682) |
| problem 51. | [https://school.programmers.co.kr/learn/courses/30/lessons/17681](https://school.programmers.co.kr/learn/courses/30/lessons/17681) |
| problem 52. | [https://school.programmers.co.kr/learn/courses/30/lessons/12982](https://school.programmers.co.kr/learn/courses/30/lessons/12982) |
| problem 53. | [https://school.programmers.co.kr/learn/courses/30/lessons/12977](https://school.programmers.co.kr/learn/courses/30/lessons/12977) |
| problem 54. | [https://school.programmers.co.kr/learn/courses/30/lessons/12969](https://school.programmers.co.kr/learn/courses/30/lessons/12969) |
| problem 55. | [https://school.programmers.co.kr/learn/courses/30/lessons/12954](https://school.programmers.co.kr/learn/courses/30/lessons/12954) |
| problem 56. | [https://school.programmers.co.kr/learn/courses/30/lessons/12950](https://school.programmers.co.kr/learn/courses/30/lessons/12950) |
| problem 57. | [https://school.programmers.co.kr/learn/courses/30/lessons/12948](https://school.programmers.co.kr/learn/courses/30/lessons/12948) |
| problem 58. | [https://school.programmers.co.kr/learn/courses/30/lessons/12947](https://school.programmers.co.kr/learn/courses/30/lessons/12947) |
| problem 59. | [https://school.programmers.co.kr/learn/courses/30/lessons/12944](https://school.programmers.co.kr/learn/courses/30/lessons/12944) |
| problem 60. | [https://school.programmers.co.kr/learn/courses/30/lessons/12943](https://school.programmers.co.kr/learn/courses/30/lessons/12943) |

## 문제 해설
Problem 41: </br>
- O(2*log(밑3)N) </br>
- 반복을통해 3으로 나누면서 반복되기때문에 로그N(밑3), 이를 끝부터 변환해가며 Decimal로변환

Problem 42: </br>
- O(N^2) </br>
- set이용하여 중복없이출력

Problem 43: </br>
- O(N) </br>
- 키패드의좌표를 미리 지정하고 이에따라 문자열에붙혀줌, 거리계산을 abs를 이용해 양수값으로 계산해 거리를비교

Problem 44: </br>
- O(N + M) </br>
- 배열을 큐 형태로 만들어서 상단부터 뽑고, 이를 스택에저장, 스택상단두개가 같으면 +=2씩 해주어계산

Problem 45: </br>
- O(N*logN(N + N*logN + N) </br>
- 순회하면서 값 계수, 이후 최대힙을 이용해 실패율이 높은순서대로 우선순위큐의 상단으로 올림, 실패율이 오차가 0.0000........1미만일경우 같다고 처리해 인덱스작은녀석부터올림 부동소수점 연산을위해 numelic limt을 쓰는게 fm이나 ==으로도 컴파일러에서 어느정도지원

Problem 46: </br>
- O(N) </br>
- reserve, lost 처리후 반복문에서 처리, 양쪽의경우를 둘다 한번에 체크해야 양변체크를 동시에할수 있으므로 따로 반복문처리하면 양쪽에나눠줄수없는 문제에 주의

Problem 47: </br>
- O(N) </br>
- 미리 값을 정해놓고 모듈러연산을통해서 갯수를 계수
  
Problem 48: </br>
- O(M * NlogN) </br>
- M번의 Commands만큼실행, 배열 잘라낸후(1), 정렬(NlogN), answer에삽입

Problem 49: </br>
- O(N+M) </br>
- map으로 체크하여 리턴
- 
Problem 50: </br>
- O(N) </br>
- 문자->숫자로 바뀔때 인덱스를 증감시키면서 조건체크, 첫시도에는 체크가 불가하므로 idx를 -1부터시작시킴 이후 제곱(pow), 인덱스를 이용해풀이

Problem 51: </br>
- O(N^2) </br>
- 비트마스킹을 이용해 해당비트가 켜져있는지 체크후 문자열에 기록, 출력

Problem 52: </br>
- O(N) </br>
- 낮은수부터 체크하여 예산이 0보다 작을시 리턴, 반복탈출시 전체사이즈

Problem 53: 
<br />
<br />
<br />
Problem 54: 
<br />
<br />
<br />
Problem 55: 
<br />
<br />
<br />
Problem 56: 
<br />
<br />
<br />
Problem 57: 
<br />
<br />
<br />
Problem 58: 
<br />
<br />
<br />
Problem 59: 
<br />
<br />
<br />
Problem 60: 
<br />
<br />
<br />

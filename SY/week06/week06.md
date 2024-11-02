## Solving Programmers level 1 Problems with BaekJoon (6) : 101 - 126
## Problems and Links

| 문제 | 문제 제목 | 문제 유형 | 정보 | 맞힌 사람 | 제출 | 정답 비율 | URL |
| --- | --- | --- | --- | --- | --- | --- | --- |
| problem 101 | 알파벳 개수 | 배열 | | 31397 | 58124 | 68.306% | [문제](https://www.acmicpc.net/problem/10808) |
| problem 102 | 숫자의 개수 | 배열 | | 100667 | 202800 | 60.344% | [문제](https://www.acmicpc.net/problem/2577) |
| problem 103 | 방 번호 | 배열 | | 25508 | 74169 | 44.339% | [문제](https://www.acmicpc.net/problem/1475) |
| problem 104 | 두 수의 합 | 배열 | 다국어 | 17530 | 67014 | 34.385% | [문제](https://www.acmicpc.net/problem/3273) |
| problem 105 | 개수 세기 | 배열 | | 78732 | 153356 | 61.906% | [문제](https://www.acmicpc.net/problem/10807) |
| problem 106 | 방 배정 | 배열 | 서브태스크 | 10321 | 21531 | 59.780% | [문제](https://www.acmicpc.net/problem/13300) |
| problem 107 | Strfry | 배열 | 다국어 | 5141 | 15529 | 41.141% | [문제](https://www.acmicpc.net/problem/11328) |
| problem 108 | 애너그램 만들기 | 배열 | | 8457 | 17360 | 59.049% | [문제](https://www.acmicpc.net/problem/1919) |
| problem 109 | 에디터 | 연결 리스트 | 다국어 | 25322 | 133318 | 26.857% | [문제](https://www.acmicpc.net/problem/1406) |
| problem 110 | 키로거 | 연결 리스트 | 다국어 | 13080 | 64550 | 27.823% | [문제](https://www.acmicpc.net/problem/5397) |
| problem 111 | 요세푸스 문제 | 연결 리스트 | | 43356 | 122863 | 49.058% | [문제](https://www.acmicpc.net/problem/1158) |
| problem 112 | 스택 | 스택 | | 74759 | 278220 | 37.929% | [문제](https://www.acmicpc.net/problem/10828) |
| problem 113 | 제로 | 스택 | 다국어 | 58504 | 105851 | 68.313% | [문제](https://www.acmicpc.net/problem/10773) |
| problem 114 | 스택 수열 | 스택 | | 47963 | 174173 | 38.465% | [문제](https://www.acmicpc.net/problem/1874) |
| problem 115 | 탑 | 스택 | | 19626 | 83523 | 33.196% | [문제](https://www.acmicpc.net/problem/2493) |
| problem 116 | 옥상 정원 꾸미기 | 스택 | 다국어 | 6298 | 22297 | 35.494% | [문제](https://www.acmicpc.net/problem/6198) |
| problem 117 | 오큰수 | 스택 | | 24308 | 95072 | 34.732% | [문제](https://www.acmicpc.net/problem/17298) |
| problem 118 | 오아시스 재결합 | 스택 | 다국어 | 5799 | 28256 | 27.352% | [문제](https://www.acmicpc.net/problem/3015) |
| problem 119 | 히스토그램에서 가장 큰 직사각형 | 스택 | 다국어 | 10831 | 59359 | 27.366% | [문제](https://www.acmicpc.net/problem/6549) |
| problem 120 | 큐 | 큐 | | 52253 | 140444 | 49.161% | [문제](https://www.acmicpc.net/problem/10845) |
| problem 121 | 큐 2 | 큐 | | 29468 | 111605 | 32.763% | [문제](https://www.acmicpc.net/problem/18258) |
| problem 122 | 카드2 | 큐 | | 55502 | 137180 | 50.929% | [문제](https://www.acmicpc.net/problem/2164) |
| problem 123 | 덱 | 덱 | | 42756 | 91502 | 56.166% | [문제](https://www.acmicpc.net/problem/10866) |
| problem 124 | 회전하는 큐 | 덱 | | 24081 | 49010 | 61.792% | [문제](https://www.acmicpc.net/problem/1021) |
| problem 125 | AC | 덱 | 다국어 | 26528 | 163998 | 20.383% | [문제](https://www.acmicpc.net/problem/5430) |
| problem 126 | 최솟값 찾기 | 덱 | | 8989 | 43657 | 30.892% | [문제](https://www.acmicpc.net/problem/11003) |

## 배운 것 정리 
  
https://blog.naver.com/syl610/223643204965 배열 <br>
https://blog.naver.com/syl610/223643222912 연결리스트 <br>

## 문제 해설 

Problem 101: 알파벳 개수<br> 
- O(N)<br>

Problem 102: 숫자의 개수<br> 
- O(logN)<br>

Problem 103: 방 번호<br> 
- O(logN)<br>
- 6과 9의 더한 갯수를 /2로 올림하여 갯수를 센다 그외는 세트당1개 이므로 그냥 갯수를 센다<br>

Problem 104: 두 수의 합<br> 
- O(N + NlogN)<br>
- 정렬한뒤 양끝을 투포인터를 이용하여 순서쌍의 갯수를 센다<br>

Problem 105: 개수 세기<br> 
- O(N) <br>

Problem 106: 방 배정<br> 
- O(S*Y)<br>
- 2차원배열을 이용해 방갯수를 센다, 나눗셈후 올림으로 몫만을 취함<br>

Problem 107: Strfry<br> 
- O(2N+26)<br>
- 알파벳의 갯수를 센후 양측이 같은지 비교한다 다르면 Impossible<br>

Problem 108: 애너그램 만들기<br> 
- O(2N+26)<br>
- 알파벳을 계수후 양측의 차가 제거갯수이므로 이를 가산한다<br>

Problem 109: 에디터<br> 
- O(N) <br>
- std::list를 이용하여 연결리스트를 사용한 시뮬레이션으로 문제를 해결<br> 

Problem 110: 키로거<br> 
- O(N) <br>
- std::list를 이용하여 연결리스트를 사용한 시뮬레이션으로 문제를 해결<br>

Problem 111: 요세푸스 문제<br> 
- O(N*K)<br>
- std::list를 활용하여 연결리스트에서 해당하는 값을 삭제하여 결과배열에 집어넣는다 해당과정시 이터레이터가 lists의 end를 지정할때의 예외처리필요성에 주의<br>

Problem 112: <br> <br> <br>

Problem 113: <br> <br> <br>

Problem 114: <br> <br> <br>

Problem 115: <br> <br> <br>

Problem 116: <br> <br> <br>

Problem 117: <br> <br> <br>

Problem 118: <br> <br> <br>

Problem 119: <br> <br> <br>

Problem 120: <br> <br> <br>

Problem 121: <br> <br> <br>

Problem 122: <br> <br> <br>

Problem 123: <br> <br> <br>

Problem 124: <br> <br> <br>

Problem 125: <br> <br> <br>

Problem 126: <br> <br> <br>



 <!--
| 문제 | URL |
| --- | --- |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) | 
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
| problem | [https://www.acmicpc.net/problem/](https://www.acmicpc.net/problem/) |
-->
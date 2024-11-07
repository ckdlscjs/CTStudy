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
https://blog.naver.com/syl610/223650516968 스택 <br>
https://blog.naver.com/syl610/223650520922 큐<br>
https://blog.naver.com/syl610/223650528712 덱<br>

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

Problem 112: 스택<br> 
- O(N) <br>
- 구조체 구현하여 기능구현<br>

Problem 113: 제로<br> 
- O(N) <br>

Problem 114: 스택수열<br> 
- O(2N) <br>
- 숫자를 1부터 시작해 val에 도달할때까지 스택에push, 이후 스택의 top과 val이 일치시 pop시키면서 push일때+, 아닐때-를 ans컨테이너에 추가, top과val이 같지않으면 불가능한조건<br>

Problem 115: 탑<br> 
- O(2N) <br>
- 좌측부터 탑의 높이를 입력받고 저장된 탑의 높이가(왼쪽에서 높은것)이 생겼을때 해당 높이를 출력한다, 새로 입력된 탑보다 스택의TOP이 낮을경우는 pop<br>

Problem 116: 옥상 정원 꾸미기<br> 
- O(2N) <br>
- 좌측부터 옥상의 높이를 입력받으면서 새로입력받은 옥상의 높이가 크면 이전옥상들은 쓸모가 없어지므로 pop시킨다, 스택에 남아있는 옥상이 현재 자신을 바라볼 수 있는 옥상의 갯수이므로 sum에더한다 <br>

Problem 117: 오큰수<br> 
- O(2N) <br>
- 스택의 top의 높이가 현재 인덱스보다 작다면 해당 인덱스는 현재자신을 바라볼 수 밖에 없으므로 위치를 기록시키고 스택에서 제거한다, 좌측에서부터 우측으로 들어가므로 우측의 자신보다 높은 인덱스빠른값들이 기입된다<br>

Problem 118: 오아시스 재결합<br> 
- O(2N)<br>
- 값을 입력받으면서 현재 자기자신을 볼 수 있는 갯수 1을 기준으로 스택의 값과 비교한다, 스택의 top이 현재 자신과 높이가 같을경우만 그다음값들에서도 추가갯수를 확인 가능하므로 현재갯수를 이전갯수에 더해 갱신, 스택에서제거한다
- 스택에 이제 자신보다 작거나 같은값이 없는 체크가 끝나고 스택에 사이즈가 있다면 더큰값이 스택에 남아있더라도 자신보다 큰값 하나만 체크할 수 있으므로 +1해준다 <br>

Problem 119: 히스토그램에서 가장 큰 직사각형(스택)<br> 
- O(3N)<br>
- 스택에 저장되는 값은 오름차순으로 값들만이 기록된다, 다음의인덱스가 Top보다 작을경우 현재 인덱스의 높이보다 큰녀석들만 제거하면서 직사각형 높이를 계산한다, 이때 idx의 위치를 기반으로 너비를 계산하고
- 오름차순으로 스택이 기록되어있기에 해당 인덱스가 높이가 되며 높이*너비로 직사각형의 넓이를 계산한다<br>

Problem 120: 큐<br> 
- O(N) <br>
- 배열로 자료구조 만든후 구현<br>

Problem 121: 큐2<br> 
- O(N) <br>

Problem 122: 카드2<br>
- O(N^2) <br>
- 자료구조 큐or덱으로 구현 <br>

Problem 123: 덱<br> 
- O(N) <br>
- 이중연결리스트를 통한 자료구조 구현<br>

Problem 124: 회전하는 큐<br> 
- O(N^2)<br>
- 이중연결리스트를 통한 자료구조를 기반으로 head부터 해당 위치의 idx를 바뀐덱기준으로 탐색후 현재 size/2를 기반으로 ans계산해 적은쪽으로 계산<br>

Problem 125: AC<br> 
- O(N)<br>
- 덱을 활용하기 위해 앞서 이중연결리스트를 통해구현한 덱을 기반으로 문제풀이, reverse시에 함수만 반대로 써주는식으로 문제를 해결(left, right는 전부 구조바꾸면 시간초과) <br>

Problem 126: 최솟값 찾기<br> 
- O(N)<br>
- 덱의 특성을 활용해 값의 크기를 오름차순으로 덱을 정렬시키면서 위치가 제한거리를 벗어날경우 front에서제거, 삽입시인덱스보다 큰녀석들은 최솟값이 될 가능성이 없으므로 뒤에서부터 전부제거<br>



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

Problem 101:
<br/>
시간 복잡도 O(100) == O(1)
<br/>
<br/>
Problem 102:
ASCII Code 값을 이용한 풀이 
시간복잡도 O(A * B * C) <= O(1000 * 1000 * 1000)  <= O(1,000,000,000)
<br/>
Problem 103:<br/>
시간복잡도 O(방번호) = O(N) (1 <= N < 1,000,000)

6과 9를 어떻게 처리해야하는지에 대한 고찰이 있었다. 
6이 짝수일때 케이스별로 나누어서 하려했지만 일반성에 어긋났다. 단순하게 6과 9를 하나로 생각하면 되는 것이었다. 
즉 한 1~9의 한 세트가 주어지면 이를 1,2,3,4,5,6,6,7,8 이라고 생각하는 것이었다. 그렇게 하면 배열에 기록된 6,9를 모두 더한 뒤 반 나누면 한세트로 생각할 수 있다.
이 경우 짝수는 2로 나누면 되지만 홀수의 경우 절반 나눈 다음에 1을 더해줘야한다. 
<br/>
<br/>
Problem 104:<br/>
투포인터 문제 
? 왜 sum == x 일때 count++ left++ right-- 하면 런타임 에러가 뜨지 
두포인터가 같은 숫자를 가리키고 있는 경우에 두포인터가 동시에 움직인다면 서로 엇갈려서 while loop 이 끝나지 않는다. 
<br/>
<br/>
Problem 105:<br/>
더 고민해봐야될게 무엇이 있을까 어떤 부분을 디벨롭 시킬까 

br.readLine으로 읽은 String값을 int형 배열로 선언하고 싶을때
<br/>
<br/>
Problem 106:<br/>
학년과 성별에 따른 학생 이차원배열을 만들경우 이중for문을 순회해도 괜찮은지
-> 한학년에 1000명이 몰려있는 경우 1 * 1000
-> 총 O(1000) 이므로 걍 돌려도 될듯
나머지를 계산하는 부분에서 잘못 계산하였다. 
나누어 떨어지지 않는 경우 방 개수를 +1을 해주어야하는데 나머지를 더해버렸음 
<br/>
<br/>
Problem 107:<br/>
엣지케이스 1000개의 테스트케이스 각 문자열길이가 1000개이면 O(1000) * O(2000* 1000) = O (2,000,000,000)

처음 든 생각 각 문자열을 배열에 집어넣고 정렬하여서 각각 비교하면 어떨까 => 시간 초과날듯,, => 시간 초과 안나네?
<br/>
<br/>
Problem 108:<br/>
크기가 26인 배열을 두개 생성한 다음 각 알파벳 순서에 맞는 인덱스에 1씩 더하여 개수를 카운트한다.

그다음 배열을 순회하면서 값이 다르면 카운트++ 
각 단어는 1000자를 넘지 않는다. 배열로 만들기 위한 시간복잡도 2* O(1000) + O(26)
<br/>
<br/>
Problem 109:
<br/>
<br/>

Problem 110:
<br/>


Problem 111:
<br/>


Problem 112:
<br/>


Problem 113:
<br/>


Problem 114:

<br/>

Problem 115:


<br/>
Problem 116:


<br/>
Problem 117:

<br/>

Problem 118:

<br/>

Problem 119:

<br/>

Problem 120:

<br/>

Problem 121:

<br/>

Problem 122:

<br/>

Problem 123:

<br/>

Problem 124:
<br/>


Problem 125:
<br/>


Problem 126:

<br/>

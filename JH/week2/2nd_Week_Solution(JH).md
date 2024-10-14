# Second Week Solution

## 문제 해설

<br/> 

Problem 21: 기사단원의 무기 
<br /> 문제 해설 : 공력력 1 = 철 1kg, 약수의 합 = 공격력, 
                 공격력 >= limit 시 power로 대체해서 
                 그때 attack_ acc_sum = ?
<br /> 자료구조 && 알고리즘 : 
<br /> 시간복잡도 : O(sqrt(n) log(sqrt(log(sqrt(n)))) + )

Problem 22: 과일 장수

<br /> 문제 해설 : m가 주어졌을 때 사과 m개를 모아서 한박스를 만들고 싶다. 
                 그런데, 박스에 들어간 사과의 min값의 상자 안의 사과 개수를 곱한 값을 
                 전부 더해서 acc_sum을 구한다. 그럴 때 어떻게 하면 가장 최댓값이 나올까?
                 => 정답은 작은 값부터 지우기 
<br /> 자료구조 && 알고라즘 : pq, 힙 정렬 
<br /> 시간복잡도 : O(nlog(n)) where n = |scores|

Problem 23: 푸드 파이트 대회
<br /> 문제해설 : Dequeue에 처음에 0을 삽입해준다. 
                food의 배열의 원소를 2를 나눌 때 생기는 몫만큼 dequeue에 왼쪽, 오른쪽 삽입을 해준다. 
<br /> 자료구조 && 알고리즘 : 수학, Dequeue
<br /> 시간복잡도 : O(|food| * log_2(max(food)))

Problem 24: 햄버거 만들기 
<br /> 빵 야채 고기 빵 순으로 나오면 햄버거가 되므로 지워줘야 한다. 
       빵 빵 야채 고기 빵 야차 고기 빵이 나온 경우도 전부 지워줘야 한다.
       Stack은 idx 접근이 안되기 때문에 ArrayList를 이용해서 idx접근을 하고,
       Stack과 유사하게 사용했다.
<br /> 사용한 자료구조 && 알고리즘 : ArrayList, Stack 
<br /> 시간복잡도 O(2*n) where n = |ingredient|

Problem 25: 옹알이 (2)
<br />
<br />
<br />

Problem 26: 
<br />
<br />
<br />

Problem 27: 
<br />
<br />
<br />

Problem 28: 
<br />
<br />
<br />

Problem 29: 
<br />
<br />
<br />

Problem 30: 
<br />
<br />
<br />

Problem 31: 
<br />
<br />
<br />

Problem 32: 
<br />
<br />
<br />

Problem 33: 
<br />
<br />
<br />

Problem 34: 
<br />
<br />
<br />

Problem 35: 
<br />
<br />
<br />

Problem 36: 
<br />
<br />
<br />

Problem 37: 
<br />
<br />
<br />

Problem 38: 
<br />
<br />
<br />

Problem 39: 
<br />
<br />
<br />

Problem 40: 
<br />
<br />
<br />

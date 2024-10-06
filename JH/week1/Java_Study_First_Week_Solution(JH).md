# First Week Solution

## 문제 해설

problem 1 :   

- 문제 이해 → 풀이 방향 : 구현, 연산 3개를 구현하는 부분이 까다로울 수도 있을 거 같다.
- 사용한 자료구조 & 시간복잡도 : O(100 * MAX(10초전 이동, 10초후 이동,오프닝 건너뛰기))
- (option 참고 문제 & 참고 링크 등등) :  유사한? 문제 백준 :  https://www.acmicpc.net/problem/1942

problem 2 : 

- bill의 작은 값이 wallet의 작은 값보다 작게, bill의 큰 값이 wallet의 큰 값보다 작으면 된다.
- 둘중 하나라도 만족하지 않는다면, bill의 큰값을 1/2를 한다. min-max 따질 필요가 없이 bill의 값을 줄이는 게 핵심이기 때문이다.
- 시간복잡도는 $O(\log_2{\frac{\text{max(bill[0], bill[1]})}{\text{min(wallet[0], wallet]1])}}})$

problem 3 : 

- park와 matrice 사이즈를 담은 mats가 주어집니다. park의 현재 위치 (i, j)에서 mat size만큼 (i+mat_size, j+mat_size) 위치까지 가로 세로 직사각형으로 전부 탐색했을 때, 다른 사람들에게 점유된 곳이 없다면, (i,j)에서 현재 mat_size를 선택할 수 있습니다. 하지만, 그러한 mat_size 중 가장 큰 것을 선택해야 합니다. 따라서 큰 것부터 탐색해서 그러한 것이 먼저 나오면 바로 return 하도록 코드를 구현하면 됩니다.
- 시간복잡도 $O(mats.length * park[i][j]^2 * mats[i]^2)$

problem 4 :

- gifts라는 배열에서 이번달에 선물을 주는 사람, 받는 사람의 이름이 주어집니다. 이 이름들은 전부 friends에 포함됩니다. 이 gifts 배열을 통해 아래 기준을 계산합니다.
    1. A와 B 사이 얼마나 많은 선물을 주고 받았는지를 기록하고, 
    2. 만약 1번에서 서로 주고 받은 선물이 같다면, A와 B의 gift_index를 계산해서 누가 더 큰 값의 gift_index를 가지는지 비교한다. 더 작은 값의 gift_index를 가지는 사람이 더 큰 값의 gift_index를 가지는 사람에게 선물을 준다. 
    3. 만약에 2번에서도 같은 값이 나온다면 다음달에 선물을 주지 않는다. 
- 위 1, 2, 3을 계산했을 때 가장 선물을 많이 받는 사람을 구하시오. 라는 문제입니다.
- 저는 선물을 서로 주고 받은 기록을 friendsIndex, giftIndex는 friendsGiftIndex로 기록했습니다.
- 시간복잡도는 $O(\text{|gifts|}+\text{|friends|}^2)$

problem 5 : 붕대 감기 

- 관찰 1 : cur_time은 항상 attack_time보다 작다. (why current_
- 관찰 2 : differ_time = attack_time - cur_time - 1 (why ?
- 관찰 1, 2을 통해 for loop 한번에 현재 시간과 어택 시간 사이를 계산할 수 있으며, 이를 통해 bandage 회복 정도를 계산할 수 있습니다. 즉 for-loop 한번에 원하는 계산을 할 수 있음을 알 수 있습니다.
- 단, health가 0 이하가 되는 순간 곧장 break를 해야 하며, differ_time이 t보다 크거나 같은 경우,
    
    y*(differ_time/t)로 계산해야 하는데 괄호를 조심해야 한다. 
    
- 시간복잡도 : $O(\text{|attacks|})$

problem 6 : 

- 주어진 위치 (h,w)에서 주변 색이 같은 경우를 cnt 한다.
- 시간복잡도 O(1)

problem 7 : 데이터 분석

- 시키는 대로 구현을 하면 된다. ext와 val_ext가 주어지면, val_ext보다 큰 거나 같은 걸 먼저 지우고, 다음에 정렬을 하면 된다. 탐색과 동시에 지우기 위해 LinkedList를 이용하였다.
- 사용한 자료구조 : LinkedList
- 시간복잡도 : $O(\text{|data|}\log(\text{|data|}))$

problem 8 : 

- 먼저 players를 배열에 저장해주었고, 이 과정에서 index를 HashMap을 이용해 기록해주었다.
- 관찰 : 문제에서 1등인 선수가 불리는 경우가 없다고 했기 때문에 index는 1 이상의 값이다.
- 이를 이용해서 callings을 순회하면서 callings[i]의 선수를 index를 저장된 해시맵에서 찾았고, index-1에 해당하는 선수와 바꾸고, 해시맵에도 갱신을 해주면서 문제를 풀었다.
- $O(|\text{callings}|)$

problem 9 : 추억 점수 

- 해시를 이용하여 name 배열에 있는 값을 저장하고, photo에 있는 배열마다 값을 계산하여 answer 배열에 저장했다.
- 사용한 자료구조 : 해시맵, 배열
- 시간복잡도 : O( $|\text{photo}|)$, HashMap은 거의 O(1)이라 생략했다.

problem 10 : 공원 산책

- 처음 “S”가 어디에 위치해있는지 찾고, 그뒤로는 routes에 대한 for 문을 돌면서
    1. 벽을 만나는지
    2. 공원 바깥으로 벗어나는지 
    
    체크해주었고, S의 위치가 변하는 걸 갱신해주었다. 
    
- 시간복잡도 : O$(\text{|routes|}*n) = O(2500 + 50*9)$

problem 11 :  바탕화면 정리 

- 파일 “#”가 나오는 (i,j) 위치 중 i의 min, max값과 j의 min, max 값을 저장한 뒤에 max값은 각각 +1을 해주었다. 이는 파일의 위치에서 각각을 +1을 해야 max 위치에 있는 파일이 포함됨을 알 수 있기 때문이다.
- 시간복잡도 : $O(50*50*4) = O(10000)$ # 4는 비교연산

problem 12 : 덧칠하기 

- 이전에 한번 본 문제 같아서 비슷한 방식으로 접근했다. 여기서 가장 중요한 관찰은 어떤 식으로 롤러의 위치를 선택하는 것이 가장 최적인지 찾는 것이다. 생각해보자. 칠해야 하는 section은 오름차순으로 정렬이 되어있다. 제일 앞에 나오는 section[i] 값에서부터 롤러를 칠한다면 section[i] + m -1 까지 칠할 수 있다. 현재의 선택으로 더이상 더 선택할 것이 없기 때문에 (idx = section[i] + m - 1까지는) 최적이다.
    - 만약에 시작점이 section[i]이 아니라 j < section[i]를 만족하는 j라고 해보자. [j, j + m - 1] 범위 안에 section 값들이 [section[i], section[i] + m - 1] 안의 section 값들과 일치한다면, section[i]를 선택하든, 더 작은 j를 선택하든 상관없다. 그러나, 항상 일치하지는 않기 때문에 모순이 생길 수도 있다. 그러므로 최적의 선택이라고 할 수 없다.
    - 만약에 시작점 j가 section[i]보다 크다면(즉, section[i] < j ) 원래 칠해야 한 section[i]를  한번 더 칠해야 하기 때문에 최적의 선택이 아니다.
    - ⇒ 따라서 section[i]을 롤러의 시작점으로 잡는 게 최적의 선택이 된다.
- 알고리즘 : greedy
- 시간 복잡도 : $O(\text{|section|})$

problem 13 : 대충 만든 자판 

- 해시맵을 이용해서 각각의 char값의 위치를 저장해주었는데, 그러한 키가 keymap 사이즈만큼 있기 때문에, ArrayList로 HashMap을 담아서 저장해주었다. 그다음에는 targets의 string값에 for loop를 돌렸고, 각각의 char값을 앞서 저장한 key값에 대입해서 index의 min값을 찾으려고 했는데, 그러한 값이 없다면 INT_MAX로 리턴을 하게 했고, 그경우에는 answer에 -1로 저장해주었다.
    - string의 모든 char에 대해서 hashmap에서 index를 찾을 수 있으면
        
        ( $idx_{i_1} = \text{argmin}_{\text{Hash function H}} {\text{H}(idx_{i_1})=str_i[1]})$ 
        
        각각의 char의 min-index를 구해서 이를 누적해서, answer[i]에 저장했다. 
        

- 사용한 자료구조 : 해시맵, ArrayList(C++, Vector)
- 시간복잡도 : O(10000 + 10000) = O(20000) 대략적

problem 14 : 카드 뭉치 

- 문제 풀이 : cards1, cards2의 원소의 순서는 바뀔 수 없다. i, j를 각각 cards1, cards2의 index로 정의했고, cards1과 cards2의 앞에서부터 goals의 char와 일치하는 것들을 찾아나간다. 여기서 cards1을 먼저 체크하나 cards2를 먼저 체크하나 상관이 없다. 만약에 i,j를 다 탐색했지만, goals의 char를 전부 찾지 못한 경우도 fail이고, goal의 char를 현재 cards1[i], cards2[j]에서 찾지 못한다고 해도 fail이다.
- 시간복잡도는 그러므로 O($|\text{goals}| * maxLength_{0<i<|goal|}(goal[i])\ )$

problem 15 : 둘만의 암호 

- 문제 풀이 : s가 주어졌을 때 각각의 char를 알파벳 인덱스에서 index만큼 이동하는 것이다. z 다음부터는 a로 다시 돌아가면 된다. 그리고, 만약에 현재의 char나 다음의 char가 skip 안에 들어간 char라면 계속해서 다음 알파벳으로 넘어간다.
- 시간복잡도 : O(50 x 10 x 20) # 길이, 체크, 인덱스

problem 16 : 개인정보 수집 유효기간 

- 문제 풀이 : 현재(today) 기준으로 terms의 해당하는 문자의 월을 적용했을 때, 파기해야 하는 개인정보의 index를 저장해야 합니다. 모든 월이 28로 일정한 것을 이용해서 현재일부터 가산해야 하기 때문에 월을 일로 바꾸고 더한 뒤에는 -1를 빼야 합니다.
- 시간복잡도는 $O(|\text{terms}| * \text{|privacies|}* C) = O(20000 * 30)$  # 30 := 잡다한 연산, 대략적인 값

problem 17 : 크기가 작은 부분 문자열 

- 문제 풀이 : t 문자열의 index = 0부터 시작하는 길이가 m인 (연속적인) 부분문자열을 전부 찾아내야 한다. 그중에서 p보다 더 작은 문자열이 몇개인지 찾아야 한다. 여기서 주의할 점은 p의 길이가 18이므로 10^18이 될 수 있으니 int 범위에서 벗어날 수도 있다. 나는 그래서 compareStr이라는 문자열 비교 함수를 만들어서 인트로 바꿔서 풀기보다는 문자열 비교로 풀었다.
- 시간복잡도 : $O( (n-m+1)*18)$  # n : t.length, m = p.length

problem 18 : 가장 가까운 글자 

- 문제 풀이 : 해시맵처럼 chk[27] 배열을 선언해서 -1로 초기화를 해주었고, 주어진 문자열 s에 대한 for-loop를 돌면서 해당 char값이 c라면, chk[c-’a’]이 -1이라면 현재의 index를 넣어주고, answer[i] = -1를 해주었고, -1이 아니라면 answer[i] = i - chk[c-’a’] 를 해주었다.
- 시간복잡도 : $O(26+ \text{|s|})$

problem 19 : 문자열 나누기 

- 문제 풀이 : 현재 인덱스를 i라고 하자. 문자열 s가 주어졌을 때, 현재 위치에 있는 값을 기준으로 다음 인덱스부터 처음값과 같은 값이 나오면 same +=1, 그렇지 않으면 notSame+=1를 했을 때 same == notSame이 나오는 순간 다음 인덱스로 넘어가면서 덩어리의 개수를 추가한다. 더이상 same == notSame으로 찾을 수 없거나 운이 좋아서 마지막이 same == notSame이 나올 때까지 반복해서 총 몇개의 덩어리로 문자열이 나눠지는지 찾아야 한다. 간단히 while을 이용해서 풀었다.
- 시간복잡도 : $O(|s|)$

problem 20 : 명예의 전당 

- 문제 풀이 : 명예의 전당엔 값이 큰 k명만 들어갈 수 있다. 명예의 전당의 인원이 k명이 되기 전까지는 그대로 들어가면 되지만, 인원이 k명보다 큰 경우에는 pop을 해서 k명을 맞춰야 한다.
- 사용한 자료 구조 : 우선순위 큐
- 시간복잡도 : O($|scores| * \log(\text{|scores|})$

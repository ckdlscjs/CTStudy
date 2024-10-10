## Solving Programmers level 1 Problems (2) : 21 - 40
## Problems and Links

| 문제  | URL |
| --- | --- |
| problem 21. | [https://school.programmers.co.kr/learn/courses/30/lessons/136798](https://school.programmers.co.kr/learn/courses/30/lessons/136798) |
| problem 22. | [https://school.programmers.co.kr/learn/courses/30/lessons/135808](https://school.programmers.co.kr/learn/courses/30/lessons/135808) |
| problem 23. | [https://school.programmers.co.kr/learn/courses/30/lessons/134240](https://school.programmers.co.kr/learn/courses/30/lessons/134240) |
| problem 24. | [https://school.programmers.co.kr/learn/courses/30/lessons/133502](https://school.programmers.co.kr/learn/courses/30/lessons/133502) |
| problem 25. | [https://school.programmers.co.kr/learn/courses/30/lessons/133499](https://school.programmers.co.kr/learn/courses/30/lessons/133499) |
| problem 26. | [https://school.programmers.co.kr/learn/courses/30/lessons/132267](https://school.programmers.co.kr/learn/courses/30/lessons/132267) |
| problem 27. | [https://school.programmers.co.kr/learn/courses/30/lessons/131705](https://school.programmers.co.kr/learn/courses/30/lessons/131705) |
| problem 28. | [https://school.programmers.co.kr/learn/courses/30/lessons/131128](https://school.programmers.co.kr/learn/courses/30/lessons/131128) |
| problem 29. | [https://school.programmers.co.kr/learn/courses/30/lessons/118666](https://school.programmers.co.kr/learn/courses/30/lessons/118666) |
| problem 30. | [https://school.programmers.co.kr/learn/courses/30/lessons/92334](https://school.programmers.co.kr/learn/courses/30/lessons/92334) |
| problem 31. | [https://school.programmers.co.kr/learn/courses/30/lessons/87389](https://school.programmers.co.kr/learn/courses/30/lessons/87389) |
| problem 32. | [https://school.programmers.co.kr/learn/courses/30/lessons/86491](https://school.programmers.co.kr/learn/courses/30/lessons/86491) |
| problem 33. | [https://school.programmers.co.kr/learn/courses/30/lessons/86051](https://school.programmers.co.kr/learn/courses/30/lessons/86051) |
| problem 34. | [https://school.programmers.co.kr/learn/courses/30/lessons/82612](https://school.programmers.co.kr/learn/courses/30/lessons/82612) |
| problem 35. | [https://school.programmers.co.kr/learn/courses/30/lessons/81301](https://school.programmers.co.kr/learn/courses/30/lessons/81301) |
| problem 36. | [https://school.programmers.co.kr/learn/courses/30/lessons/77884](https://school.programmers.co.kr/learn/courses/30/lessons/77884) |
| problem 37. | [https://school.programmers.co.kr/learn/courses/30/lessons/77484](https://school.programmers.co.kr/learn/courses/30/lessons/77484) |
| problem 38. | [https://school.programmers.co.kr/learn/courses/30/lessons/76501](https://school.programmers.co.kr/learn/courses/30/lessons/76501) |
| problem 39. | [https://school.programmers.co.kr/learn/courses/30/lessons/72410](https://school.programmers.co.kr/learn/courses/30/lessons/72410) |
| problem 40. | [https://school.programmers.co.kr/learn/courses/30/lessons/70128](https://school.programmers.co.kr/learn/courses/30/lessons/70128) |

## 문제 해설

Problem 21: </br>
-O(N*logN) </br>
-number를 기준으로 1까지 약수를 구한다, std::sqrt 제곱근을 이용해 약수를 찾는시간을 줄이고 answer에더한다

Problem 22: </br>
-O(N) </br>
-내림차순으로 소팅, i*m-1인덱스(가장작은값)으로 m개중 가장 작은값을 기준으로 *m하여 더한다 </br>
-그리디, 내림차순으로 정렬해 끝값만을 체크하면서 반복문(i*m)만큼 체크할시 끝값(작은값)이 무조건 상자의금액이된다

Problem 23:  </br>
-O(N*M) </br>
-재귀로구현, food의길이 * 원소의갯수

Problem 24: </br>
-O(8*N(N)) </br>
-스택으로구현, top이 1일때 체크하여 1321이면 스택에서제거, 아닐시 다시push

Problem 25: </br>
-O(N * 4M(N * M)) </br>
-find함수를 문자열 4개기준, N번으로 찾는다, 문자열길이가 M일때 대략 4M * N

Problem 26: </br>
-O(대략 logN) </br>
-일차방정식을 기준으로 좌우를 계산해 ans에값을더해나간다

Problem 27: </br>
-O(n^3) </br>
-입력값이작으므로 순열로 중복을 제외하고 체크해 계산한다

Problem 28: </br>
-O(4N(N)) </br>
-X,Y를 순회하면서 계수정렬트릭처럼 갯수를 카운팅하여 내림차순으로 숫자를 더해나간다, 0일때의 엣지케이스 고려가 필요하므로 이를주의한다

Problem 29: </br>
-O(N) </br>
-해쉬맵으로 성향값을 미리 입력해놓고 순회하면서 종류에따라 가중치를 계산, 이후 answer에 한 성향씩 조건비교해가며 붙혀나간다

Problem 30: </br>
-O(N*21(원소길이) + M) </br>
-입력받은 신고결과를 set을 통해서 중복을 구분, 해쉬맵을통해 신고받은횟수를 계산하고 이를 해쉬맵(신고자들명단컨테이너)를 이용해 
순회하며 신고횟수를 체크해 1씩증감해 결과에 삽입한다. find(21문자열)길이 를 통해 체크, 스플릿

Problem 31: </br>
-O(N) </br>
-가장작은값 1부터 증감시켜나가며 조건부합시 탈출

Problem 32: </br>
-O(N) </br>
-컨테이너의 원소를 양측을기준으로 큰값을 왼쪽에, 작은값을 우측에 두고 이를 기반으로 큰값중제일큰값, 작은값중 제일큰값을 갱신해 곱하면 가능한최대(최소)를 계산가능

Problem 33: </br>
-O(N) </br>
-모든합인 45에서 있는수만을 감산

Problem 34: </br>
-O(N) </br>
-반복문으로 1부터 더해나가고 최종출력값이 0보다 크다면 계산값, 작으면 추가금액이필요없으므로 0

Problem 35: </br>
-O(N), find연산 unordered_map의경우 충돌없으면O(1)이므로N </br>
-미리 컨테이너에 zero~nine까지 문자열 입력해놓고 find로 찾아서 temp값을 비교해가면서 있을경우 answer에 가산, 임시문자열clear

Problem 36: </br>
-O(N*sqrtN), right-left(N) </br>
-약수를 제곱근을 이용해 갯수를 찾고 set(hash or tree)를 이용해 중복제거해가면서 삽입, 갯수 계수하여 가/감

Problem 37: </br>
-O(N+M) </br>
-비트마스킹(45개이상이므로 long long int)을 이용해 로또번호를 체크해주고 체크,0체크 카운팅해주어 계산

Problem 38: </br>
-O(N)

Problem 39: </br>
-O(N + 7단계반복문) </br>
-1~2단계 까지 O(N)으로 이터레이터로 순회하면서 문자열변경, 3~6단계까지 조건체크후변경, 7단계 마지막문자반복

Problem 40: </br>
-O(N)

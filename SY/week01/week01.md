# First Week

---

## Solving Programmers level 1 Problems (1) : 1 - 20

## Problems and Links

| 문제  | URL |
| --- | --- |
| problem 1. | [https://school.programmers.co.kr/learn/courses/30/lessons/340213](https://school.programmers.co.kr/learn/courses/30/lessons/340213) |
| problem 2. | [https://school.programmers.co.kr/learn/courses/30/lessons/340199](https://school.programmers.co.kr/learn/courses/30/lessons/340199) |
| problem 3. | [https://school.programmers.co.kr/learn/courses/30/lessons/340198](https://school.programmers.co.kr/learn/courses/30/lessons/340198) |
| problem 4. | [https://school.programmers.co.kr/learn/courses/30/lessons/258712](https://school.programmers.co.kr/learn/courses/30/lessons/258712) |
| problem 5. | [https://school.programmers.co.kr/learn/courses/30/lessons/250137](https://school.programmers.co.kr/learn/courses/30/lessons/250137) |
| problem 6. | [https://school.programmers.co.kr/learn/courses/30/lessons/250125](https://school.programmers.co.kr/learn/courses/30/lessons/250125) |
| problem 7. | [https://school.programmers.co.kr/learn/courses/30/lessons/250121](https://school.programmers.co.kr/learn/courses/30/lessons/250121) |
| problem 8. | [https://school.programmers.co.kr/learn/courses/30/lessons/178871](https://school.programmers.co.kr/learn/courses/30/lessons/178871) |
| problem 9. | [https://school.programmers.co.kr/learn/courses/30/lessons/176963](https://school.programmers.co.kr/learn/courses/30/lessons/176963) |
| problem 10. | [https://school.programmers.co.kr/learn/courses/30/lessons/172928](https://school.programmers.co.kr/learn/courses/30/lessons/172928) |
| problem 11. | [https://school.programmers.co.kr/learn/courses/30/lessons/161990](https://school.programmers.co.kr/learn/courses/30/lessons/161990) |
| problem 12. | [https://school.programmers.co.kr/learn/courses/30/lessons/161989](https://school.programmers.co.kr/learn/courses/30/lessons/161989) |
| problem 13. | [https://school.programmers.co.kr/learn/courses/30/lessons/160586](https://school.programmers.co.kr/learn/courses/30/lessons/160586) |
| problem 14. | [https://school.programmers.co.kr/learn/courses/30/lessons/159994](https://school.programmers.co.kr/learn/courses/30/lessons/159994) |
| problem 15. | [https://school.programmers.co.kr/learn/courses/30/lessons/155652](https://school.programmers.co.kr/learn/courses/30/lessons/155652) |
| problem 16. | [https://school.programmers.co.kr/learn/courses/30/lessons/150370](https://school.programmers.co.kr/learn/courses/30/lessons/150370) |
| problem 17. | [https://school.programmers.co.kr/learn/courses/30/lessons/147355](https://school.programmers.co.kr/learn/courses/30/lessons/147355) |
| problem 18. | [https://school.programmers.co.kr/learn/courses/30/lessons/142086](https://school.programmers.co.kr/learn/courses/30/lessons/142086) |
| problem 19. | [https://school.programmers.co.kr/learn/courses/30/lessons/140108](https://school.programmers.co.kr/learn/courses/30/lessons/140108) |
| problem 20. | [https://school.programmers.co.kr/learn/courses/30/lessons/138477](https://school.programmers.co.kr/learn/courses/30/lessons/138477) |

## 문제 해설

Problem 1: </br>
-시간을 int형 정수로 변환해 조건을 체크하여 해결

Problem 2: </br>
-문제에서 주어진 경우대로 반복문을 진행하여 해결

Problem 3: </br>
-주어진 배열에서 정사각형의 값을 갱신하기위해서 좌상단, 좌측, 상단 을 체크해 최소값+1로 갱신해나가면서 조건을 사각형범위를 체크하여 최대 값을 체크하고 입력값과 조건체크

Problem 4: </br>
-선물의 전달횟수를 계수하기위한 2차원 배열을 설정하고 주어진 이름을 기반으로 인덱싱컨테이너(std::unordered_map)을 사용, 이를 이용해 주고받은 선물의 갯수, 선물지수 지표(pair배열)을 이용해
조건체크를 통해 정답을 계산

Problem 5: </br>
-시뮬레이션문제, 입력값 길이가 1000개밖에 안되기때문에 for문을 통해 시뮬레이션구현, 정확한 체크를 위해 조건구현중 print를 통해 좌측의 입출력예와 잘 맞아떨어지는지 체크를 통해 오류를 체크

Problem 6: </br>
-dy, dx이용해 계수

Problem 7: </br>
-문제에서 주어진 조건을 인덱스로 체크하여 첫 조건인 val_ext를 기준으로 컨테이너(data)에서 체크후 erase, 이후 인덱싱을 추가활용해 소팅

Problem 8: </br>
-플레이어의 이름을 기준으로 컨테이너에 기존위치를 기억시키고 입력값에 따라 등수를 변경해 갱신

Problem 9: </br>
-점수 체크를 위해 unordred_map을 이용해 계산, 들어있지 않은값은 map구조상 0으로 들어가기에 추가조건체크는 필요없이 구현

Problem 10: </br>
-dy, dx이용해 시뮬레이션, 체크중 조건에 부합하지 않으면 해당 경우는 스킵하고 y,x값을 갱신해 출력

Problem 11: </br>
-ly, lx, ry, rx를 구해야하므로 전체조건을 체크해주기보단 입력값을 다집어넣고 좌상단 우하단을 소팅을 통해 출력, 실제범위는 배열+1칸이므로 우하단은 +1씩 더해줌

Problem 12: </br>
-그리디, 체크위해 끝값을 체크하면서 갯수를 증감시킴, 현재페인팅의 끝위치(r)보다 순회하는 새 위치의 시작점이 크면 해당위치를 기준으로 새로 칠해야하므로 시작값+끝값을 갱신해줌
n까지만 칠해야하므로 std::min을 이용해 엣지케이스체크

Problem 13: </br>
-unordered_map을 이용해 값이 있는지 체크해 최소값만을 더함, 이때 현재 없는값이 존재할경우 조건탈출시켜 -1을출력, 이외는 합계로 출력

Problem 14: </br>
-병합정렬의 구현방식과 동일하게 left,right 컨테이너를 각각 인덱스두개를 활용해 증감시키면서 goal의 순서에 맞는 원소가 있는지 결과체크

Problem 15: </br>
-입력값이 작으므로 continue된 알파벳은 뛰어넘으면서 while로 반복해 최종 alp인덱스위치를 정해 갱신후 출력

Problem 16: </br>
-문자열파싱에 substr을 이용, int형 정수로 날짜를 전부 변환후 이를 계수해 값을 비교후 최종결과에 계산, 시작날도 포함이기에 증가하는 달 * 28 - 1로 현재날을 제거해야함

Problem 17: </br>
-p의 길이가 최대 18이므로 substr을 이용해 문자열을 길이만큼 스플릿후 longlong 변환으로 조건체크후 가산

Problem 18: </br>
-map을 이용해 인덱스값을 체크하면서 갱신해나감, 존재한다면 이전인덱스값을 현재인덱스값에서 빼면 칸수가 계산되므로 이를 추가후 갱신

Problem 19: </br>
-첫 문자값 ch를 기준으로 같으면 int1 증감, 다르면 int2증감시킨후 조건체크하여 다음문자값으로 넘김, 최종적으로 반복문 탈출시 마지막에 조건체크를 하지못했다면 마지막문자열도 추가해야하므로 +1

Problem 20: </br>
-우선순위큐를 이용, 최소힙을 이용해서 컷트라인값(루트노드)을 반복문 체크시마다 출력, 현재사이즈가 조건보다 크면서 새로 삽입되는 값으로인해 경계값의 갱신이 발생하여도 최소힙기준으로 작은값을 우선탈락시키므로 조건에 부합됨

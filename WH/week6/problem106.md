https://www.acmicpc.net/problem/13300

남자끼리 여자끼리 , 한 방에 같은 학년 배정, 한명만 배정도 가능.
최대인원수 K <= 1000
학생 수 N <= 1000
S 성별 0 여학생 1 남학생
Y 학년 1<= Y<= 6

학년과 성별에 따른 학생 이차원배열을 만들경우 이중for문을 순회해도 괜찮은지
-> 한학년에 1000명이 몰려있는 경우 1 * 1000
-> 총 O(1000) 이므로 걍 돌려도 될듯
```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
/*  
남자끼리 여자끼리 , 한 방에 같은 학년 배정, 한명만 배정도 가능.  
최대인원수 K <= 1000학생 수 N <= 1000S 성별 0 여학생 1 남학생  
Y 학년 1<= Y<= 6 */public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        int n = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken());  
        int[][] students = new int[6][2];  
        int count = 0;  
        // NOTE: 주어진 학생 분류  
        for(int i = 0; i < n; i++){  
            st = new StringTokenizer(br.readLine());  
            int s = Integer.parseInt(st.nextToken());  
            int grade = Integer.parseInt(st.nextToken());  
            students[grade - 1][s]++;  
        }  
        // NOTE: 학생 배열 순회  
        for(int i = 0; i < students.length; i++){  
            for(int j = 0; j < students[i].length; j++){  
                count += students[i][j] / k;  
                count += students[i][j] % k;  
            }  
        }  
        System.out.println(count);  
  
  
    }  
}
```
어째서 2점....?
```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
/*  
남자끼리 여자끼리 , 한 방에 같은 학년 배정, 한명만 배정도 가능.  
최대인원수 K <= 1000학생 수 N <= 1000S 성별 0 여학생 1 남학생  
Y 학년 1<= Y<= 6 */
public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        int n = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken());  
        int[][] students = new int[6][2];  
        int count = 0;  
        // NOTE: 주어진 학생 분류  
        for(int i = 0; i < n; i++){  
            st = new StringTokenizer(br.readLine());  
            int s = Integer.parseInt(st.nextToken());  
            int grade = Integer.parseInt(st.nextToken());  
            students[grade - 1][s]++;  
        }  
        // NOTE: 학생 배열 순회  
        for(int i = 0; i < students.length; i++){  
            for(int j = 0; j < students[i].length; j++){  
                count += students[i][j] / k;  
                if(students[i][j] % k != 0)  
                    count += 1;  
            }  
        }  
        System.out.println(count);  
  
  
    }  
}
```
나머지를 계산하는 부분에서 잘못 계산하였다. 
나누어 떨어지지 않는 경우 방 개수를 +1을 해주어야하는데 나머지를 더해버렸음 

### 다른 사람풀이
2차원배열을 선언하지 않고 1차원 배열 학년별 성별로 13개의 배열을 선언하여 계산하였음.
2차원 배열과메모리 소요시간 동일
```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
/*  
남자끼리 여자끼리 , 한 방에 같은 학년 배정, 한명만 배정도 가능.  
최대인원수 K <= 1000학생 수 N <= 1000S 성별 0 여학생 1 남학생  
Y 학년 1<= Y<= 6 */
public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        int n = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken());  
        int[] students = new int[13];  
        int count = 0;  
        // NOTE: 주어진 학생 분류  
        for(int i = 0; i < n; i++){  
            st = new StringTokenizer(br.readLine());  
            int s = Integer.parseInt(st.nextToken());  
            int grade = Integer.parseInt(st.nextToken());  
            students[s*6 + grade]++;  
        }  
        // NOTE: 학생 배열 순회  
        for(int i = 1; i < students.length; i++){  
            count += students[i] / k;  
            count += students[i] % k != 0 ? 1 : 0;  
        }  
        System.out.println(count);  
    }  
}
```

https://www.acmicpc.net/problem/11328

1 <= N <= 1000

문자열의 최대길이 1000

엣지케이스 1000개의 테스트케이스 각 문자열길이가 1000개이면 O(1000) * O(2000* 1000) = O (2,000,000,000)

처음 든 생각 각 문자열을 배열에 집어넣고 정렬하여서 각각 비교하면 어떨까 => 시간 초과날듯,,

```java
package CodingTest;  
  
import java.io.*;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        int n = Integer.parseInt(st.nextToken());  
  
        for(int i = 0; i < n; i++){  
            String[] strArr = br.readLine().split(" ");  
            String[] firstArr = strArr[0].split("");  
            String[] secondArr = strArr[1].split("");  
  
            Arrays.sort(firstArr);  
            Arrays.sort(secondArr);  
  
            boolean isPossible = false;  
            for(int j = 0; j < firstArr.length; j++){  
                if(firstArr[j].equals(secondArr[j])) {  
                    isPossible = true;  
                }else{  
                    isPossible = false;  
                    break;  
                }  
            }  
            bw.write(isPossible ? "Possible\n": "Impossible\n");  
        }  
        bw.flush();  
//        bw.close();  
    }  
}
```

어라 시간초과 안나네,,

다른 사람들은 배열 인덱스를 활용한 풀이를 많이 했네 

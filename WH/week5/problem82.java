https://school.programmers.co.kr/learn/courses/30/lessons/12903


```java
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(n % 2 == 0){
            sb.append(s.charAt(n / 2 - 1));
            sb.append(s.charAt(n / 2));
            
        }else{
           sb.append(s.charAt(n / 2));
        }
        return sb.toString();
    }
}
```

StringBuilder를 사용하여 문자열 객체 생성에 소요되는 시간 감소 시간 복잡도 O(1) (?)

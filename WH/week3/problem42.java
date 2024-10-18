#### 첫번째 풀이
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = numbers.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i != j){
                    int first = numbers[i];
                    int second = numbers[j];
                    list.add(first + second);
                }
            }
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        Integer[] result = Arrays.stream(answer)
            .boxed()
            .distinct()
            .toArray(Integer[]::new);
        Arrays.sort(result);
        
        return Arrays.stream(result)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

#### 두번째 풀이
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = set.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}

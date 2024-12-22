import java.util.ArrayList;
import java.util.Collections;

public class Problem48 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            int start = command[0]-1;
            int end = command[1];
            int k = command[2]-1;
            int cnt = 0;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = start;i<end;i++){
                tmp.add(array[i]);
            }
            Collections.sort(tmp);
            answer[idx++] = tmp.get(k);
        }
        return answer;
    }
}
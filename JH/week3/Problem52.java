import java.util.Arrays;

public class Problem52 {
    public int solution(int[] d, int budget) {

        int answer = 0;
        int acc_sum = 0;
        Arrays.sort(d);
        for(int i = 0;i<d.length;i++){
            if(acc_sum + d[i] > budget){
                break;
            }
            acc_sum += d[i];
            answer++;
        }
        return answer;
    }
}

// def solution(d, budget):
//     answer = 0
//     d.sort()
//     acc_sum = 0
//     for num in d:
//         if(acc_sum + num >budget):
//             break
//         acc_sum += num
//         answer+=1
//     return answer
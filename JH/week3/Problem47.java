import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int n = answers.length;
        
        int[] first = duplicateArray(n, (int) Math.ceil(5.5),  new int[]{1,2,3,4,5});
        int[] second = duplicateArray(n, (int) Math.ceil(5.5), new int[]{2,1,2,3,2,4,2,5});
        int[] third = duplicateArray(n, (int) Math.ceil(5.5), new int[]{3,3,1,1,2,2,4,4,5,5});
        
        for(int i = 0;i<n;i++){
            if(first[i]==answers[i]){
                answer[0]++;        
            }
            if(second[i]==answers[i]){
                answer[1]++;        
            }
            if(third[i]==answers[i]){
                answer[2]++;        
            }
        }
        
        ArrayList<Integer> st = new ArrayList<Integer>();
        
        int M = -1;
        for(int i = 0;i<3;i++){
            if(M<answer[i]){
                M = answer[i];
            }
        }
        

        for(int i = 0;i<3;i++){
            if(answer[i]==M){
                st.add(i+1);
            }
        }
        
        int[] last_answer = new int[st.size()];
        
        for(int i = 0;i<st.size();i++){
            last_answer[i] = st.get(i);
        }
        
        return last_answer;
    }
    
    static int[] duplicateArray(int size, int times, int[] defaultArray){
        int[] ret = new int[size];
        int m = defaultArray.length;
        for(int i =0;i<size;i++){
            ret[i] = defaultArray[i%m];
        }
        return ret;
    }
}
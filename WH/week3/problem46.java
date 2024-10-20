// 처음풀이 OutOfBoundExcption
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int possible = 0;
        int[] students = new int[n];
        for(int i = 0; i < reserve.length; i++){
            students[reserve[i]] += 2;
        }
        possible += reserve.length;
        
        for(int i = 0; i < n; i++){
            if(students[0] == 0 && students[1] > 1){
                 students[0] = 1;
                 possible++;
            }else if(students[n-1] == 0 && students[n-2] > 1){
                  students[n - 1] = 1;
                  possible++;
            }else if(students[i] == 0){
                if(students[i-1] > 1){
                    students[i] = 1;
                    possible++;
                    students[i-1]--;
                }else if(students[i+1] > 1){
                    students[i] = 1;
                    possible++;
                    students[i+1]--;
                }
            }
        }
        
        return possible;
    }
}

// 시간초과
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int[] students = new int[n+1];
        int possible = 0;
        for(int i : lost){
            students[i]--;
        }
        for(int i : reserve){
            students[i]++;
        }
        for(int i = 1; i <= n; i++){
            if(students[i] < 0 && students[i-1] >= 1){
                students[i] += 1;
                students[i-1] -= 1;
            }
            if(students[i] < 0 && students[i+1] >= 1){
                students[i] += 1;
                students[i+1] -= 1;
            }
        }
        for(int i = 1; i <= n; i++){
            if(students[i] >= 0) possible++;
        }
        return possible;
    }
}

// 배열길이 +1 하였더니 통과 

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int[] students = new int[n+2];
        int possible = 0;
        for(int i : lost){
            students[i]--;
        }
        for(int i : reserve){
            students[i]++;
        }
        for(int i = 1; i <= n; i++){
            if(students[i] < 0 && students[i-1] >= 1){
                students[i] += 1;
                students[i-1] -= 1;
            }
            if(students[i] < 0 && students[i+1] >= 1){
                students[i] += 1;
                students[i+1] -= 1;
            }
        }
        for(int i = 1; i <= n; i++){
            if(students[i] >= 0) possible++;
        }
        return possible;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;
import java.util.ArrayList;

public class problem81{
    static class Solution{


    public ArrayList<Integer> solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        ArrayList<Integer> st = new ArrayList<Integer>();
        
        for(int num : arr){
            int n = st.size();
            if(n==0){
                st.add(num);
            }else{
                if(st.get(n-1) == num){
                    continue;
                }else{
                    st.add(num);
                }
            }
        }

        return st;
    }
}
    public static void main(String[] args) 
    {

    }
}
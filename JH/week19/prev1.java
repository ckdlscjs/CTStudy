package week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prev1 {


    static int[] makeTable(String pattern) {
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int j = 0;

        for(int i = 1;i<patternSize;i++){
            while(j>0 && pattern.charAt(i)!=pattern.charAt(j)){
                j = table[j-1];
            }
            if(pattern.charAt(i)==pattern.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }

    static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> foundPositions = new ArrayList<>();

        int[] table = makeTable(pattern);
        int textSize = text.length();
        int patternSize = pattern.length();
        int j = 0;

        for(int i = 0; i < textSize; i++){
            while(j > 0 && text.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }
            if(text.charAt(i) == pattern.charAt(j)){
                if (j == patternSize - 1) {
                    foundPositions.add(i - patternSize + 2);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
        return foundPositions;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 문제에 맞게 입력 받기
        String text = bf.readLine();   // 첫째 줄 -> 텍스트
        String pattern = bf.readLine(); // 둘째 줄 -> 패턴

        // 패턴 매칭
        List<Integer> result = KMPSearch(text, pattern);

        // 출력
        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        for(int pos : result) {
            sb.append(pos).append(" ");
        }
        System.out.println(sb);
    }
}

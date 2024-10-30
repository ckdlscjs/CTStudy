
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class problem108{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        int[] nums = new int[26];
        Arrays.fill(nums, 0);
        for(char c : a.toCharArray()){
            nums[c-'a']++;
        }
        for(char c : b.toCharArray()){
            nums[c-'a']--;
        }

        int cnt = 0;
        for(int i = 0;i<26;i++){
            cnt += Math.abs(nums[i]);
        }
        System.out.println(cnt);
    }
}
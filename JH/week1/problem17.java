package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem17 {
        static class Solution {
            public int compareStr(String a, String b){

                if(a.equals(b)){
                    return 0;
                }else
                {
                    if(a.length() > b.length())
                    {
                        return 1;
                    }
                    else if (a.length() == b.length())
                    {

                        for(int i = 0; i<a.length();i++)
                        {
                            if(a.charAt(i) > b.charAt(i))
                            {
                                return 1;
                            }
                            else if(a.charAt(i) < b.charAt(i))
                            {
                                return -1;
                            }else
                            {
                                continue;
                            }
                        }
                        return 0;
                    }else
                    {
                        return -1;
                    }
                }
            }
            public int solution(String t, String p) {
                int answer = 0;
                // sliding window;
                int m = p.length();
                int n = t.length();
                //  0123
                //    
                // "abcd" : 4 
                // "ab" : 2 -> 4 - 2 + 1 = 3 
                // int pivot = Integer.parseInt(p);
                // i < 3 := 0, 1, 2
                
                for(int i = 0;i<(n - m + 1); i++){
                    String ret = "";
                    for(int k =0;k<m;k++){
                        ret += t.charAt(i+k);
                    }
                    
                    System.out.println(ret);
                    if(compareStr(p, ret)>=0){
                        answer++;
                    }
                }
                System.out.println(compareStr("271", "159"));
                return answer;
            }
        }

        public static void main(String[] args) throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            Solution ss = new Solution();
            String a = bf.readLine();
            String b = bf.readLine();
            bf.close();
            System.out.println(ss.solution(a, b));
            // System.out.println(b.substring(1, 2));
        }
}
// "3141592", "271"

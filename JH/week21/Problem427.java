package week21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem427 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String target = bf.readLine();
        int res = 0;
        int index = 0; // start index
        int otherIdx = target.length()-1; // end index

        while(true){
            int pos = s.indexOf(target, index);
            if(pos ==-1){
                break;
            }
            res++;
            index = pos + target.length();
        }
        System.out.println(res);
    }
}

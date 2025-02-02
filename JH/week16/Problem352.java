package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem352 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> Left = new PriorityQueue<>(
                (a,b) -> b - a
        );
        PriorityQueue<Integer> Right = new PriorityQueue<>(Integer::compare);

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=N;i++){
            int m = Integer.parseInt(bf.readLine());
            Right.add(m);

            while (Left.size() < Right.size()) {
                Left.add(Right.poll());
            }

            if(!Left.isEmpty() && !Right.isEmpty() && Left.peek() > Right.peek()){
                int left = Left.poll();
                int right = Right.poll();
                Right.add(left);
                Left.add(right);
            }
            // System.out.println("Left " + Left);
            // System.out.println("Right " + Right);
            sb.append(Left.peek()).append('\n');
        }
        System.out.print(sb);
    }
}

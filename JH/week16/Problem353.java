package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem353 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );

        PriorityQueue<Integer> resPq = new PriorityQueue<>();


        int n = Integer.parseInt(bf.readLine());

        for(int i = 0;i<n;i++){
            StringTokenizer st =  new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{a,b});
        }


        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            resPq.offer(cur[1]);
            if (resPq.size() > cur[0]) {
                resPq.poll();
            }
        }

        int res = 0;
        while (!resPq.isEmpty()){
            res += resPq.poll();
        }
        System.out.println(res);
    }
}

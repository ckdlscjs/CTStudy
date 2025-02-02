package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem350 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            long m = Integer.parseInt(st.nextToken());
            pq.add(m);
        }

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            res += (a + b);
            pq.add(a + b);
        }
        System.out.println(res);
    }
}

// 10 20 30 40 50
//
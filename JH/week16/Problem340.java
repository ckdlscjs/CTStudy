package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem340 {

    static class bucket implements Comparable<bucket> {
        @Override
        public int compareTo(bucket o) {
            return this.m - o.m;
        }

        int m;
        int v;
        bucket(int m, int v){
            this.m = m;
            this.v = v;
        }
    }
    static bucket[] buckets;
    static int[] bags;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] read = bf.readLine().split(" ");
        int N = Integer.parseInt(read[0]);
        buckets = new bucket[N];

        int K = Integer.parseInt(read[1]);
        bags = new int[K+1];

        for(int i = 0;i<N;i++){
            String[] read1 = bf.readLine().split(" ");
            int m = Integer.parseInt(read1[0]);
            int v = Integer.parseInt(read1[1]);
            buckets[i] = new bucket(m,v);
        }

        for(int j = 0;j<K;j++){
            bags[j] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(buckets);
        Arrays.sort(bags);

        // max queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        long maxPrice = 0L;
        int idx = 0;
        for(int bag : bags){
            while(idx<N && buckets[idx].m <= bag){
                pq.offer(buckets[idx].v);
                idx++;
            }
            if(!pq.isEmpty()){
                maxPrice += pq.poll();
            }
        }
        System.out.println(maxPrice);
    }
}

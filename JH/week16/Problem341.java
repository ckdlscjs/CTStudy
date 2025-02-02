package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem341 {
    static HashMap<Integer, Integer> count = new HashMap<>();
    static PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
    ); // 둘다 오름차순 := 작은 거 먼저

    static PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0])
    ); // 내림차순은 (a,b) -> b-a

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            int num = Integer.parseInt(str[0]);
            int hardness = Integer.parseInt(str[1]);
            minHeap.add(new int[]{num, hardness});
            maxHeap.add(new int[]{num, hardness});
            count.put(num, hardness);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            String[] str = bf.readLine().split(" ");
            if (str[0].equals("add")) {
                int num = Integer.parseInt(str[1]);
                int hardness = Integer.parseInt(str[2]);
                minHeap.add(new int[]{num, hardness});
                maxHeap.add(new int[]{num, hardness});
                count.put(num, hardness);
            }
            else if(str[0].equals("recommend")) {
                if (str[1].equals("1")) {
                    sb.append(recommend(maxHeap)).append('\n');
                }else{ // -1
                    sb.append(recommend(minHeap)).append('\n');
                }
            } else if (str[0].equals("solved")) {
                int num = Integer.parseInt(str[1]);
                count.remove(num);
            }
        }
        System.out.println(sb);
    }

    private static int recommend(PriorityQueue<int[]> pq) {
        while(!pq.isEmpty()) {
            int[] p = pq.peek();
            if( count.containsKey(p[0]) && count.get(p[0]) == p[1]){
                return p[0];
            }
            pq.poll();
        }
        return -1;
    }
}

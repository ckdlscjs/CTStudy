package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem304 {
    static boolean[][] times = new boolean[500001][2];
    static int[] moves = new int[]{-1,1,2};

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BFS(N, K);
    }

    private static void BFS(int N, int K) {

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        times[N][0] = true;
        int ret = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int 동생위치 = K + (ret * (ret+1))/2;
            if(동생위치>500000) break;
            if(times[동생위치][ret%2]){
                System.out.println(ret);
                return;
            }
            // times[K + ret][ret % 2] = true;
            for(int k = 0; k < len; k++) {
                int[] node = queue.poll();
                int pos = node[0], time = node[1];
                for(int i = 0;i<3;i++){
                    int nxtPos = (i < 2) ? pos + moves[i] : pos * 2;
                    if(nxtPos<0 || nxtPos>500000) continue;
                    if(times[nxtPos][(time+1)%2]) continue;
                    times[nxtPos][(time+1)%2] = true;
                    queue.add(new int[]{nxtPos, time+1});
                }
            }
            ret++;
        }
        System.out.println(-1);
        return;
    }
}

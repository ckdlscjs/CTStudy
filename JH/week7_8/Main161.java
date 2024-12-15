import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
 

public class Main161{

    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];
        BFS(N, K);
    }

    static void BFS(int N, int K){
        
        Queue<Integer> que = new ArrayDeque<>();

        que.add(N);
        int[] Dist = new int[2000001];
        Arrays.fill(Dist, Dist.length);
        Dist[N] = 0;
        int[] parent = new int[200001];
        parent[N] = -1; //  

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i = 0;i<3;i++){
                int nx = 0;
                if(i<2) nx = cur + dx[i];
                else if(i==2) nx = cur * dx[i];
                
                if((0<= nx && nx <= 200000) && Dist[nx] > Dist[cur] + 1){
                    Dist[nx] = Dist[cur]+ 1;
                    // que.add(new int[]{ny, cur_dist+1})
                    que.add(nx);
                    parent[nx] = cur;
                }
            }
        }

        System.out.println((Dist[K]==Dist.length) ? -1 : Dist[K]);
        int cur = K;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        while(cur!=-1){
            st.addLast(cur);
            cur = parent[cur];
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pollLast()+ " ");
        }
        System.out.println(sb);
    }
}

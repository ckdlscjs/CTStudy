import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main163  {
    static int[] Dist = new int[1000001];
    static boolean[] chk = new boolean[1000001];

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] FSGUD = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(s->Integer.parseInt(s))
                            .toArray();

        int F = FSGUD[0];
        int S = FSGUD[1];
        int G = FSGUD[2];
        int U = FSGUD[3];
        int D = FSGUD[4];
        // 1 3 5 7 6 8 10 
        Arrays.fill(Dist, Dist.length);
        BFS(G, F,S,U,D);
        System.out.println( (Dist[G] == Dist.length) ? "use the stairs" : Dist[G]);
    }

    static void BFS(int G, int F, int S, int U, int D){

        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.addLast(S);
        chk[S] = true;
        Dist[S] = 0;
        int[] dx = {U,-D};
        while(!que.isEmpty()){
            int cur = que.pollFirst();
            // if(cur == G) return;
            
            for(int i = 0;i<2;i++){
                int ncur = cur + dx[i];
                if(isOutside(F, ncur)) continue;
                if(chk[ncur]) continue;

                if(Dist[ncur] > Dist[cur]+1){
                    chk[ncur] = true;
                    Dist[ncur] = Dist[cur]+1;
                    que.addLast(ncur);
                }
                // System.out.println(que.size());
                // 여기다가 if ncur == G => return 해도 무방함 BFS라서 
            }
        }
        // for(int i = 0;i<=F;i++){
        //     System.out.print(Dist[i] + " ");
        // }
        // System.out.println();
    }

    static boolean isOutside(int F, int cur){
        return (0>= cur || cur>F);
    }
}

package week13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem283 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        int[] countA = new int[101];
        int[] countB = new int[101];

        for(int round = 1; round <= N; round++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            countA[A]++;
            countB[B]++;

            int[] clondA = countA.clone();
            int[] clondB = countB.clone();
            int a_ptr = 1;
            int b_ptr = 100;
            int max_sum = 0;
            while(a_ptr<=100 && b_ptr>=1) {
                if(clondA[a_ptr]==0){
                    a_ptr++;
                    continue;
                }
                else if(clondB[b_ptr]==0){
                    b_ptr--;
                    continue;
                }

                max_sum = Math.max(max_sum, a_ptr+b_ptr);
                int remp = Math.min(clondA[a_ptr],clondB[b_ptr]);
                clondA[a_ptr] -= remp;
                clondB[b_ptr] -= remp;

                if (clondA[a_ptr] == 0) {
                    a_ptr++;
                }else if(clondB[b_ptr] == 0) {
                    b_ptr--;
                }else{
                    a_ptr++;
                    b_ptr--;
                }
            }
            // System.out.println(Arrays.toString(clondA));
            sb.append(max_sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}

 package week13;

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.StringTokenizer;

 public class Problem284 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[400_000 + 5];

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]++;
            arr[b]++;
        }

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a]++; arr[b]++;
        int diff = (K +Math.abs( (a % K) - (b % K))) % K;

        ArrayList<Integer> remainCards = new ArrayList<>();
        for(int i = 1;i<=4*N;i++){
            if (arr[i] == 0) {
                remainCards.add(i % K);
            }
        }

        Collections.sort(remainCards);

        int cnt = 0;
        int left = 0;
        int right = 1;
        int len = remainCards.size();

        while (right < len) {

            while (right + 1 < len && remainCards.get(right) - remainCards.get(left) <= diff) {
                right++;
            }
            if(right>=len || (remainCards.get(right)-remainCards.get(left)<=diff)) break;
            cnt++; left++; right++;
        }

        System.out.println(Math.min(cnt, M - 1));
    }
}

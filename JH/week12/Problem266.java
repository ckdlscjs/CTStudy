package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem266 {
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] chk = new boolean[4 * ((int) Math.pow(10, 6))];
    public static void main(String[] args)
    throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // sieve
        makeSive(N); // O(Nlog(log(N)) )


        int right = 0;
        int sum = 0;
        int cnt = 0;
        int len = primes.size();
        for (int left = 0; left < len; left++) {

            while (sum < N && right<len) {
                sum += primes.get(right++);
            }
            if (sum == N) {
                cnt++;
            }
            sum -= primes.get(left);
        }
        System.out.println(cnt);
    }

    private static void makeSive(int N) {
        int sqrtn = (int) Math.floor(Math.sqrt(N));
        Arrays.fill(chk, true);
        chk[0] = false;
        chk[1] = false;
        int bound = sqrtn * sqrtn;
        for (int i = 2; i <= sqrtn; i++) {
            if (chk[i]) { // i가 소수라면
                primes.add(i); // 소수 리스트에 추가
                for (int k = i * i; k <= N; k += i) { // i의 배수 제거
                    chk[k] = false;
                }
            }
        }
        for (int i = sqrtn + 1; i <= N; i++) {
            if (chk[i]) {
                primes.add(i);
            }
        }
        return;
    }
}
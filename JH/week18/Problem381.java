package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem381 {
    static HashMap<String, Long> guitarSong = new HashMap<>();
    static ArrayList<String> guitarSongList = new ArrayList<>();
    static int N;
    static int M;
    static int minGuitar;
    static int maxSongCnt = 0;
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minGuitar = N+1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            long count = StringToBinary(st.nextToken());
            guitarSong.put(s, count);
            guitarSongList.add(s);
        }


        for (int i = 0; i < N; i++) {
            DFS(i, (1 << i), guitarSong.get(guitarSongList.get(i)), 1);
        }

        System.out.println((maxSongCnt==(0))? -1 : minGuitar);
    }

    private static void DFS(int idx, int idxBit, Long songBits, int count) {

        int soungCount = Long.bitCount(songBits); // 현재 곡의 수
        if (soungCount>maxSongCnt) { // 현재 곡이 현재까지 곡의 개수보다 더 클 때 갱신
            maxSongCnt = soungCount;
            minGuitar = count;
        }
        else if (soungCount==maxSongCnt) {
            minGuitar = Math.min(minGuitar, count);
        }

        // if(count>=minGuitar) return;

        for (int j = idx+1; j < N; j++) {
            long nxt = guitarSong.get(guitarSongList.get(j));
            if (  (idxBit & (1 << j)) == 0){ // && (nxt & songBits)!= nxt) {
                if( (nxt & songBits) == nxt) {
                    DFS(j, idxBit | (1 << j), songBits | (nxt), count);
                }
                else{
                    DFS(j, idxBit | (1 << j), songBits | (nxt), count+1);
                }
            }
        }
    }

    // 0b11 => 2 + 1
    static long StringToBinary(String string) {
        long res = 0L;
        long temp = 1L;
        int len = string.length();
        for(int i = 0; i < M; i++) {
            char ch = string.charAt(i);
            if(ch == 'Y') {
                res += temp;
            }
            temp *= 2L;
        }
        return res;
    }
}

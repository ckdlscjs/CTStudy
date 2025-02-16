package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem377 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());


        int[] ips = new int[N];
        for (int i = 0; i < N; i++) {
            String[] str = (bf.readLine().trim()).split("\\.");
            ips[i] = convertToIp(str);
        }

        int MIN = ips[0];
        int MAX = ips[0];
        for(int i = 1; i < N; i++){
            int ipsNum = ips[i];
            if(ipsNum < MIN) MIN = ipsNum;
            if(ipsNum > MAX) MAX = ipsNum;
        }

        int diff = MIN ^ MAX;
        System.out.println(diff);
        int commonPrefix = (diff == 0) ? 32 : Integer.numberOfLeadingZeros(diff); // 리딩 zeros의 개수
        System.out.println(commonPrefix); // why? commonPrefix 삭제
        int mask = (commonPrefix == 0) ? 0 : (0xFFFFFFFF << (32 - commonPrefix));
        System.out.println(mask);
        int networkAddress = MIN & mask;
        System.out.println(convertToString(networkAddress));
        System.out.println(convertToString(mask));

    }

    private static int convertToIp(String[] str) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res << 8) | Integer.parseInt(str[i]);
        }
        return res;
    }

    private static String convertToString(int ip) {
        return String.format("%d.%d.%d.%d",
                (ip >> 24) & 0xFF,
                (ip >> 16) & 0xFF,
                (ip >> 8) & 0xFF,
                ip & 0xFF);
    }

}
//
//
//package week18;
//import java.util.Scanner;
//
//public class Problem377 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 1) 네트워크 주소와 마스크 입력
//        String networkAddressStr = sc.nextLine().trim(); // 예) 194.85.160.176
//        String netmaskStr       = sc.nextLine().trim(); // 예) 255.255.255.248
//
//        // 2) 문자열 → 32비트 정수 변환
//        int netAddr = ipToInt(networkAddressStr);
//        int mask    = ipToInt(netmaskStr);
//
//        // 3) 브로드캐스트 주소 계산
//        //   ~mask → 마스크 비트 반전 (네트워크 부분 0, 호스트 부분 1)
//        //   netAddr | ~mask → 해당 네트워크에서 호스트 비트를 전부 1로 만든 값
//        int broadcastAddr = netAddr | ~mask;
//
//        // 4) 범위(netAddr부터 broadcastAddr까지) 출력
//        //    실제 환경에서는 netAddr(네트워크 주소)와 broadcastAddr(브로드캐스트 주소)는
//        //    호스트 IP로 안 쓰지만, 예시에서는 모두 출력해 봄
//        for (int ip = netAddr; ip <= broadcastAddr; ip++) {
//            System.out.println(intToIp(ip));
//        }
//
//        sc.close();
//    }
//
//    // "a.b.c.d" → 32비트 정수로 변환
//    private static int ipToInt(String ipStr) {
//        String[] parts = ipStr.split("\\.");
//        int result = 0;
//        for (int i = 0; i < 4; i++) {
//            result = (result << 8) | Integer.parseInt(parts[i]);
//        }
//        return result;
//    }
//
//    // 32비트 정수 → "a.b.c.d" 문자열로 변환
//    private static String intToIp(int ip) {
//        return String.format("%d.%d.%d.%d",
//                (ip >>> 24) & 0xFF,
//                (ip >>> 16) & 0xFF,
//                (ip >>>  8) & 0xFF,
//                ip         & 0xFF);
//    }
//}

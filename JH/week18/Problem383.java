//package week18;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class Problem383 {
//    static HashMap<String, Integer> map = new HashMap<>();
//    public static void main(String[] args)
//    throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s = bf.readLine();
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            String cur = String.valueOf(s.charAt(i));
//            if (map.putIfAbsent(cur, null) == null) {
//                map.put(cur, 1);
//            }
//            for (int j = i + 1; j < len; j++) {
//                cur = cur + s.charAt(j);
//                if (map.putIfAbsent(cur, null) == null) {
//                    map.put(cur, 1);
//                }
//            }
//        }
//
//        int ret = 0;
//        for(String key : map.keySet()) {
//            ret += map.get(key);
//        }
//        System.out.println(ret);
//    }
//}


package week18;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem383 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int len = s.length();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(s.charAt(j)); // String 대신 StringBuilder 사용
                set.add(sb.toString()); // HashSet으로 중복 제거
            }
        }

        System.out.println(set.size());
    }
}


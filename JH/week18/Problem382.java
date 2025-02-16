package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem382 {
    static HashMap<String, ArrayList<String>> groupMap = new HashMap<>();
    static HashMap<String, String> memberGroup = new HashMap<>();

    public static void main(String[] args)
            throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String groupName = bf.readLine();
            if(groupMap.containsKey(groupName)) {
                continue;
            }else{
                groupMap.put(groupName, new ArrayList<>());
            }
            int groupSize = Integer.parseInt(bf.readLine());
            for (int s = 0; s < groupSize; s++) {
                String groupMember = bf.readLine();
                groupMap.get(groupName).add(groupMember);
                memberGroup.put(groupMember, groupName);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int query = 0; query < M; query++) {
            String name = bf.readLine();
            int q = Integer.parseInt(bf.readLine());
            if (q == 0) {
                Collections.sort(groupMap.get(name));
                for (String s : groupMap.get(name)) {
                    sb.append(s).append('\n');
                }
            }else{
                sb.append(memberGroup.get(name)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

}

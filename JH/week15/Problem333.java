package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem333 {

    static class TrieNode{
        TrieNode[] children;

        TrieNode(){
            children = new TrieNode[26];
        }
    }

    static TrieNode root = new TrieNode();
    static Map<String, Integer> nameCount = new HashMap<>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String nickName = br.readLine();
            nameCount.put(nickName, nameCount.getOrDefault(nickName, 0) + 1);

            String prefix = insertGetNewPrefix(nickName);

            if (prefix == null) {
                int count = nameCount.get(nickName);
                if (count == 1) {
                    sb.append(nickName).append('\n');
                }else{
                    sb.append(nickName).append(count).append('\n');
                }
            }else{
                sb.append(prefix).append('\n');
            }
        }
        System.out.println(sb);

    }

    private static String insertGetNewPrefix(String nickName) {
        TrieNode cur = root;
        boolean foundNewNode = false;
        int newIdx = -1;

        for (int i = 0; i < nickName.length(); i++) {
            int c = nickName.charAt(i) - 'a';
            if(cur.children[c] == null) {
                cur.children[c] = new TrieNode();
                if(!foundNewNode) {
                    foundNewNode = true;
                    newIdx = i;
                }
            }
            cur = cur.children[c];
        }

        if(foundNewNode) {
            return nickName.substring(0, newIdx + 1);
        }else{
            return null;
        }
    }
}

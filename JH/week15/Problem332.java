package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem332 {

    static class TrieNode{
        Map<String, TrieNode> children = new HashMap<>();
    }

    static class Trie{
        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        void insert(String[] path){
            TrieNode cur = root;
            for(String s : path){
                cur.children.putIfAbsent(s, new TrieNode());
                cur = cur.children.get(s);
            }
        }

        void print(TrieNode root, int depth) {
            List<String> sortedKeys = new ArrayList<>(root.children.keySet());
            Collections.sort(sortedKeys);
            for (String key : sortedKeys) {
                sb.append("--".repeat(depth)).append(key).append('\n');
                print(root.children.get(key), depth + 1);
            }
        }

        void print(){
            print(this.root, 0);
            System.out.print(sb);
        }
    }

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Trie trie = new Trie();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] path = new String[k];
            for(int j = 0; j < k; j++){
                path[j] = st.nextToken();
            }
            trie.insert(path);
        }
        trie.print();

    }
}

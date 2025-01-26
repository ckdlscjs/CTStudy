package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem331 {

    static StringBuilder sb = new StringBuilder();

    static class TrieNode{
        Map<String, TrieNode> children = new HashMap<>();
    }

    static class Trie{
        TrieNode root = new TrieNode();

        void insert(String word){
            String[] words = word.split("\\\\");
            TrieNode cur = root;
            for (String dir : words) {
                cur.children.putIfAbsent(dir, new TrieNode());
                cur = cur.children.get(dir);
            }
        }

        void print(TrieNode node, int depth){
            List<String> sortedKeys = new ArrayList<>(node.children.keySet());
            Collections.sort(sortedKeys);
            for(String dir : sortedKeys){
                sb.append(" ".repeat(depth) + dir).append('\n');
                print(node.children.get(dir), depth + 1);
            }
        }

        void print(){
            print(root, 0);
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            trie.insert(s);
        }
        trie.print();
    }
}

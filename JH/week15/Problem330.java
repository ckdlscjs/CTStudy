package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem330 {

    static class Trie{
        static class TrieNode{
            TrieNode[] next = new TrieNode[10];
            boolean isEndOfWord = false;
        }

        private final TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode current = root;
            for(char c : word.toCharArray()){
                int index = (c - '0');
                // System.out.println(index);
                if(current.next[index] == null){
                    current.next[index] = new TrieNode();
                }
                current = current.next[index];
            }
            current.isEndOfWord = true;
            return;
        }

        public boolean startsWith(String word){
            TrieNode current = root;
            for(char c : word.toCharArray()){
                int index = (c - '0');

                // 다른 단어가 현재 단어가 끝나기도 전에 이미 끝남을 체크할 수 있으면 접두사임을 알 수 있음
                if(current.isEndOfWord){
                    return false;
                }

                if(current.next[index] == null){
                    return true;
                }
                current = current.next[index];
            }

            for (int i = 0; i < 10; i++) {
                if(current.next[i] != null){
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            Trie t = new Trie();
            int n = Integer.parseInt(bf.readLine());
            ArrayList<String> stores = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String tmp = bf.readLine();
                t.insert(tmp);
                stores.add(tmp);
            }

            stores.sort((a, b) -> Integer.compare(b.length(), a.length()));
            // System.out.println(stores);

            boolean flag = false;
            for (String name : stores) {

                if (!t.startsWith(name)) {
                    flag = true;
                    break;
                }
                t.insert(name);
            }

            System.out.println((flag) ? "NO" : "YES");
        }
    }
}
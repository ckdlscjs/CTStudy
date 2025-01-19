package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem325 {

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void preorder(int x) {

        sb.append((char) (x + 'A'));
        for (int i : adjList.get(x)) {
            if(i!=-1) preorder(i);
        }
    }


    static void inorder(int x) {

        if (adjList.get(x).get(0) != -1) inorder(adjList.get(x).get(0));
        sb.append((char) (x + 'A'));
        if (adjList.get(x).get(1) != -1) inorder(adjList.get(x).get(1));
    }

    static void postorder(int x) {

        for (int i : adjList.get(x)) {
            if(i!=-1) postorder(i);
        }
        sb.append((char) (x + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(-1);
            list.add(-1);
            adjList.add(list);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            char b = st.nextToken().charAt(0);
            if (b != '.') {
                adjList.get(a).set(0, b - 'A');
            }
            char c = st.nextToken().charAt(0);
            if (c != '.') {
                adjList.get(a).set(1, c - 'A');
            }
        }


        visited = new boolean[26];
        preorder(0);
        sb.append("\n");

        visited = new boolean[26];
        inorder(0);
        sb.append("\n");

        visited = new boolean[26];
        postorder(0);
        sb.append("\n");

        System.out.print(sb.toString());
    }
}

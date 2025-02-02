package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem343 {
    static class Problem implements Comparable<Problem> {
        int num;
        int level;
        int group;

        Problem(int num, int level, int group) {
            this.num = num;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level != o.level) return Integer.compare(this.level, o.level);
            return Integer.compare(this.num, o.num);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Problem)) return false;
            Problem other = (Problem) obj;
            return this.num == other.num && this.level == other.level && this.group == other.group;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(num);
        }
    }

    static TreeSet<Problem> allProblems = new TreeSet<Problem>();
    static Map<Integer, TreeSet<Problem>> groupMap = new TreeMap<Integer, TreeSet<Problem>>();
    static TreeMap<Integer, TreeSet<Integer>> levelMap = new TreeMap<>();
    static Map<Integer, Problem> problemMap = new TreeMap<Integer, Problem>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]);
            int level = Integer.parseInt(str[1]);
            int group = Integer.parseInt(str[2]);
            add(num, level, group);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int j = 0;j<m;j++){
            String[] str = br.readLine().split(" ");
            if (str[0].equals("add")) {
                int num = Integer.parseInt(str[1]);
                int level = Integer.parseInt(str[2]);
                int group = Integer.parseInt(str[3]);
                add(num, level, group);
            } else if (str[0].equals("recommend")) {
                int G = Integer.parseInt(str[1]);
                int x = Integer.parseInt(str[2]);
                sb.append(recommend1(G, x)).append('\n');
            } else if (str[0].equals("recommend2")) {
                int x = Integer.parseInt(str[1]);
                sb.append(recommend2(x)).append('\n');
            } else if (str[0].equals("recommend3")) {
                int x = Integer.parseInt(str[1]);
                int L = Integer.parseInt(str[2]);
                sb.append(recommend3(x, L)).append('\n');
            } else if (str[0].equals("solved")) {
                int P = Integer.parseInt(str[1]);
                solved(P);
            }
        }
        System.out.println(sb.toString());
    }

    private static void add(int num, int level, int group) {
         Problem problem = new Problem(num, level, group);
         allProblems.add(problem);
         problemMap.put(num, problem);

         // group Map
        groupMap.putIfAbsent(group, new TreeSet<>());
        groupMap.get(group).add(problem);

        // levelMap
        levelMap.putIfAbsent(level, new TreeSet<>());
        levelMap.get(level).add(num);
    }


    static void solved(int P){
        Problem problem = problemMap.get(P);
        if (problem != null) {
            allProblems.remove(problem);

            TreeSet<Problem> groupSet = groupMap.get(problem.group);
            if(groupSet != null){
                groupSet.remove(problem);
                if(groupSet.isEmpty()){
                    groupMap.remove(problem.group);
                }
            }

            TreeSet<Integer> levelSet = levelMap.get(problem.level);
            if(levelSet != null){
                levelSet.remove(P);
                if(levelSet.isEmpty()){
                    levelMap.remove(problem.level);
                }
            }

            problemMap.remove(P);
        }
    }

    static int recommend1(int G, int x){
        TreeSet<Problem> groupSet = groupMap.get(G);
        if(groupSet == null || groupSet.isEmpty()){ return -1;}

        if (x == 1) {
            Problem last = groupSet.last();
            return last.num;
        }else{
            Problem first = groupSet.first();
            return first.num;
        }
    }

    static int recommend2(int x){

        if(allProblems.isEmpty()) return -1;

        if (x == 1) {
            Problem last = allProblems.last();
            return last.num;
        }else{
            Problem first = allProblems.first();
            return first.num;
        }
    }

    static int recommend3(int x, int L){
        if (x == 1) {
            Map.Entry<Integer, TreeSet<Integer>> entry = levelMap.ceilingEntry(L);
            if(entry==null) return -1;
            return entry.getValue().first();
        }else{
            Map.Entry<Integer, TreeSet<Integer>> entry = levelMap.lowerEntry(L);
            if(entry==null) return -1;
            return entry.getValue().last();
        }
    }



}

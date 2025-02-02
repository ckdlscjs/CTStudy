package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class Problem339 {
    // static HashMap<Integer, Integer> MAX = new HashMap<>();
    static TreeSet<Integer> tree = new TreeSet<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(bf.readLine());
            for (int i = 0;i<n;i++){
                String[] str = bf.readLine().split(" ");
                if (str[0].equals("I")) {
                    int num = Integer.parseInt(str[1]);
                    tree.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else{ // D delete
                    if (str[1].equals("1")) {
                        while (!tree.isEmpty() && map.getOrDefault(tree.last(), 0) == 0) {
                            int last = tree.last();
                            map.remove(last);
                            tree.remove(last);
                        }

                        if (!tree.isEmpty()) {
                            int num = tree.last();
                            if (map.get(num) >= 1) {
                                map.put(num, map.get(num) - 1);
                                if(map.get(num) == 0){
                                    tree.remove(num);
                                    map.remove(num);
                                }
                            }
                        }
                    }else{ // -1

                        while (!tree.isEmpty() && map.getOrDefault(tree.first(), 0) == 0) {
                            int num = tree.first();
                            map.remove(num);
                            tree.remove(num);
                        }

                        if (!tree.isEmpty()) {
                            int num = tree.first();
                            map.put(num, map.get(num) - 1);
                            if(map.get(num) == 0){
                                tree.remove(num);
                                map.remove(num);
                            }
                        }
                    }
                }
            }
            if(tree.isEmpty()){
                sb.append("EMPTY\n");
            }else{
                sb.append(tree.last()).append(" ").append(tree.first()).append('\n');
            }

            tree.clear();
            map.clear();
        }
        System.out.println(sb);
    }
}

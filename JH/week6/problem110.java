import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class problem110{
    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0;i<N;i++){
            String tmp = bf.readLine();
            tmp.trim();
            ArrayDeque<Character> L = new ArrayDeque<>();
            ArrayDeque<Character> R = new ArrayDeque<>();

            for(char c : tmp.toCharArray()){
                if(c=='<'){if(L.isEmpty()) continue;
                    R.addFirst(L.pollLast());
                }
                else if(c=='>'){if(R.isEmpty()) continue;
                    L.addLast(R.pollFirst());
                }
                else{
                    if(c=='-'){
                        if(L.isEmpty()) continue;
                        L.pollLast();
                        continue;
                    }
                    L.addLast(c);
                }
            }


            String res1 = L.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(""));
            
            String res2 = R.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(""));
            StringBuilder sb = new StringBuilder();
            sb.append(res1);
            sb.append(res2);
            System.out.println(sb);
        }
    }
 
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem127{
    public static void main(String[] args) 
    throws  IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String tmp = bf.readLine();
            if(tmp.length()==1 && tmp.charAt(0) == '.') break;

            ArrayDeque<Character> deq = new ArrayDeque<>();
            boolean flag = false;
            for(char c : tmp.toCharArray()){
                if(c=='(' || c=='['){
                    deq.addLast(c);
                }else{

                    if(c==')'){
                        if(!deq.isEmpty()){
                            if(deq.peekLast() == '('){
                                deq.pollLast();
                            }else{
                                flag = true;
                                break;
                            }
                        }else{
                            flag = true;
                            break;
                        }
                    }
                    else if(c==']'){
                        if(!deq.isEmpty()){
                            if(deq.peekLast() == '['){
                                deq.pollLast();
                            }else{ // '('
                                flag = true;
                                break;
                            }
                            
                        }else{
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if(flag || !deq.isEmpty()){
                sb.append("no\n");
            }else{
                sb.append("yes\n");
            }
        }
        System.out.print(sb);
    }
}

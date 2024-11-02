import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class problem118 { 

    static class Pair{
        int val;
        int cnt;
        Pair(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
        @Override
        public String toString(){
            return val + " " + cnt;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        ArrayDeque<Pair> st = new ArrayDeque<>();

        long cnt = 0;
        for(int i = 0;i<N;i++){
            int tmp = Integer.parseInt(bf.readLine());
            
            if(st.isEmpty()){
                st.addLast(new Pair(tmp, 1));
            }else{
                if(tmp == st.peekLast().val){
                    Pair cur = st.pollLast();
                    cnt += cur.cnt; // ㅁ ... ㅁ 
                    cur.cnt++;
                    if(!st.isEmpty()){
                        cnt += 1; // a ㅁㅁㅁㅁ b
                    }
                    st.add(cur);
                }
                else{
                    if(tmp > st.peekLast().val){
                        while(!st.isEmpty() && st.peekLast().val < tmp){
                            Pair cur = st.pollLast();
                            cnt += (cur.cnt);
                        }
                        boolean flag = false;
                        if(!st.isEmpty()){
                            if(tmp == st.peekLast().val){
                                Pair cur = st.pollLast();
                                cnt += cur.cnt;
                                cur.cnt++;
                                if(!st.isEmpty()){
                                    cnt += 1;//cur.cnt; // a ㅁㅁㅁㅁ b
                                }
                                st.add(cur);
                                flag = true;
                            }else{ // tmp < st.peek
                                cnt++;
                            }
                        }
                        if(!flag) st.addLast(new Pair(tmp, 1));

                    }else{ // st.peekLast().val  < tmp 
                        st.addLast(new Pair(tmp, 1));
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}
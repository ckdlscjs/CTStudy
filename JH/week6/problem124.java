import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class problem124  {

    static ArrayDeque<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nums[0];
        int K = nums[1];
        
        for(int i = 1;i<=N;i++){
            que.addLast(i);
        }
        
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] numbers = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ret = 0;

        for(int i=0;i<K;i++){
            int data = numbers[i];
            int L = Left(data);
            int R = Right(data);
            // System.out.println(L + " " + R);
            if(L==R){
                ret += L;
                for(int j = 0;j<L;j++){
                    que.addLast(que.pollFirst());// leftRotate();
                }
            }else if(L>R){
                ret += R;
                for(int j = 0;j<R;j++){
                    que.addFirst(que.pollLast());
                }
            }else{ // 
                ret += L;
                for(int j = 0;j<L;j++){
                    que.addLast(que.pollFirst());// leftRotate();
                }
            }
            que.pop();
        }
        System.out.println(ret);
    }

    static int Left(int data){
        int cnt = 0;
        Iterator<Integer> pt = que.iterator();
        for(int i = 0;i<que.size();i++){
            int nxt = pt.next();
            // System.out.println("Left " + nxt);
            if(nxt == data){
                break;
            }
            cnt++;
        }
        return cnt; 
    }

    static int Right(int data){
        int cnt = 0;
        Iterator<Integer> pt = que.descendingIterator();

        for(int i = que.size()-1;i>=0;i--){
            int tmp = pt.next();
            // System.out.println("right : " + tmp);
            if(tmp == data){
                cnt++;
                break;
            }
            cnt++;
        }
        return cnt;
    }

    static void popFirst(){
        que.pollFirst();
    }

}
 

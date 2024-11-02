import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem120 {

    static class Queue{

        Node head;
        Node tail;
        private int cnt = 0;
        static class Node{
            int data;
            Node prev;
            Node nxt;
            Node(int data){
                this.data = data;
            }
        }

        Queue() {
            this.head = new Node(-1);
            this.tail = new Node(-1);
            this.head.nxt = this.tail;
            this.tail.prev = this.head;
        }

        void addFirst(int data){
            this.cnt++;
            Node nxt = new Node(data);
            nxt.prev = this.head;
            nxt.nxt = this.head.nxt;
            this.head.nxt.prev = nxt;
            this.head.nxt = nxt;
        }

        int pop(){
            if(this.cnt==0){
                return -1;
            }
            this.cnt--;
            int ret = this.tail.prev.data;
            this.tail.prev.prev.nxt = this.tail;
            this.tail.prev = this.tail.prev.prev;
            return ret;
        }
        
        int size(){
            return this.cnt;
        }

        int empty(){
            return (cnt==0)? 1 : 0;
        }

        int front(){
            if(this.cnt == 0){
                return  -1;
            }
            return this.tail.prev.data;
        }

        int back(){
            if(this.cnt == 0){
                return  -1;
            }
            return this.head.nxt.data;
        }

    }

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        Queue que = new Queue();

        for(int i = 0;i<N;i++){
            String[] ords = bf.readLine().split(" ");
            if(ords.length==2){
                int M = Integer.parseInt(ords[1]);
                que.addFirst(M);
            }else{
                if(ords[0].equals("pop")){
                    // System.out.println(que.pop());
                    sb.append(que.pop() + "\n");
                }
                else if(ords[0].equals("size")){
                    // System.out.println(que.size());
                    sb.append(que.size() + "\n");
                }
                else if(ords[0].equals("empty")){
                    // System.out.println(que.empty());
                    sb.append(que.empty() + "\n");
                }
                else if(ords[0].equals("front")){
                    // System.out.println(que.front());
                    sb.append(que.front() + "\n");
                }
                else if(ords[0].equals("back")){
                    // System.out.println(que.back());
                    sb.append(que.back() + "\n");
                }
            }
        }

        System.out.print(sb);
    }
}

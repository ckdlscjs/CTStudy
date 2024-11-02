
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem123{

    static class Deque{

        Node head;
        Node tail;
        int cnt;

        static class Node{
            int data; // T?
            Node prev;
            Node nxt;

            Node(int data){
                this.data = data;
            }
        }

        Deque(){
            this.head = new Node(-1);
            this.tail = new Node(-1);
            this.head.nxt = this.tail;
            this.tail.prev = this.head;
        }

        void push_front(int data){
            Node tmp = new Node(data);
            tmp.prev = this.head;
            tmp.nxt = this.head.nxt;
            this.head.nxt.prev = tmp;
            this.head.nxt = tmp;
            cnt++;
        }

        void push_back(int data){
            Node tmp = new Node(data);
            tmp.prev = this.tail.prev;
            tmp.nxt = this.tail;
            this.tail.prev.nxt = tmp;
            this.tail.prev = tmp;
            cnt++;
        }

        int pop_front(){
            if(this.cnt==0){
                return -1;
            }
            int ret = this.head.nxt.data;
            this.head.nxt.nxt.prev = this.head;
            this.head.nxt = this.head.nxt.nxt;
            cnt--;
            return ret;
        }

        int pop_back(){
            if(this.cnt == 0){
                return -1;
            }
            int ret = this.tail.prev.data;
            this.tail.prev.prev.nxt = this.tail;
            this.tail.prev = this.tail.prev.prev;
            cnt--;
            return ret;
        }

        int size(){
            return this.cnt;
        }

        int front(){
            if(this.cnt == 0) return -1;
            return this.head.nxt.data;
        }

        int back(){
            if(this.cnt == 0) return -1;
            return this.tail.prev.data;
        }
        int empty(){
            return (this.cnt==0) ? 1 : 0;
        }
    }

    public static void main(String[] args) 
    throws IOException{
        Deque deq = new Deque();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();


        for(int i = 0;i<N;i++){ 
            String[] ords = bf.readLine().split(" ");
            if(ords.length == 2){
                int K = Integer.parseInt(ords[1]);
                if(ords[0].equals("push_back")){
                    deq.push_back(K);
                }   
                else { // push_front 
                    deq.push_front(K);
                }
            }else{
                String ord = ords[0];
                if(ord.equals("size")){
                    sb.append(deq.size()+"\n");
                }
                else if(ord.equals("empty")){
                    sb.append(deq.empty()+"\n");
                }
                else if(ord.equals("pop_front")){
                    sb.append(deq.pop_front()+"\n");
                }
                else if(ord.equals("pop_back")){
                    sb.append(deq.pop_back()+"\n");
                }
                else if(ord.equals("front")){
                    sb.append(deq.front()+"\n");
                }
                else if(ord.equals("back")){
                    sb.append(deq.back()+"\n");
                }
            }
        }
        System.out.print(sb);
    }
}
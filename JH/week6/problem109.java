
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem109{

    static class  Node{
        char data;
        Node next;
        Node prev; 

        Node(char data){
            this.data = data;
        }

        Node(char data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    
    static class Editor {
        Node cursor;
        Node head;
        Node tail;

    public Editor(String initialData) {
        Node dummyHead = new Node('1');
        Node dummyTail = new Node('1');
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        cursor = dummyTail;
        head = dummyHead;
        tail = dummyTail;

        for (char c : initialData.toCharArray()) {
            Node newNode = new Node(c);
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }
        cursor = tail;
    }

    public void moveCursorLeft() {
        if (cursor.prev != head) {
            cursor = cursor.prev;
        }
    }

    public void moveCursorRight() {
        if (cursor != tail) {
            cursor = cursor.next;
        }
    }

    public void backspace() {
        if (cursor.prev != head) {
            Node toRemove = cursor.prev;
            toRemove.prev.next = cursor;
            cursor.prev = toRemove.prev;
        }
    }

    public void insertChar(char c) {
        Node newNode = new Node(c);
        newNode.prev = cursor.prev;
        newNode.next = cursor;
        cursor.prev.next = newNode;
        cursor.prev = newNode;
        
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Node current = head.next;
        while (current != tail) {
            sb.append(current.data);
            current = current.next;
        }
        return sb.toString();
    }
}

    public static void main(String[] args) 
    throws  IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String aa = bf.readLine(); 
        Editor edit = new Editor(aa);
        int K = Integer.parseInt(bf.readLine());
        
        for(int i = 0;i<K;i++){
            String[] ords = bf.readLine().split(" ");
            if(ords.length>1){
                edit.insertChar(ords[1].charAt(0));
            }else{
                if(ords[0].charAt(0) == 'L'){
                    edit.moveCursorLeft();
                }
                else if(ords[0].charAt(0) == 'D'){
                    edit.moveCursorRight();
                }
                else{
                    edit.backspace();
                }
            }
        }
        System.out.println(edit.getText());
    }
}







// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.stream.Collectors;


// public class problem109{

//     static int cursor = 0;
//     public static void main(String[] args) 
//     throws IOException{
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         String ords = bf.readLine();
//         LinkedList<Character> lst = new LinkedList<>();

//         for(char c : ords.toCharArray()){
//             lst.add(c);
//             cursor++;
//         }
//         int M = Integer.parseInt(bf.readLine());

//         for(int i = 0;i<M;i++){
//             String[] ord = bf.readLine().split(" ");
//             if(ord.length==1){
//                 String order = ord[0];
//                 if(order.equals("D")){
//                     if(cursor< lst.size()){
//                         cursor++;
//                     }
//                 }
//                 else if(order.equals("L")){
//                     if(cursor>0){
//                         cursor--;
//                     }
//                 }
//                 else if(order.equals("B")){
//                     if(!lst.isEmpty() && cursor>0){
//                         lst.remove(cursor-1);
//                         cursor--;
//                     }
//                 }
//             }else{ // length == 2
//                 if(lst.isEmpty()){
//                     lst.add(ord[1].charAt(0));    
//                 }else{
//                     lst.add(cursor,(ord[1].charAt(0)));
//                 }
//                 cursor++;
//             }
//         }   

//         String res = lst.stream()
//                         .map(s->s.toString())
//                         .collect(Collectors.joining(""));
//         System.out.println(res);
//     }
// }
// // stack 1개, queue 1개로 끝내야겠다 

// // [ ...  ]-> 
// //           <-[..... ]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;



public class problem111 {

    public static class CircularLinkedList<T> extends LinkedList<T>{

        @Override
        public ListIterator<T> listIterator(int index) {
            return new CircularListIterator(index);
        }
        public class CircularListIterator implements ListIterator<T>{
            private int cursor;
    
            public CircularListIterator(int index) {  // 생성자 이름 수정
                if(size()==0) return;
                this.cursor = index % size();         // `thi.cursor` 오타 수정
            }
    
            @Override 
            public boolean hasNext(){
                return !isEmpty();
            }
    
            @Override
            public T next(){
                T element = get(cursor);
                cursor = (cursor + 1) % size();
                return element;
            }
    
            @Override
            public T previous(){
                if(size()==0) return null;
                cursor = (cursor - 1 + size())  % size();
                return get(cursor);
            }
    
            @Override
            public int nextIndex(){
                if(size()==0) return -1;
                return (cursor + 1) % size();
            }
    
            @Override
            public int previousIndex(){
                if(size()==0) return -1;
                return (cursor - 1 + size()) % size();
            }
    
            public void remove(int index){
                if(size() == 0 || index >= size()) return;
                CircularLinkedList.this.remove(index);
                if(size()==0) return;
                cursor = cursor % size();
            }

            @Override
            public void remove(){
                if(size()==0) return;
                CircularLinkedList.this.remove();
                if (size() > 0) cursor %= size();
            }
    
            @Override
            public void set(T t) {
                CircularLinkedList.this.set(cursor, t);
            }
    
            @Override
            public void add(T t) {
                CircularLinkedList.this.add(cursor, t);
                cursor = (cursor + 1) % size();
            }

            @Override
            public boolean hasPrevious() {
                // TODO Auto-generated method stub
               return (size()>0);
            }

            /**
             * @return current element 
             */
            public T current(){
                return get(cursor);
            }

            public T getElement(int index) {
                if (isEmpty()) {
                    throw new IndexOutOfBoundsException("리스트가 비어 있습니다.");
                }
                return get(index); // 해당 인덱스의 요소 반환
            }
        }
    }

    public static void main(String[] args) 
    throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(bf.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        CircularLinkedList<Integer> lst = new CircularLinkedList<>();
        for(int i = 1;i<=NK[0];i++){
            lst.add(i);
        }

        CircularLinkedList<Integer>.CircularListIterator iterator = (CircularLinkedList<Integer>.CircularListIterator) lst.listIterator();


        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int K = NK[1];

        int startIndex = 0;
        for(int i = 0;i<NK[0];i++){
            int removeIndex = (startIndex + K - 1) % lst.size();
            sb.append(iterator.getElement(removeIndex));
            iterator.remove(removeIndex % lst.size());
            sb.append(",");
            if(lst.size()==0) {
                break;
            }
            startIndex = removeIndex % lst.size(); // 1 2 4 5 -> 1 2  5  
        }


        String ret = Arrays.stream(sb.toString().split(","))
                            .collect(Collectors.joining(", "));

        System.out.println(String.join(", ", ret) + ">");
        // NK <= 25 000 000

    }
}
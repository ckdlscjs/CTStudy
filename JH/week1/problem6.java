package week1;

 
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;


class Node{
    int code;
    int date;
    int maximum;
    int remain;

    Node(int code, int date, int maximum, int remain){
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }


    public static Comparator<Node> byCode(){
        return Comparator.comparingInt(o-> o.code);
    }

    public static Comparator<Node> byDate(){
        return Comparator.comparingInt(o -> o.date);
    }
    
    public static Comparator<Node> byMaximum(){
        return (Node o1, Node o2) -> Integer.compare(o1.maximum, o2.maximum);
    }
    
    public static Comparator<Node> byRemain(){
        return (Node o1, Node o2) -> Integer.compare(o1.remain, o2.remain);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return code + " " + date + " " + maximum + " " + remain;
    }
}

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
         

            LinkedList<Node> nn = new LinkedList<>();

        // 입력 데이터를 Node로 변환하여 LinkedList에 저장
        for (int[] d : data) {
            Node tmp = new Node(d[0], d[1], d[2], d[3]);
            nn.add(tmp);
        }


        // LinkedList에서 조건에 맞지 않는 Node 필터링 (날짜 >= pivot)

        switch (ext) {
            case "code":
                nn.removeIf(node -> node.code >= val_ext);
                break;
            case "date":
                nn.removeIf(node -> node.date >= val_ext);
                break;
            case "maximum":
                nn.removeIf(node -> node.maximum >= val_ext);
                break;
            case "remain":
                nn.removeIf(node -> node.remain >= val_ext);
                break;
        }
        
      
        // 정렬 조건에 따른 정렬 수행
        switch (sort_by) {
            case "code":
                Collections.sort(nn, Node.byCode());
                break;
            case "date":
                Collections.sort(nn, Node.byDate());
                break;
            case "maximum":
                Collections.sort(nn, Node.byMaximum());
                break;
            case "remain":
                Collections.sort(nn, Node.byRemain());
                break;
        }
        
        
        int[][] answer = new int[nn.size()][4];

        for(int i = 0;i<nn.size();i++){
            for(int j = 0;j<4;j++){
                if (j==0){
                    answer[i][j] =  nn.get(i).code;
                }
                else if (j==1){
                    answer[i][j] =  nn.get(i).date;
                }
                else if (j==2){
                    answer[i][j] =  nn.get(i).maximum;
                }else{
                    answer[i][j] =  nn.get(i).remain;
                }
            }
        }

        return answer;
    }
}

public class problem6 {
    public static void main(String[] args) {
        
    }
}

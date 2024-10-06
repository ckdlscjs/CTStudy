// package week1;
import  java.util.ArrayList;

public  class test{

    public static void main(String[] args){
        ArrayList<Integer> L = new ArrayList<>();
        for(int i = 0;i<5;i++){
            L.add(i);
        }
        System.out.println((L));
        while(!L.isEmpty()){
            L.remove(0);
            System.out.println(L);
            System.out.println(L.get(3));
        }
    }
}
package week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem384 {
    public static void main(String[] args)
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] times = bf.readLine().split(" ");
        int startTime = timeToInt(times[0]);
        int endTime = timeToInt(times[1]);
        int exitTime = timeToInt(times[2]);

        String s;
        HashMap<String,Boolean> join = new HashMap<>();
        HashMap<String,Boolean> exit = new HashMap<>();

        while( bf.ready() && (s = bf.readLine()) != null){
            String[] timeName = s.split(" ");
            int time = timeToInt(timeName[0]);
            String name = timeName[1];
            if(startTime >= time){
                join.put(name,true);
            }
            if(endTime<=time && time<=exitTime){
                exit.put(name,true);
            }
        }

        int ret = 0;
        for(String key : join.keySet()){
            if (exit.containsKey(key)) {
                ret += 1;
            }
        }
        System.out.println(ret);

    }

    private static int timeToInt(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return hour * 60 + minute;
    }
}

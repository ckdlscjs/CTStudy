import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem443 {
    public static void main(String[] args) 
    throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int currentMinute = (60 * a + b);
        int assumedMinute = (1440 + currentMinute-45)% 1440;
        int hour = (assumedMinute / 60);
        int minute = assumedMinute % 60;
        System.out.println(hour + " " + minute);
        // 30 -> 23:45
        // 
    }
}

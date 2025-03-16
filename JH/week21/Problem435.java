    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Problem435 {
        public static void main(String[] args) 
        throws Exception{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            String input = "";
            while( (input = bf.readLine())!=null){
                st = new StringTokenizer(input);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(a+b).append('\n');
            } 
            System.out.print(sb);
        }
    }

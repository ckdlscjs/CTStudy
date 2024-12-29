public class Problem51 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0;i<n;i++){
            answer[i]  = "";
        }

        // Object o = n;
        // System.out.println(n + " is of type " + o.getClass().getSimpleName());
        
        for(int i = 0;i<n;i++){
            
            String a = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String b = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            String ret = "";
            for(int j = 0;j<a.length();j++){
                int tmp = char_or(a.charAt(i), b.charAt(i));
                if(tmp >= 1){
                    System.out.println(tmp);
                    ret+="#";
                }else{
                    ret+=" ";
                }
                // ret += (char) (tmp + 48);
            }
            answer[i] = ret;
        }
        System.out.println(char_or('1', '1'));
        return answer;
    }
    
    public int char_or(char c1, char c2){
        return ((c1-48) | (c2-48));
    }
}
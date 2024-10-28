class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.pow((int)Math.sqrt(n), 2) == n){
            return (long)Math.pow(Math.sqrt(n) + 1 , 2);
        }else return -1;
    }
}

class Solution {
  public long solution(long n) {
      long answer = 0;

      for (long i = 1; i <= n; i++) {
          if (i * i == n) {
              answer = (i + 1) * (i + 1);
              break;
          }
          else answer = -1;
      }
      return answer;
  }
}

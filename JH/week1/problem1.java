package week1;

public class problem1 {
    class Solution {
        static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
      
             Time vidTime = new Time(video_len); //"10:55" "00:05" "00:15" "06:55"
             Time curTime = new Time(pos);
             Time opStartTime = new Time(op_start);
             Time opEndTime = new Time(op_end);
      
             for(String command : commands){
               
                 // System.out.println(command + " " + (command=="next"));
                  if (curTime.isBiggerAndEqualTo(opStartTime) && curTime.isLesserAndEqualTo(opEndTime)){
                     curTime.seconds = opEndTime.seconds;
                 }
                 if(command.equals("next")){
                     // System.out.println(curTime);
                      curTime.addSeconds(vidTime);
                     // System.out.println(curTime);
                 }else{
     
                     curTime.subtractSeconds();
                 }
                       
                 // 오프닝 끝내기 자동 
             }
            
             if (curTime.isBiggerAndEqualTo(opStartTime) && curTime.isLesserAndEqualTo(opEndTime)){
                     curTime.seconds = opEndTime.seconds;
             }   
             
             return curTime.toString();
     
             // return "";
         }
           static class Time{
             int seconds;
     
             Time(int minutes, int seconds){
                 this.seconds = 60 * minutes + seconds;
             }
     
             Time(String mmss){
                 int mm = Integer.parseInt(mmss.substring(0,2));
                 int ss = Integer.parseInt(mmss.substring(3, 5));
                 this.seconds = 60 * mm + ss;
             }
     
             public String toString(){
                 int minutes = this.seconds / 60;
                 int remainingSeconds = this.seconds % 60;
                 return String.format("%02d:%02d", minutes, remainingSeconds);
             }
             
             public void addSeconds(Time vidoTime){
                 if(this.seconds + 10 >= vidoTime.seconds){
                     this.seconds = vidoTime.seconds;
                 }
                 else{
                     this.seconds+=10;
                 }
             }
     
             public void subtractSeconds(){
                 if (this.seconds - 10 < 0){
                     this.seconds = 0;
                 }
                 else{
                     this.seconds -= 10;
                 }
                 
             }
     
             public boolean isEqualTo(Time other){
                 return this.seconds == other.seconds;
             }
             public boolean isBiggerTo(Time other){
                 return this.seconds > other.seconds;
             }
             public boolean isLesserTo(Time other){
                 return this.seconds < other.seconds;
             }
             public boolean isLesserAndEqualTo(Time other){
                 return this.seconds <= other.seconds;
             }
             public boolean isBiggerAndEqualTo(Time other){
                 return this.seconds >= other.seconds;
             }
         }
     }
     // "07:22" "04:05" "00:15" "04:07"
     public static void main(String[] args) {
        
     }
}

package Programmers.DevMatching2020;

public class sol2 {

   public String solution(String p, int n) {
       String answer = null;
       String day = p.substring(0,2);
       int hour = Integer.parseInt(p.substring(3,5));
       int min = Integer.parseInt(p.substring(6,8));
       int sec = Integer.parseInt(p.substring(9,11));
       if(day.equals("PM") && hour!=12){
           hour += 12;
       }
       if(day.equals("AM") && hour==12){
           hour -= 12;
       }
       
       int h=n/3600;
       n-=(h*3600);
       int m=n/60;
       n-=(m*60);
       int s=n;
       
       int newsec = sec+s;
       if(newsec>=60){
           m+=1;
           newsec-=60;
       }
       int newmin = min+m;
       if(newmin>=60){
           h+=1;
           newmin-=60;
       }
       int newhour = hour+h;
       if(newhour>=24){
           newhour %= 24;
       }
       
       StringBuilder sb = new StringBuilder();
       if(newhour<10) sb.append("0");
       sb.append(newhour);
       sb.append(":");
       if(newmin<10) sb.append("0");
       sb.append(newmin);
       sb.append(":");
       if(newsec<10) sb.append("0");
       sb.append(newsec);
       
       System.out.println(sb.toString());
       return answer=sb.toString();
   }

}

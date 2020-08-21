package Programmers;
import java.util.*;

public class day07_sol1{

   public static void main(String []args){
         
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new Date());
      int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      
      if(month==1 && ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0))
         month=12;
      
        int[] eachdays = {31,28,31,30,31,30,31,31,30,31,30,31,29};
        
      int days = eachdays[month];
        
        System.out.println(days + " days");

     }
}
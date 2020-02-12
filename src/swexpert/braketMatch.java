import java.util.Scanner;
import java.util.Stack;

public class braketMatch {
 
    public static void main(String[] args) {
        int testcase=10;
        Scanner sc=new Scanner(System.in);

        int out=1;
        String input="";
        char[] open= {'(','[','{','<'};
        char[] close= {')',']','}','>'};
        int opencnt[];
        int closecnt[];
        int len=0;
        
        for(int test=1; test<=testcase; test++) {
        	out=1;
        	len=sc.nextInt();
        	input=sc.next();
        	opencnt=new int[4];
        	closecnt=new int[4];
            
        	for(int i=0; i<len; i++) {
        		for(int j=0; j<4; j++) {
        			if(input.charAt(i) == open[j]) {
        				opencnt[j]++;
        			}
        			else if(input.charAt(i) == close[j]) {
        				closecnt[j]++;
        			}
        		}
        		
        	}
        	
        	for(int i=0; i<4; i++) {
        		//System.out.println("open:"+opencnt[i]+" close:"+closecnt[i]);
        		if(opencnt[i] != closecnt[i])
        			out=0;
        	}
        	
            System.out.println("#"+test+" "+out);
        }
 
    }
 
}
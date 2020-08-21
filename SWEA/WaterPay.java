package SWEA;
import java.util.Scanner;

public class WaterPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testcase;
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();
		
		for(int test=1; test<=testcase; test++) {
			int p, q, r, s, w;
			p=sc.nextInt();
			q=sc.nextInt();
			r=sc.nextInt();
			s=sc.nextInt();
			w=sc.nextInt();
			
			//A
			int calcA=0;
			calcA=w*p;
			//B
			int calcB=0;
			if(w<=r) calcB=q;
			else calcB=q + (w-r)*s;
			
			
			System.out.println("#"+test+" "+((calcA>calcB)?calcB:calcA));
		}
	}

}

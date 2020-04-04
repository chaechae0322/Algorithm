import java.util.Scanner;

public class DateCalc {
//1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
	public static void main(String[] args) {
		int testcase;
		Scanner sc = new Scanner(System.in);
		testcase=sc.nextInt();
		
		for(int test=1; test<=testcase; test++) {
			int mon1, day1, mon2, day2;
			mon1=sc.nextInt();
			day1=sc.nextInt();
			mon2=sc.nextInt();
			day2=sc.nextInt();
			
			int total=0;
			if(mon1 == 2 || mon1 == 4 || mon1 == 6 || mon1 == 9 || mon1 == 11) {
				if(mon1==2) total=28-day1;
				else total=30-day1;
			}
			else total=31-day1;
			for(int i=mon1+1; i<mon2; i++) {
				if(i == 2 || i == 4 || i == 6 || i == 9 || i == 11) {
					if(i==2) total+=28;
					else total+=30;
				}
				else
					total+=31;
			}
			total+=(day2+1);
			if(mon1 == mon2)
				total=day2-day1+1;
			
			System.out.println("#"+test+" "+total);
		}

	}

}

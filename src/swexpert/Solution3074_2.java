import java.util.Arrays;
import java.util.Scanner;

public class Solution3074_2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int testcase=sc.nextInt();
		
		long pn, tablen;
		long[] table;
		long[] end;
		int time=0;
		for(int test=1; test<=testcase; test++) {
			time=0;
			tablen=sc.nextInt();
			pn=sc.nextInt();

			table=new long[(int)tablen];
			end=new long[(int)tablen];
			for(int i=0; i<tablen; i++)
				table[i]=sc.nextInt();
			
			long tmp=0;
			for(int i=0; i<tablen; i++) {
				tmp=table[i];
				for(int j=2; j<=table[i]; j++) {
					if(tmp % j==0){
//						if()
					}
				}
			}
			 

		}

	}

}

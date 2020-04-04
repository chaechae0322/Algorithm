import java.util.Arrays;
import java.util.Scanner;

public class Solution3074 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int testcase=sc.nextInt();
		
		long pn, tablen;
		long[] table;
		long[] end;
		int time=0;
		for(int test=1; test<=testcase; test++) {
			time=0;
			tablen=sc.nextLong();
			pn=sc.nextLong();
			
			table=new long[(int)tablen];
			end=new long[(int)tablen];
			for(int i=0; i<tablen; i++)
				table[i]=sc.nextLong();
			
//			Arrays.sort(table);
			long max=0, maxidx=-1;
			a: while(true) {
				
				for(int i=0; i<tablen; i++) {
					max=1; maxidx=-1;
					if(end[i]<=0) {
						
						if(pn == 0) {
							//max 
							System.out.println("time : " +time);
							System.out.println(Arrays.toString(end));
							
							for(int j=0; j<tablen; j++) {
								if(end[j] >= max) {
									max=end[j];
									maxidx=j;
								}
							}
							
							System.out.println("maxidx:"+maxidx +" max:"+end[(int)maxidx]);

							if(max > table[i]) {
								end[i] += table[i];
								end[(int)maxidx] -= table[(int)maxidx];

								max=0; maxidx=-1;
								for(int j=0; j<tablen; j++) {
									if(end[j] >= max) {
										max=end[j];
										maxidx=j;
									}
								}
								if(maxidx < i)
									max+=1;

								
							}
							break a;
						}
						else {
							end[i] += table[i];
							pn-=1;
						}
						System.out.println("time:"+time+" pn:"+pn +" lane:"+i);
					}

					end[i]-=1;

										
				}
				
				time+=1;
				
			}			
			System.out.println("maxidx:"+maxidx +" max:"+max);
			System.out.println("#"+test+" "+(time+max));
		}

	}

}

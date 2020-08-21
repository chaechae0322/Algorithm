
package SWEA;
import java.util.Arrays;
import java.util.Scanner;
/*
10
123 1
2737 1
757148 1
78466 2  
32888 2
777770 5
436659 2
431159 7   
112233 3   
456789 10  
 */
public class Maxmoney {
	static String su;
	static int s;
	static int ans;
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase=sc.nextInt();

		for(int test=1; test<=testcase; test++) {
			su=sc.next();
			s=sc.nextInt();
			memo=new int[s+1];
			
			
			maxmoney(su.toCharArray(), 0, 0);
			System.out.println("#"+test+" "+memo[s]);
			ans=0;
			memo=new int[s+1];
		}

	}
	private static void maxmoney(char[] su, int pos, int change) {
			
		
//		if(change < s) {

			// ���� �����
			int num=0;
			for(int i=su.length-1; i>=0; i--) {
				num+=((Math.pow(10, i))*(su[su.length-1-i]-'0'));
			}
			// memo[change] �� ��
			if(memo[change] < num) {
				memo[change] = num;
			} else { 
				return;  // memo[change] ���� ������ ���ġ ������
			}
//		}
		
		
		if(change == s || pos == su.length) {
			System.out.println(su);
			
			if(pos == su.length && change < s) {
				if((s-change)%2==1) {
					swap(su, su.length-1, su.length-2);
				}
			}
			
			num=0;
			for(int i=su.length-1; i>=0; i--) {
				num+=((Math.pow(10, i))*(su[su.length-1-i]-'0'));
			}
//			if(ans < num) {
//				ans=num;
//			}
			if(memo[change] < num) {
				memo[change]=num;
			}
			
			
			return;
		}

		for(int j=pos; j<su.length; j++) {
			for(int i=j; i<su.length; i++) {
				if(su[j]-'0' <= su[i]-'0') {
					swap(su, j, i);
					maxmoney(su, pos+1, change+1);
					swap(su, j, i);
				}
			}
		}


	}
	static void swap(char[] su, int pos, int i) {
		char tmp=su[pos];
		su[pos]=su[i];
		su[i]=tmp;

	}

}

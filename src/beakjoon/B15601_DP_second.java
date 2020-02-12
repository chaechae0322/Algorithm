import java.util.Arrays;
import java.util.Scanner;

public class B15601_DP_second {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(t));
		System.out.println(Arrays.toString(p));
		int[] dp=new int[n+1];
		
		for(int i=1; i<=n; i++) {
			System.out.println("i:"+i);
			if(i+t[i]-1 <= n) {
				dp[i]=p[i];
				for(int j=1; j<i; j++) {
					if(j+t[j]<=i) {
						dp[i]=Math.max(dp[j]+p[i], dp[i]);
					}
				}
			}
			else dp[i]=dp[i-1];
			
			System.out.println("dp check");
			System.out.println(Arrays.toString(dp));
		}

		int max=0;
		for(int i=0; i<=n; i++)
			if(dp[i]>max) max=dp[i];
		System.out.println(max);
	}

}

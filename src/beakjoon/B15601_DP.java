import java.util.Arrays;
import java.util.Scanner;

public class B15601_DP {

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
		int[][] dp=new int[n+1][n+1];
		
		
		int d1=0, d2=0;
		for(int i=1; i<=n; i++) {
			System.out.println("i:"+i);
			for(int j=1; j<=n; j++) {//
				if((d1=i+t[i]-1)<=j) {
					System.out.println("d1:"+d1+" j:"+j);
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][d1-t[i]]+p[i]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
			
			System.out.println("dp check");
			for(int ii=0; ii<=n; ii++) {
				for(int j=0; j<=n; j++)
					System.out.print(dp[ii][j]+" ");
				System.out.println();
			}
			
		}
		
		
		int max=0;
		for(int j=0; j<=n; j++) {
			if(dp[n][j]>max) max=dp[n][j];
		}
		
		System.out.println(max);

	}

}

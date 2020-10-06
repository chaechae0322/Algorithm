package BOJ;

import java.util.Scanner;
/*
 * Brute Force
 */
public class B1107_리모컨 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n=sc.next();
		int m=sc.nextInt();
		boolean[] block=new boolean[10];
		for(int i=0; i<m; i++) {
			block[sc.nextInt()]=true;
		}
		ans=Math.abs(100-Integer.parseInt(n));	
		dfs(0,n,block,0);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos, String n, boolean[] block, int res) {
		if(pos>=1)ans=Math.min(pos+Math.abs(res-Integer.parseInt(n)), ans);
		if(pos==n.length()+1) return;
		
		for(int i=0; i<10; i++) {
			if(!block[i]) {
				dfs(pos+1, n, block, res*10+i);
			}
		}
		
	}

}

package beakjoon;
import java.util.Arrays;
import java.util.Scanner;

public class B2602_돌다리건너기 {
	static char[] order;
	static char[][] bridge; //악마, 천사
	static int[][][] dp;
	static int length;
	static int ordersize;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input=sc.next();
		ordersize=input.length();
		order=new char[input.length()];
		order=input.toCharArray();
		input=sc.next();
		length=input.length();
		bridge=new char[2][length];
		bridge[0]=input.toCharArray();
		bridge[1]=sc.next().toCharArray();
		length=bridge[0].length;
		
		dp=new int[ordersize+1][2][length];
		int ans=0;
		boolean[][] visited=new boolean[2][length];
		for(int i=0; i<length; i++)
			if(bridge[0][i]==order[0]) {
				visited[0][i]=true;
				ans+=dfs(i,0,1,visited);
				visited[0][i]=false;
			}
		
		System.out.println(ans);
		visited=new boolean[2][length];
		//dp=new int[ordersize][2][length];
		for(int i=0; i<length; i++)
			if(bridge[1][i]==order[0]) {
				visited[1][i]=true;
				ans+=dfs(i,1,1,visited);
				visited[1][i]=false;
			}
		System.out.println(ans);
		
	}
	private static int dfs(int pos, int sel, int idx, boolean[][] visited) {
		System.out.println("pos:"+pos+" sel:"+sel+" idx:"+idx);
		if(dp[idx][sel][pos]!=0) {
			System.out.println("이미 있음");
			return dp[idx][sel][pos];
		}
		if(idx==order.length) {
			System.out.println("끝");
			dp[idx][sel][pos]=1;
			return dp[idx][sel][pos];
		}
		
		sel=(sel+1)%2;
		for(int i=pos+1; i<length; i++) {
			System.out.println("i:"+i);
			if(bridge[sel][i]==order[idx] && !visited[sel][i]) {
				System.out.println("맞는다 pos:"+i+" sel:"+sel+" idx:"+idx);
				visited[sel][i]=true;
				dp[idx][(sel+1)%2][pos]+=dfs(i,sel, idx+1, visited);
				visited[sel][i]=false;
				
				System.out.println(Arrays.toString(dp[idx][0]));
				System.out.println(Arrays.toString(dp[idx][1]));
				
			}
		}
		return dp[idx][(sel+1)%2][pos];
	}

}

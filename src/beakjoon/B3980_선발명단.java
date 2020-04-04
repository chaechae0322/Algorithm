package beakjoon;
import java.util.Scanner;

public class B3980_선발명단 {
	static int[][] info;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		info=new int[11][11];
		for(int t=0; t<tc; t++) {
			ans=0;
			for(int i=0; i<11; i++) {
				for(int j=0; j<11; j++) {
					info[i][j]=sc.nextInt();
				}
			}
			boolean[][] visited=new boolean[11][11];
			boolean[] selected=new boolean[11];
			solve(0,0, visited,0,selected);
			System.out.println(ans);
		}
	}
	static int ans;
	private static void solve(int idx, int pos, boolean[][] visited, int acc, boolean[] selected) {
		if(idx==11) {
			ans=Math.max(ans, acc);
			return;
		}
		
		for(int i=0; i<11; i++) {
			if(selected[i]) continue;
			
			if(info[idx][i]!=0 && !visited[idx][i]) {
				visited[idx][i]=true;
				selected[i]=true;
				solve(idx+1, i,	visited, acc+info[idx][i], selected);
				visited[idx][i]=false;
				selected[i]=false;
			}
		}
	}

}

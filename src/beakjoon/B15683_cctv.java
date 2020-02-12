import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B15683_cctv {
	static int n,m;
	static int[][] map;
	static ArrayList<Integer> list;
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		map=new int[n][m];
		
		int tmp=0;
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(token.nextToken());
			for(int j=0; j<m; j++) {
				tmp=Integer.parseInt(token.nextToken());
				if(tmp==1) list.add(4);
				else if(tmp==2) list.add(2);
				else if(tmp==3) list.add(4);
				else if(tmp==4) list.add(4);
				else if(tmp==5) list.add(4);
				
				map[i][j]=tmp;
			}
		}//
		
		ans=n*m;
		num=list.size();
		int[] dir=new int[num];
		dfs(0,0, dir);
		System.out.println(ans);

	}
	static int ans;
	private static void dfs(int pos, int depth, int[] dir) {
		if(depth==num) {
			int cnt=count(dir);
			ans=Math.min(cnt, ans);
			return;
		}
		
		for(int i=pos; i<list.get(depth); i++) {
			dir[i]++;
			dfs(i,depth+1, dir);
			dir[i]--;
		}
		
	}
	private static int count(int[] dir) {
		
		return 0;
	}
	

}

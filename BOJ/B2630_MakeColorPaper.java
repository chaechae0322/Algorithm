package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_MakeColorPaper {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		map=new int[n][n];
		
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		whiteans=0;
		blueans=0;
		dfs(0, n-1, 0, n-1, 0);
		
		System.out.println(whiteans);
		System.out.println(blueans);
		

	}
	static int whiteans;
	static int blueans;
	private static void dfs(int xs, int xe, int ys, int ye, int depth) {
		System.out.println("xs:"+xs+" xe:"+xe+" ys:"+ys+" ye:"+ye);
		//if(xs>=xe) return;
		
		int pre=0, cur=0;
		boolean flag=true;
		a:for(int i=ys; i<=ye; i++) {
			for(int j=xs; j<=xe; j++) {
				cur=map[i][j];
				
				if(i==ys && j==xs) {
					pre=cur;
					continue;
				}
				if(pre!=cur) {
					flag=false;
					break a;
				}
				pre=cur;
			}
		}
		
		
		if(!flag) {
			int midx=(xs+xe)/2;
			int midy=(ys+ye)/2;
			
			dfs(xs, midx, ys, midy, depth+1);
			dfs(midx+1, xe, ys, midy, depth+1);
			dfs(xs, midx, midy+1, ye, depth+1);
			dfs(midx+1, xe, midy+1, ye, depth+1);
		}
		else {
			if(map[ys][xs]==1) {
				System.out.println("blue paper");
				blueans++;
			}
			else {
				System.out.println("white paper");
				whiteans++;
			}
		}
	}

}

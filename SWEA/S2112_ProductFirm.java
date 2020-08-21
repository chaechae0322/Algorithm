package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2112_ProductFirm {
	static int d,w,k;
	static int[][] map;
	static int[][] copymap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		
		for(int t=1; t<=tc; t++) {
			token=new StringTokenizer(br.readLine());
			d=Integer.parseInt(token.nextToken());
			w=Integer.parseInt(token.nextToken());
			k=Integer.parseInt(token.nextToken());
			
			map=new int[d][w];
			copymap=new int[d][w];
			
			for(int i=0; i<d; i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
				}
			}//
			
			
			int[] status=new int[d];
			ans=k;
			
			copyMap();
			if(check()) {
				System.out.println("#"+t+" 0");
				continue;
			}
			dfs(0,-1,status);
			
			
			System.out.println("#"+t+" "+ans);
		}

	}
	static int ans;
	private static void dfs(int depth, int pos, int[] status) {
		if(depth==k-1) {
			System.out.println(Arrays.toString(status));
			copyMap();
			
			//injection
			int cnt=0;
			for(int i=0; i<d; i++) {
				if(status[i]!=0) { //1 or 2
					cnt++;
					for(int j=0; j<w; j++) {
						copymap[i][j]= status[i]-1;
					}
				}
			}
			
			if(check()) {
				ans=Math.min(cnt, ans);
			}
			
			return;
		}
		
		
		for(int i=pos; i<d; i++) {
			if(i==pos)continue;
			int original=status[i];
			for(int j=0; j<3; j++) {
				status[i]=j;
				dfs(depth+1, i, status);
				
			}
			status[i]=original;
		}
	}
	private static boolean check() {

		int ref=0;
		int colcnt=0, cellcnt=0;
		for(int i=0; i<w; i++) {//w
			for(int j=0; j<d-k+1; j++) { //d
				cellcnt=0;
				ref=copymap[j][i];
				for(int l=0; l<k; l++) { //d
					if(ref!=copymap[j+l][i]) {
						
						break;
					}
					cellcnt++;
						
				}
				if(cellcnt==k) {
					colcnt++;
					break;
				}
			}
			if(cellcnt!=k) {
				return false;
			}
		}
		if(colcnt==w) {
			return true;
		}
		return false;
	}
	private static void copyMap() {
		for(int i=0; i<d; i++) {
			for(int j=0; j<w; j++)
				copymap[i][j]=map[i][j];
		}
		
	}

}

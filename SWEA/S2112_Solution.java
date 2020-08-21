package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2112_Solution {
	static int d, w, k;
	static int[][] firm;
	static int[][] copyfirm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int tc=Integer.parseInt(token.nextToken());
		
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			d=Integer.parseInt(token.nextToken());
			w=Integer.parseInt(token.nextToken());
			k=Integer.parseInt(token.nextToken());
			
			firm=new int[d][w];
			copyfirm=new int[d][w];
			
			for(int i=0; i<d; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					firm[i][j]=Integer.parseInt(token.nextToken());
				}
			}//
			
			ans=d;
			int[] status=new int[d];
			
			copyFirm();
			if(check()) {
				System.out.println("#"+t+" 0");
			}else {
				dfs(0,0,status);
				System.out.println("#"+t+" "+ans);
			}
			
			
			
		}
	}
	static int ans;
	private static void dfs(int depth, int cnt, int[] status) {
		
		if(cnt>ans) return;
		if(depth==d) {
			//System.out.println(Arrays.toString(status));
			copyFirm();
			
			for(int i=0 ;i<d; i++) {
				if(status[i]!=0) { //A
					for(int j=0; j<w; j++)
						copyfirm[i][j]=status[i]-1;
				}
			}
			
			if(check()) {
				ans=Math.min(ans, cnt);
			}
			
			return;
		}
		
		//int[] copy=status.clone();
		
		status[depth]=0;
		dfs(depth+1, cnt, status);
		
		status[depth]=1;
		dfs(depth+1, cnt+1, status);
	
		status[depth]=2;
		dfs(depth+1, cnt+1, status);
		
		status[depth]=0;
		//status=copy.clone();
		
	}
	private static void copyFirm() {
		for(int i=0; i<d; i++) {
			copyfirm[i]=firm[i].clone();
		}
		
	}
	private static boolean check() {
		int cnt=0, ref=0;
		for(int i=0; i<w; i++) {
			cnt=1;
			ref=copyfirm[0][i];
			for(int j=1; j<d; j++) {
				if(ref==copyfirm[j][i]){
					cnt++;
					if(cnt==k) {
						break;
					}
				}else {
					cnt=1;
					ref=copyfirm[j][i];
				}
			}
			if(cnt!=k) return false;
		}
		return true;
	}

}

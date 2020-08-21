package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2019.11.01
 * 백준 17822 원판돌리기
 */
public class B17822_CircleRoll {
	static int n,m,t;
	static int[][] circle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		t=Integer.parseInt(token.nextToken());
		
		circle=new int[n][m];
		
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				circle[i][j]=Integer.parseInt(token.nextToken());
			}
		}//

		int x=0,d=0,k=0;
		for(int i=0; i<t; i++) {
			token = new StringTokenizer(br.readLine());
			x=Integer.parseInt(token.nextToken());
			d=Integer.parseInt(token.nextToken());
			k=Integer.parseInt(token.nextToken());
			
			System.out.println("x:"+x+" d:"+d+" k:"+k);
			
			rolling(x,d,k);
			
			System.out.println("rolling check");
			for(int ii=0; ii<n; ii++) {
				for(int j=0; j<m; j++) {
					System.out.print(circle[ii][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			check();
			System.out.println("del check");
			for(int ii=0; ii<n; ii++) {
				for(int j=0; j<m; j++) {
					System.out.print(circle[ii][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			
		}
		
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(circle[i][j]!=-1) ans+=circle[i][j];
			}
		}
		System.out.println(ans);
		
	}

	private static void check() {
		boolean[][] del= new boolean[n][m];
		
		boolean isdel=false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(j==0 && circle[i][j]!=-1) {
					if(circle[i][j+1]!=-1 && (circle[i][j]==circle[i][j+1])) {
						isdel=true;
						del[i][j]=true;
						del[i][j+1]=true;
					}
					if(circle[i][m-1]!=-1 && circle[i][j]==circle[i][m-1]) {
						isdel=true;
						del[i][j]=true;
						del[i][m-1]=true;
					}
				}
				
				else if(j==m-1 && circle[i][j]!=-1) {
					if(circle[i][j-1]!=-1 && (circle[i][j]==circle[i][j-1])) {
						isdel=true;
						del[i][j]=true;
						del[i][j-1]=true;
					}
					if(circle[i][0]!=-1 && circle[i][j]==circle[i][0]) {
						isdel=true;
						del[i][j]=true;
						del[i][0]=true;
					}
				}
				
				else {
					if(circle[i][j]!=-1 && circle[i][j-1]!=-1 && (circle[i][j]==circle[i][j-1])) {
						isdel=true;
						del[i][j]=true;
						del[i][j-1]=true;
					}
					if(circle[i][j]!=-1 && circle[i][j+1]!=-1 && circle[i][j]==circle[i][j+1]) {
						isdel=true;
						del[i][j]=true;
						del[i][j+1]=true;
					}
				}
				
			}
		}
		
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				if(i==0 && circle[i][j]!=-1) {
					if(circle[i+1][j]!=-1 && (circle[i][j]==circle[i+1][j])) {
						isdel=true;
						del[i][j]=true;
						del[i+1][j]=true;
					}
				}
				
				else if(i==n-1 && circle[i][j]!=-1) {
					if(circle[i-1][j]!=-1 && (circle[i][j]==circle[i-1][j])) {
						isdel=true;
						del[i][j]=true;
						del[i-1][j]=true;
					}
				}
				
				else {
					if(circle[i][j]!=-1 && circle[i-1][j]!=-1 && (circle[i][j]==circle[i-1][j])) {
						isdel=true;
						del[i][j]=true;
						del[i-1][j]=true;
					}
					if(circle[i][j]!=-1 && circle[i+1][j]!=-1 && circle[i][j]==circle[i+1][j]) {
						isdel=true;
						del[i][j]=true;
						del[i+1][j]=true;
					}
				}
				
			}
		}
		
		
		
		if(isdel) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(del[i][j]) {
						circle[i][j]=-1;
					}
				}
			}
		}
		else {
			int sum=0;
			int cnt=0;
			double avg=0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(circle[i][j]!=-1) {
						sum+=circle[i][j];
						cnt++;
					}
				}
			}
			
			if(cnt!=0) avg=sum/(double)cnt;
			else return;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(circle[i][j]!=-1) {
						if(circle[i][j]>avg) circle[i][j]-=1;
						else if(circle[i][j]<avg) circle[i][j]+=1;
					}
				}
			}
		}
		
		
	}

	private static void rolling(int x, int d, int k) {
		int[] ref=new int[m];
		int idx=0;
		
		for(int i=0; i<n; i++) {
			if((i+1)%x==0) {
				ref=circle[i].clone();
				
				if(d==0) {
					for(int j=0; j<m; j++) {
						idx=(j+k)%m;
						circle[i][idx]=ref[j];
					}	
				}
				else {
					for(int j=0; j<m; j++) {
						idx=(j-k)%m;
						
						if(idx<0) idx+=m;
						
						circle[i][idx]=ref[j];
					}
				}
				
				
			}
		}
		
	}

}

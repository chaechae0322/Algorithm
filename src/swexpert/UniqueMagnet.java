import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UniqueMagnet {
	static int k;
	static int[][] mag;  
	static int[] order;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token=new StringTokenizer(br.readLine());
		
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			k=Integer.parseInt(br.readLine());
			order=new int[2*k];
			mag=new int[4][8];
			
			for(int i=0; i<4; i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					mag[i][j]=Integer.parseInt(token.nextToken());  // 0:N극   1:S극
				}
			}
			
			for(int i=0; i<k; i++) {
				token=new StringTokenizer(br.readLine());
				order[2*i]=Integer.parseInt(token.nextToken());
				order[2*i+1]=Integer.parseInt(token.nextToken());
			}
			
			run();
			
		}

	}
	private static void run() {
		boolean[] turnidx=new boolean[4];
		int[] dirs=new int[4];
		for(int i=0; i<k; i++) {
			
			for(int j=0; j<4; j++) {
				turnidx[j]=false;
				dirs[j]=0;
			}
			
			check(order[i*2], order[2*i+1], turnidx, dirs);
			
			int tmp=0;
			for(int j=0; j<4; j++) {
				if(turnidx[j]) {
					if(dirs[j]==1) { // 시계방향
						tmp=mag[j][7];
						for(int m=8-1; m>0; m--) {
							mag[j][m]=mag[j][m-1];
						}
						mag[j][0]=tmp;
					}
					else if(dirs[j]==-1) { // 반시계방향
						tmp=mag[j][0];
						for(int m=0; m<8-1; m++) {
							mag[j][m]=mag[j][m+1];
						}
						mag[j][7]=tmp;
					}
				}
			}
			
			
		}
		
	}
	private static void check(int num, int dir, boolean[] turnidx, int[] dirs) {
		int left=-1, right=-1;
		for(int i=num; i<=4; i++) {
			if(i==num) {
				right=mag[i-1][2];
			}
		}
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14499_DiceRolling {
	static int n,m;
	static int[][] map;
	static int[] k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		
		int y=Integer.parseInt(token.nextToken());
		int x=Integer.parseInt(token.nextToken());
		int knum=Integer.parseInt(token.nextToken());
		
		map=new int[n][m];
		k=new int[knum];
		
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<knum; i++)
			k[i]=Integer.parseInt(token.nextToken());

		diceRolling(x,y,knum);
	}
	static int[] dx= {0,1,-1,0,0};
	static int[] dy= {0,0,0,-1,1};
	private static void diceRolling(int x, int y, int num) {
		int[] dice = new int[7];
		
		int tx=0, ty=0;
		int dir=0;
		int tmp=0;
		for(int i=0; i<num; i++) {
			dir=k[i];
			
			tx=x+dx[dir];
			ty=y+dy[dir];
			
			
			if(tx<0||ty<0||tx>=m||ty>=n) continue;
			
			//System.out.println("dir:"+dir+" tx:"+tx+" ty:"+ty);
			
			if(dir==1) { //동쪽
				tmp=dice[3];
				dice[3]=dice[1];
				dice[1]=dice[4];
				dice[4]=dice[6];
				dice[6]=tmp;
			}
			else if(dir==2) {//서쪽
				tmp=dice[4];
				dice[4]=dice[1];
				dice[1]=dice[3];
				dice[3]=dice[6];
				dice[6]=tmp;
			}
			else if(dir==3) {//북쪽
				tmp=dice[2];
				dice[2]=dice[1];
				dice[1]=dice[5];
				dice[5]=dice[6];
				dice[6]=tmp;
				
			}
			else if(dir==4) {
				tmp=dice[5];
				dice[5]=dice[1];
				dice[1]=dice[2];
				dice[2]=dice[6];
				dice[6]=tmp;
			}
	
			if(map[ty][tx]!=0) {
				//System.out.println("value:"+map[ty][tx]);
				dice[6]=map[ty][tx];
				map[ty][tx]=0;
			}else {
				map[ty][tx]=dice[6];
				//dice[6]=0;
			}
			
			x=tx;
			y=ty;
			
			//System.out.println("dice:"+Arrays.toString(dice));
			System.out.println(dice[1]);
		}
		
	}

}

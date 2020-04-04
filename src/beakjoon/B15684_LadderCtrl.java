import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15684_LadderCtrl {
	static int N,H,M;
	static boolean[][] visited;
	static int[][] map;
	static boolean[][] ref;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		H=Integer.parseInt(token.nextToken());
		visited=new boolean[H][N-1];
		ref=new boolean[H][N-1];
		map=new int[H][N+N-1];
	
		int row=0, col=0;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			row=Integer.parseInt(token.nextToken());
			col=Integer.parseInt(token.nextToken());
			
			visited[row-1][col-1]=true;
			ref[row-1][col-1]=true;
		}
		
		minladder=4;
		dfs(0,0,0);
		if(minladder==4) System.out.println("-1");
		else System.out.println(minladder);
	}
	static int minladder;
	private static void dfs(int pos, int depth, int ladderCnt) {
		System.out.println("pos"+pos+" depth:"+depth+" ladderCnt:"+ladderCnt);
		if(ladderCnt >= 4) return; 
		/*if(depth==H) {
			
			return;
		}*/
		if(laddergame()){
			System.out.println("ladder yes pos"+pos+" depth:"+depth+" ladderCnt:"+ladderCnt);
			minladder=Math.min(ladderCnt, minladder);
		}
		if(pos==N-1) {
			//System.out.println(Arrays.toString(visited[depth]));
			//dfs(0, depth+1, ladderCnt);
			return;
		}
		

		for(int i=depth; i<H; i++) {
			if(!ref[depth][pos]) {
				visited[depth][pos]=false;
				dfs(pos+1, i, ladderCnt);

			}else {
				visited[depth][pos]=true;
				dfs(pos+1, i, ladderCnt);
			}

			if(pos==0 || (pos>0 && !visited[depth][pos-1])) {
				visited[depth][pos]=true;
				dfs(pos+1, i, ladderCnt+1);
			}
		}
	}
	private static boolean laddergame() {
		int col=0, row=0;
		
		for(int i=0; i<H; i++) {
			for(int j=1; j<2*N-1; j+=2)
				map[i][j]=visited[i][j/2]?1:0;
		}
		
		/*for(int i=0; i<H; i++) {
			for(int j=0; j<2*N-1; j++) {
				if(map[i][j]==1) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
				
		}*/
		ArrayList<int[]> li=new ArrayList<>();
		int[] tmp=null;
		for(int i=0; i<N*2-1; i+=2) {
			col=i;
			row=0;
//			System.out.println(i/2+"번째 세로줄 ");
			while(row<H) {
				//System.out.println("row:"+row+" col:"+col);
				
				if(col<2*N-2 && map[row][col+1]==1) {
					map[row][col+1]=2;
					li.add(new int[] {row, col+1});
					col+=2;
					
				}
				else if(col>0 && map[row][col-1]==1) {
					map[row][col-1]=2;
					li.add(new int[] {row, col-1});
					col-=2;
				}
				else {
					row+=1;
				}

			}
			
			for(int j=0; j<li.size(); j++) {
				tmp=li.get(j);
				map[tmp[0]][tmp[1]]=1;
			}
			li.clear();
			
			if(col!=i) return false;
		}
		return true;
	}

}

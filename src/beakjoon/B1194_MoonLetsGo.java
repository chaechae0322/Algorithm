import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194_MoonLetsGo {
	static char[][] map;
	static boolean[][][] visited;
	static int N,M;
	static class Node{
		int x,y,prevdir;
		int cnt;
		ArrayList<Character> keyList;
		
		public Node(int x, int y, int prevdir, ArrayList<Character> keyList, int cnt) {
			this.x = x;
			this.y = y;
			this.prevdir=prevdir;
			this.keyList = keyList;
			this.cnt=cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new char[N][M];
		visited=new boolean[7][N][M]; //0 a b c d e f
		int sx=0, sy=0;
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') {
					sy=i; sx=j;
				}
			}
		}
		//System.out.println("sx:"+sx+" sy:"+sy);
		bfs(sx,sy);
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static ArrayList<Character> copy(ArrayList<Character> list) {
		ArrayList<Character> c=new ArrayList<>();
		for(Character t : list) {
			c.add(t);
		}
		return c;
	}
	private static void bfs(int sx, int sy) {
		Queue<Node> q =new LinkedList<>();
		q.add(new Node(sx, sy, -1, new ArrayList<>(), 0));
		visited[0][sy][sx]=true;
		
		int tx=0, ty=0;
		int ans=-1;
		boolean diff=false;
		ArrayList<Character> tmpList=new ArrayList<>();
		loop:while(!q.isEmpty()) {
			Node tmp=q.poll();
			System.out.println("tmp.x:"+tmp.x+" tmp.y:"+tmp.y);
			System.out.println("tmp keylist:"+tmp.keyList.toString());
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx>=M||tx<0||ty>=N||ty<0)continue;
				if(map[ty][tx]=='#') continue;
				
				if(tmp.keyList.size()==0 && visited[0][ty][tx]) continue;
				else if(tmp.keyList.size()>0){
					
					diff=false;
					for(int j=0; j<tmp.keyList.size(); j++) {
						System.out.println(tmp.keyList.get(j)-'a'+1);
						System.out.println(visited[tmp.keyList.get(j)-'a'+1][ty][tx]);
						if(!visited[tmp.keyList.get(j)-'a'+1][ty][tx]) {
							diff=true;
							break;
						}
					}
					if(!diff) continue;
				}
				
				
				if(map[ty][tx]>='A'&& map[ty][tx]<='F') {
					if(!tmp.keyList.contains((char)(map[ty][tx]+32))) {
						continue;
					}
				}
				
				System.out.println("tx:"+tx+" ty:"+ty);
				tmpList=copy(tmp.keyList);
				if(map[ty][tx]=='1') {
					ans=tmp.cnt+1;
					break loop;
				}
				else if(map[ty][tx]>='a'&& map[ty][tx]<='f') {
					if(!tmpList.contains(map[ty][tx])) {
						tmpList.add(map[ty][tx]);
					}
					q.add(new Node(tx, ty, -1, tmpList, tmp.cnt+1));
				}
				else { //map이 .일때
					q.add(new Node(tx, ty, i, tmpList, tmp.cnt+1));
				}
				
				if(tmpList.size()==0) visited[0][ty][tx]=true;
				else {
					for(int j=0; j<tmpList.size(); j++) {
						visited[tmpList.get(j)-'a'+1][ty][tx]=true;
					}
				}
			}
			
		}
		System.out.println(ans);
		
	}

}

package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 현카4 {

	public static void main(String[] args) {
		int[][] ma = {
				{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}
		};
		
		solution(ma);
	}
	
	static int[][] map;
	public static String[] solution(int[][] macaron) {
		String[] answer = new String[6];
		for(int i=0; i<6; i++)
			answer[i]="";	
		
		map=new int[6][6];
		for(int i=0; i<macaron.length; i++) {
			
			int y = findHeight(macaron[i][0]-1);
			System.out.println(y);
			
			map[y][macaron[i][0]-1] = macaron[i][1];
			
			for(int k=0; k<6; k++) {
				for(int j=0; j<6; j++) {
					System.out.print(map[k][j]+" ");
				}
				System.out.println();
			}

			//bfs(macaron[i][0], y);
			bomb();
			
			
			
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				answer[i] += (map[i][j]+"");
			}
			System.out.println(answer[i]);
		}
		
		
		
        return answer;
	}
	private static void bomb() {
		boolean flag = false;
		
		boolean[][] visited= new boolean[6][6];
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				
				if(map[i][j]!=0 && !visited[i][j]) {
					System.out.println(i+" "+j);
					ArrayList<int[]> res = bfs(j,i,visited);
					
					if(res!=null) {
						System.out.println("size:"+res.size());
						for(int k=0; k<res.size(); k++) {
							list.add(res.get(k));
						}
						
						flag = true;
					}
					
				}
			}
		}
		
		
		System.out.println("flag:"+flag);
		
		if(flag) {
			
			for(int i=0; i<list.size(); i++) {
				map[list.get(i)[1]][list.get(i)[0]]=0;
			}
			
			int[][] newmap = move();
			for(int i=0; i<6; i++)
				map[i]=newmap[i].clone(); //
			
			System.out.println("newmap");
			for(int k=0; k<6; k++) {
				for(int j=0; j<6; j++) {
					System.out.print(map[k][j]+" ");
				}
				System.out.println();
			}
			
			bomb();
		}
		else return;
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static ArrayList<int[]> bfs(int x, int y, boolean[][] visited) {
		//boolean[][] visited= new boolean[6][6];
		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> q=new LinkedList<>();
		visited[y][x]=true;
		q.add(new int[] {x,y,map[y][x]});
		list.add(new int[] {x, y});
		
		
		if(x==2 && y==3) {
		System.out.println("second bfs");
		for(int k=0; k<6; k++) {
			for(int j=0; j<6; j++) {
				System.out.print(map[k][j]+" ");
			}
			System.out.println();
		}
		}
		
		int tx=x;
		int ty=y;
		while(!q.isEmpty()) {
			int[] tmp=q.poll().clone();
			System.out.println("x:"+x+" y:"+y+" color:"+map[y][x]);
			
			for(int i=0; i<4; i++) {
				tx= tmp[0]+dx[i];
				ty= tmp[1]+dy[i];
				//System.out.println(i);
				//System.out.println("tx:"+tx+" ty:"+ty);
				
				if(tx<0||tx>=6||ty<0||ty>=6||visited[ty][tx]||map[ty][tx]!=tmp[2]) continue;
				
				//System.out.println("same");
				System.out.println("tx:"+tx+" ty:"+ty);
				visited[ty][tx]=true;
				q.add(new int[] {tx, ty, map[ty][tx]});
				list.add(new int[] {tx, ty});
			}
		}
		
		if(list.size()>=3) {
			return list;
			/*for(int i=0; i<list.size(); i++) {
				map[list.get(i)[1]][list.get(i)[0]]=0;
			}
			
			move();*/
		}
		
		return null;
	}
	private static int[][] move() {
		Queue<Integer> q=new LinkedList<>();
		int[][] newmap = new int[6][6];
		for(int j=0; j<6; j++) {
			for(int i=5; i>=0; i--) {
				if(map[i][j]!=0)
					q.add(map[i][j]);
			}
			
			int idx=5;
			while(!q.isEmpty()) {
				newmap[idx--][j] = q.poll();
			}
		}
		
		return newmap;
		
	}
	private static int findHeight(int x) {
		int h=0;
		for(int i=5; i>=0; i--) {
			if(map[i][x]==0) {
				h=i;
				break;
			}
		}
		return h;
	}

}

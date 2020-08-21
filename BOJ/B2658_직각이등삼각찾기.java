
package BOJ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2658_직각이등삼각찾기 {
	static boolean[][] visited = new boolean[10][10];
	static char[][] map=new char[10][10];
	static ArrayList<Pos> edgelist=new ArrayList<>();
	
	static class Pos implements Comparable<Pos>{
		int x,y;
		

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}


		public int getX() {
			return x;
		}


		public void setX(int x) {
			this.x = x;
		}


		public int getY() {
			return y;
		}


		public void setY(int y) {
			this.y = y;
		}


		@Override
		public int compareTo(Pos o) {
			if(this.y==o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			map[i]=sc.next().toCharArray();
		}
		
		boolean isTri=false;
		boolean isSingle=false;
		loop:for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j]=='1') {
					isTri = check(j,i);
					if(isTri) {
						for(int ii=0; ii<10; ii++)
							for(int jj=0; jj<10; jj++) {
								if(!visited[ii][jj] && map[ii][jj]=='1') {
									isTri=false;
									break loop;
								}
								
							}
						break loop;
					}
					else break loop;
			
				}
			}
		}
		
		if(isTri) {
			Collections.sort(edgelist);
			for (Pos tmp : edgelist) {
				System.out.println((tmp.y+1)+" "+(tmp.x+1));
			}
		}
		else System.out.println("0");

	}

	private static boolean check(int x, int y) {
		int ty=y; int tx=x;
		edgelist.add(new Pos(x, y));
		
		if(x+1<10 && map[y][x+1]=='1') {  
			for(tx=x+1; tx<10; tx++) {
				if(map[y][tx]=='0') break;
			}
			if(y+1<10 && map[y+1][x]=='1') {
				for(ty=y+1; ty<10; ty++) {
					if(map[ty][x]=='0') break;
				}
				if(tx-x != ty-y) return false;
				
				int s=x; int e=tx;
				for(int i=0; i<tx-x; i++) {
					for(int j=s; j<e; j++) {
						visited[y+i][j]=true;
						if(map[y+i][j]!='1') {
							return false;
						}
					}
					e--;
				}
				
				edgelist.add(new Pos(tx-1, y));
				edgelist.add(new Pos(x, ty-1));
				return true;
			}
			else {
				if(y+1<10 && map[y+1][tx-1]=='1') {
					int s=x; int e=tx;
					for(int i=0; i<tx-x; i++) {
						for(int j=s; j<e; j++) {
							visited[y+i][j]=true;
							if(map[y+i][j]!='1') {
								return false;
							}
						}
						s++;
					}
					
					//System.out.println("x:"+x+" y:"+y+" tx:"+tx+" ty:"+ty);
					edgelist.add(new Pos(tx-1, y));
					edgelist.add(new Pos(tx-1, y+(tx-x-1)));
					return true;
				}
				else {
					int s=x; int e=tx;
					for(int i=0; i<(tx+x+1)/2; i++) {
						for(int j=s; j<e; j++) {
							visited[y+i][j]=true;
							if(map[y+i][j]!='1') {
								return false;
							}
						}
						e--; s++;
					}
					
					edgelist.add(new Pos(tx-1, y));
					edgelist.add(new Pos((tx+x)/2, y+(tx-x)/2));
					return true;
				}
			}
		}
		else {  //////////////////////////////////////////������ ���°�
			for(ty=y+1; ty<10; ty++) {
				if(map[ty][x]=='0') break;
			}
			if(ty==y) return false;
			
			if(x+1<10 && map[ty-1][x+1]=='1' && x-1>=0 && map[ty-1][x-1]=='1') {
				int left=x, right=x;
				for(left=x-1; left>=0; left--) {
					if(map[ty-1][left]=='0') break;
				}
				for(right=x+1; right<10; right++) {
					if(map[ty-1][right]=='0') break;
				}
				//left = left<0?0:left;
				//System.out.println("left:"+left+" right:"+right+" ty:"+ty);
				if((right-left)%2==1 || (right-left)/2 != ty-y) {
					return false;
				}
				
				int s=left+1,e=right;
				for(int i=0; i<(right-left)/2; i++) {
					for(int j=s; j<e; j++) {
						visited[ty-i-1][j]=true;
						if(map[ty-i-1][j]!='1') {
							return false;
						}
					}
					s+=1; e-=1;
				}
				edgelist.add(new Pos(left+1, ty-1));
				edgelist.add(new Pos(right-1, ty-1));
				return true;
			}
			else if(x+1<10 && map[ty-1][x+1]=='1') {
				for(tx=x+1; tx<10; tx++) {
					if(map[ty-1][tx]=='0') break;
				}
				if(ty-y != tx-x) return false;
				
				int s=x,e=tx;
				for(int i=0; i<ty-y; i++) {
					for(int j=s; j<e; j++) {
						visited[ty-i-1][j]=true;
						if(map[ty-i-1][j]!='1') {
							return false;
						}
					}
					e--;
				}
				
				edgelist.add(new Pos(tx-1, ty-1));
				edgelist.add(new Pos(x, ty-1));
				return true;
				
			}
			else if(x-1>=0 && map[ty-1][x-1]=='1') {
				for(tx=x-1; tx>=0; tx--) {
					if(map[ty-1][tx]=='0') break;
				}
				if(ty-y != x-tx) return false;
				
				int s=tx,e=x;
				for(int i=0; i<ty-y; i++) {
					for(int j=s+1; j<=e; j++) {
						visited[ty-i-1][j]=true;
						if(map[ty-i-1][j]!='1') {
							return false;
						}
					}
					s++;
				}
				
				edgelist.add(new Pos(tx+1, ty-1));
				edgelist.add(new Pos(x, ty-1));
				return true;
				
			}
			else if(x+1<10 && (ty-y)%2==1 && map[(ty+y)/2][x+1]=='1') {
				int s=y; int e=ty;
				for(int j=0; j<(ty+y+1)/2; j++) {
					for(int i=s; i<e; i++) {
						visited[i][x+j]=true;
						if(map[i][x+j]!='1') {
							return false;
						}
					}
					s++; e--;
				}
				
				edgelist.add(new Pos(x+(ty-y)/2, (ty+y)/2));
				edgelist.add(new Pos(x, ty-1));
				return true;
			}
			else if(x-1>=0 && (ty-y)%2==1 && map[(ty+y)/2][x-1]=='1') {
				int s=y; int e=ty;
				for(int j=0; j<(ty+y+1)/2; j++) {
					for(int i=s; i<e; i++) {
						visited[i][x-j]=true;
						if(map[i][x-j]!='1') {
							return false;
						}
					}
					s++; e--;
				}
				
				edgelist.add(new Pos(x-(ty-y)/2, (ty+y)/2));
				edgelist.add(new Pos(x, ty-1));
				return true;
			}
		}
		
		
		return false;
	}


}

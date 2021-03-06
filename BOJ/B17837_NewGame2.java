package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17837_NewGame2{
	static int n,k;
	static Node[][] info;
	static int[][] map;
	static int[][] mal;
	static class Node {
		ArrayList<Integer> list;
		public Node() {list=new ArrayList<>();}
		public Node(ArrayList<Integer> list) {
			this.list = list;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		k=Integer.parseInt(token.nextToken());
		info=new Node[n][n];
		map=new int[n][n];
		mal=new int[k][3];
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				info[i][j]=new Node();
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		for(int i=0; i<k; i++) {
			token = new StringTokenizer(br.readLine()); //r c dir
			mal[i][0]=Integer.parseInt(token.nextToken())-1;
			mal[i][1]=Integer.parseInt(token.nextToken())-1;
			mal[i][2]=Integer.parseInt(token.nextToken())-1;
			info[mal[i][0]][mal[i][1]].list.add(i);
		}
		for(int i=0; i<k ;i++) {
			System.out.println(Arrays.toString(mal[i]));
		}
		
		solve();
	}
	
	public static ArrayList<Integer> cloneList(ArrayList<Integer> list) {
		ArrayList<Integer> clone = new ArrayList<Integer>(list.size());
	    for(int item: list) clone.add(item);
	    return clone;
	}
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	private static void solve() {
		int turn=1;
		int[] tar=null;
		ArrayList<Integer> carrier=new ArrayList<>();
		ArrayList<Integer> tmplist=new ArrayList<>(); 
		int tx=0,ty=0;
		int tmp=0;
		int cnt=0;
		while(turn<=1000) {
			//cnt++;
			//if(cnt==5) break;
			for(int id=0; id<k; id++) {
				System.out.println("새로운 말이 움직인다");
				
				carrier.clear();
				tar=mal[id].clone();
				
				//tmplist=(ArrayList<Integer>) info[tar[0]][tar[1]].list.clone();
				tmplist=cloneList(info[tar[0]][tar[1]].list);
				
				System.out.println("tmpsize:"+tmplist.size());
				for(int i=0; i<tmplist.size(); i++)
					System.out.println(tmplist.get(i));
				
				for(int i=0; i<tmplist.size(); i++) {
					//carrier.add(0,tmplist.get(i));
					//System.out.println("carrier 첫번째 값:"+carrier.get(0));
					
					if(tmplist.get(i) == id) {
						System.out.println("i:"+i);
						//break;
						for(int j=i; j<tmplist.size(); j++) {
							carrier.add(tmplist.get(j));
							//info[tar[0]][tar[1]].list.remove(j);
						}
						
						//for(int j=tmplist.size()-1; j>=i; j--)
						//	info[tar[0]][tar[1]].list.remove(j);
						
						break;
					}
					
					
				}
				
				
				
				System.out.println("move id:"+id+" y:"+tar[0]+" x:"+tar[1]+" dir:"+tar[2]);
				
				tx=tar[1]+dx[tar[2]];
				ty=tar[0]+dy[tar[2]];
				if(tx<0||ty<0||tx>=n||ty>=n||map[ty][tx]==2) {
					System.out.println("tx:"+tx+" ty:"+ty);
					if(tar[2]%2==0) tar[2]+=1;
					else tar[2]-=1;
					
					tx=tar[1]+dx[tar[2]];
					ty=tar[0]+dy[tar[2]];
					System.out.println("new tx:"+tx+" ty:"+ty+" dir:"+tar[2]);
					if(tx<0||ty<0||tx>=n||ty>=n||map[ty][tx]==2) {
						mal[id][2]=tar[2];
						continue;
					}
				}
				System.out.println("tx:"+tx+" ty:"+ty+" map 색깔:"+map[ty][tx]);
				//System.out.println("list size:"+info[tar[0]][tar[1]].list.size());
				
				if(map[ty][tx]==0) {
					//int cnt=0;
					for(int i=0; i<carrier.size(); i++) {
						//if(cnt==10) break;
						//cnt++;
						System.out.println("i:"+i);
						
						tmp=carrier.get(i);
						System.out.println("넣는 tmp:"+tmp);
						//System.out.println("tar[0]:"+tar[0]+" tar[1]:"+tar[1]);
						mal[tmp][0]=ty;
						mal[tmp][1]=tx;
						info[ty][tx].list.add(tmp);
						System.out.println("info size:"+info[ty][tx].list.size());
					}
					
					for(int i=0; i<carrier.size(); i++) {
						info[tar[0]][tar[1]].list.remove(tmplist.size()-1-i);
					}
					
				}
				else if(map[ty][tx]==1) {
					for(int i=carrier.size()-1; i>=0; i--) {
						tmp=carrier.get(i);
						mal[tmp][0]=ty;
						mal[tmp][1]=tx;
						info[ty][tx].list.add(tmp);
					}
					//info[tar[0]][tar[1]].list.clear();
					for(int i=0; i<carrier.size(); i++) {
						info[tar[0]][tar[1]].list.remove(tmplist.size()-1-i);
					}
				}
				else if(map[ty][tx]==2) {
					
				}
				mal[id][2]=tar[2];
				if(info[ty][tx].list.size()>=4) {
					System.out.println(turn);
					return;
				}
				
			}
			
			System.out.println(turn+"번 턴----");
			for(int i=0; i<k ;i++) {
				System.out.println(Arrays.toString(mal[i]));
			}
			turn++;
		}
		System.out.println("-1");
		
	}
}
package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19235_모노미노도미노 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		map=new int[10][10];
		for(int input=1; input<=N; input++) {
			token = new StringTokenizer(br.readLine());
			int t=Integer.parseInt(token.nextToken());
			int x=Integer.parseInt(token.nextToken());
			int y=Integer.parseInt(token.nextToken());

			loop:for(int i=9; i>=4; i--) {
				if(t==1) {


					//blue
					if(map[x][i]==0) {

						for(int j=i; j>=4; j--) {
							if(map[x][j]!=0) continue loop;
						}
						map[x][i]=input;
						break;
					}

				}else if(t==2) {

					//blue
					if(map[x][i]==0) {
						for(int j=i; j>=4; j--) {
							if(map[x][j]!=0) continue loop;
						}

						map[x][i]=input;
						map[x][i-1]=input;
						break;
					}

				}else if(t==3) {

					//blue
					if(map[x][i]==0 && map[x+1][i]==0) {
						for(int j=i; j>=4; j--) {
							//System.out.println("("+x+" "+);
							if(map[x][j]!=0 || map[x+1][j]!=0) continue loop;
						}
						map[x][i]=input;
						map[x+1][i]=input;
						break;
					}


				}
			}
			loop : for(int i=9; i>=4; i--) {

				if(t==1) {
					//green
					if(map[i][y]==0) {
						
						for(int j=i; j>=4; j--) {
							if(map[j][y]!=0) {
								//System.out.println("dd");
								continue loop;
							}
						}
						map[i][y]=input;
						break;
					}

				}else if(t==2) {


					//green
					if(map[i][y]==0 && map[i][y+1]==0) {
						for(int j=i; j>=4; j--) {
							if(map[j][y]!=0 || map[j][y+1]!=0) continue loop;
						}
						map[i][y]=input;
						map[i][y+1]=input;
						break;
					}

				}else if(t==3) {


					//green
					if(map[i][y]==0) {
						for(int j=i; j>=4; j--) {
							if(map[j][y]!=0) continue loop;
						}
						map[i][y]=input;
						map[i-1][y]=input;
						break;
					}

				}
			}
			System.out.println("check");
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}

			//check 
			bluecheck1();
			greencheck1();



			bluecheck2();
			greencheck2();

			System.out.println("input :"+ t+", "+x+", "+y);
			System.out.println("after");
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}

		}
		System.out.println(ans);
		int cnt=0;
		for(int j=4; j<10; j++) {
			for(int i=0; i<4; i++) {
				if(map[i][j]!=0) cnt++;
				if(map[j][i]!=0) cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static void greenclean() {

		Queue<int[]> q= new LinkedList<>();
		boolean[][] visited=new boolean[10][10];
		for(int j=9; j>=4; j--) {
			for(int k=0; k<4; k++) {
				int[] distance=new int[2];

				if(map[j][k]!=0 && !visited[j][k]) {
					q.add(new int[] {j,k}); //x,y
					visited[j][k]=true;
					System.out.println("("+j+" "+k+")"+ " map:"+map[j][k]);
					int tx=0, ty=0;
					for(int d=0; d<4; d++) {
						tx=k+dx[d];
						ty=j+dy[d];
						
						System.out.println("tx:"+tx+" ty:"+ty );
						
						if(tx<0||tx>=10||ty<0||ty>=10||visited[ty][tx]) {
							continue;
						}
						
						if(map[ty][tx]==map[j][k]) {
							System.out.println("dd");
							System.out.println("("+ty+" "+tx+")");
							q.add(new int[] {ty, tx});
							for(int yy=ty+1; yy<10; yy++) {
								if(map[yy][tx]==0) {
									//dis=Math.min(yy-ty, dis);
									distance[1]++;
								}else {
									break;
								}
							}
							visited[ty][tx]=true;
							break;
						}
					}
					for(int yy=j+1; yy<10; yy++) {
						if(map[yy][k]==0 || map[yy][k]==map[j][k]) {
							//dis=Math.min(yy-j, dis);
							distance[0]++;
						}
					}


					int min=0;
					if(q.size()==2) {
						min=Math.min(distance[0], distance[1]);
					}else {
						min=distance[0];
					}

					if(min==0) {
						q.clear();
						continue;
					}

					System.out.println("min:"+min);
					while(!q.isEmpty()) {
						int[] pos = q.poll();
						System.out.println(Arrays.toString(pos));
						/*for(int kk=pos[0]+1; kk<10; kk++) {
							if(map[kk][pos[1]]==0) {
								distance[idx]++;
							}else break;
						}*/

						map[pos[0]+min][pos[1]]=map[pos[0]][pos[1]];
						map[pos[0]][pos[1]]=0;
					}

				}
			}
		}

	}
	private static void blueclean() {

		Queue<int[]> q= new LinkedList<>();
		boolean[][] visited=new boolean[10][10];
		for(int j=9; j>=4; j--) {
			for(int k=0; k<4; k++) {
				int[] distance=new int[2];
				if(map[k][j]!=0 && !visited[k][j]) {
					q.add(new int[] {k,j}); //x,y
					System.out.println("x:"+k+" y:"+j+" map:"+map[k][j]);
					visited[k][j]=true;
					int tx=0, ty=0;
					for(int d=0; d<4; d++) { // k: x, j:y
						tx=j+dx[d];
						ty=k+dy[d];
						if(tx<4||tx>=10||ty<0||ty>=4||visited[ty][tx]) continue;
						if(map[ty][tx]==map[k][j]) {
							System.out.println("dd");
							System.out.println("tx:"+tx+" ty:"+ty);
							q.add(new int[] {ty, tx});
							for(int xx=tx+1; xx<10; xx++) {
								//System.out.println("distance 2");
								//System.out.println("xx:"+xx+" tx:"+tx);
								if(map[ty][xx]==0) {
									System.out.println("("+ty+" "+xx+")");
									System.out.println("dis1++");
									//dis=Math.min(xx-tx, dis);
									distance[1]++;
								}else {
									break;
								}
							}
							visited[ty][tx]=true;
							break;
						}
					}
					for(int xx=j+1; xx<10; xx++) {
						if(map[k][xx]==0) {
							//dis=Math.min(xx-j, dis);
							distance[0]++;
						}
					}

					int min=0;
					if(q.size()==2) {
						min=Math.min(distance[0], distance[1]);
					}else {
						min=distance[0];
					}
					if(min==0) {
						q.clear();
						continue;
					}
					System.out.println("min:"+min);
					while(!q.isEmpty()) {
						int[] pos = q.poll();
						System.out.println(Arrays.toString(pos));

						map[pos[0]][pos[1]+min]=map[pos[0]][pos[1]];
						map[pos[0]][pos[1]]=0;
					}
				}
			}
		}

	}
	private static void greencheck2() {

		boolean isin=false;
		int isclean=0;
		int idx=9;
		for(int i=5; i>=4; i--) {
			isin=false;
			for(int j=0; j<4; j++) {
				if(map[i][j]!=0) {
					isclean++;
					isin=true;
					break;
				}
			}
			if(isin) {
				isclean++;
				for(int j=0; j<4; j++) {
					map[idx][j]=0;
					
				}
				idx--;
			}
		}
		if(isclean>0) {
			
			System.out.println("green cleand");
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			greenclean();
			greencheck1();
		}

	}
	private static void greencheck1() {

		boolean isAll=true;
		for(int i=9; i>=4; i--) {
			isAll=true;
			for(int j=0; j<4; j++) {
				if(map[i][j]==0) {
					isAll=false;
					break;
				}
			}
			if(isAll) {
				System.out.println("green remove row :"+ i);
				//remove
				for(int j=0; j<4; j++) {
					map[i][j]=0;
				}
				ans++;
				greenclean();
				greencheck1();
				return;
			}
		}


	}
	static int ans;
	private static void bluecheck2() {
		boolean isin=false;
		int isclean=0;
		int idx=9;
		for(int j=5; j>=4; j--) {
			isin=false;
			for(int i=0; i<4; i++) {
				if(map[i][j]!=0) {
					isin=true;
					isclean++;
					break;
				}
			}
			if(isin) {
				isclean++;
				for(int i=0; i<4; i++) {
					map[i][idx]=0;
				}
				idx--;
			}
		}
		if(isclean>0) {
			
			
			
			//int idx=9;
			System.out.println("cleand");
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			blueclean();
			bluecheck1();
		}

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bluecheck1() {
		//blue
		boolean isAll=true;
		for(int i=9; i>=4; i--) {
			isAll=true;
			for(int j=0; j<4; j++) {
				if(map[j][i]==0) {
					isAll=false;
					break;
				}
			}
			if(isAll) {

				//remove
				for(int j=0; j<4; j++) {
					map[j][i]=0;
				}
				ans++;
				blueclean();
				bluecheck1();
				return;
			}
		}

	}

}

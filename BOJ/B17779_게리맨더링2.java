
package BOJ;

import java.util.Scanner;

public class B17779_게리맨더링2 {
	static int[][] map;
	static int N;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map=new int[N][N];
		
		total=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				total+=map[i][j];
			}
		}
		
		int lx, ly, rx, ry;
		for(int i=0; i<N-2; i++) {
			for(int j=1; j<N-1; j++) {
				lx=j-1;
				ly=i+1;
				
				
				while(lx>=0 && lx<N && ly>=0 && ly<N) {
					rx=j+1;
					ry=i+1;
					while(rx>=0 && rx<N && ry>=0 && ry<N && ly+ry-i<N) {
						check(lx, ly, rx, ry, j, i);
						
						rx++;
						ry++;
					}
					lx--;
					ly++;
				}
			}
			
		}
		System.out.println(ans);
		
	}
	static int ans = Integer.MAX_VALUE;
	private static void check(int lx, int ly, int rx, int ry, int x, int y) {
		int lrx= (lx+rx-x);
		int lry= (ly+ry-y);
		
		boolean[][] boundary = new boolean[N][N];
		int [][] m = new int[N][N];
		
		
		for(int i=y; i<=ly; i++) {
			boundary[i][x-(i-y)]=true;
			boundary[lry-(i-y)][lrx+(i-y)]=true;
		}
		
		for(int j=x; j<=rx; j++) {
			boundary[y+(j-x)][j]=true;
			boundary[ly+(j-x)][lx+(j-x)]=true;
		}
		
		int[] region= new int[5];
		int min=Integer.MAX_VALUE;
		int max=0;
		
		//1 구역
		for(int i=0; i<ly; i++) {
			for(int j=0; j<=x; j++) {
				if(boundary[i][j]) break;
				region[0]+=map[i][j];
				
				m[i][j]=1;
			}
		}
		min = Math.min(region[0], min);
		max = Math.max(region[0], max);
		
		//2구역
		for(int i=0; i<=ry; i++) {
			for(int j=N-1; j>x; j--) {
				if(boundary[i][j]) break;
				region[1]+=map[i][j];

				m[i][j]=2;
			}
		}

		min = Math.min(region[1], min);
		max = Math.max(region[1], max);
		
		//3구역
		for(int i=ly; i<N; i++) {
			for(int j=0; j<lrx; j++) {
				if(boundary[i][j]) break;
				region[2]+=map[i][j];

				m[i][j]=3;
			}
		}

		min = Math.min(region[2], min);
		max = Math.max(region[2], max);
		
		//4구역
		for(int i=ry+1; i<N; i++) {
			for(int j=N-1; j>=lrx; j--) {
				if(boundary[i][j]) break;
				region[3]+=map[i][j];

				m[i][j]=4;	
			}
		}
		
		min = Math.min(region[3], min);
		max = Math.max(region[3], max);
		
		
		region[4]=total-(region[0]+region[1]+region[2]+region[3]);
		
		min = Math.min(region[4], min);
		max = Math.max(region[4], max);
		
		ans = Math.min(ans, (max-min));

		
	}

}

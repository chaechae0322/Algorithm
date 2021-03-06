package BOJ;
import java.util.Scanner;

public class B10251_DriveTest {
	static int N,M,L,G;
	static int[][] vert;
	static int[][] horz;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0; t<tc; t++) {
			N=sc.nextInt(); M=sc.nextInt();
			L=sc.nextInt(); G=sc.nextInt();
			horz=new int[N][M];
			vert=new int[N][M];
			for(int i=0; i<N; i++) 
				for(int j=0; j<M-1; j++) 
					horz[i][j]=sc.nextInt();
			for(int i=0; i<N-1; i++) 
				for(int j=0; j<M; j++) 
					vert[i][j]=sc.nextInt();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(horz[i][j]+" ");
				}
				System.out.println();
			}
			int ans=Integer.MAX_VALUE;
			for(int i=0; i<M; i++) {
				for(int j=i; j<M; j++) {
					for(int k=j; k<M; k++) {
						ans=Math.min(ans, calc(i,j,k));
					}
				}
			}
			if(ans==Integer.MAX_VALUE) System.out.println("-1");
			else System.out.println(ans);
			
 		}
	}
	private static int calc(int v, int vv, int vvv) {
		System.out.println("v:"+v+" vv:"+vv+" vvv:"+vvv);
		int dis=0, cost=0;
		for(int i=0; i<v; i++) {
			cost+=horz[0][i];
			dis+=10;
		}
		if(v!=0) dis+=1;
		cost+=vert[0][v];
		if(cost>G) return Integer.MAX_VALUE;
		for(int i=v; i<vv; i++) {
			cost+=horz[1][i];
			dis+=10;
		}
		if(v!=vv) dis+=1;
		cost+=vert[1][vv];
		if(cost>G) return Integer.MAX_VALUE;
		for(int i=vv; i<vvv; i++) {
			cost+=horz[2][i];
			dis+=10;
		}
		if(vv!=vvv) dis+=1;
		cost+=vert[2][vvv];
		if(cost>G) return Integer.MAX_VALUE;
		return dis;
	}
}

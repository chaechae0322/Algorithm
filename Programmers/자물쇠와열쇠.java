package Programmers;

import java.util.Arrays;
/*
 * 시뮬레이션
 * 어럽게 생각해서 어렵게 품
 */
public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		int[][] key= {{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
		int[][] lock= {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{0,1,1,1,1}};
		System.out.println(solution(key, lock));
	}
	static int counter[], m, n; 
	static boolean flag;
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		m=key.length; n=lock.length;
		counter=new int[4];
		if(m%2==0) {
			m+=1;
			int[][] nkey=new int[m][m];
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<m-1; j++) nkey[i][j]=key[i][j];
			}
			key=nkey;
		}
		for(int t=0; t<4; t++) {
			int[][] copy=new int[m][m];
			turn(key, copy, t);
			combi(0, copy, lock);
			if(flag) break;
		}
		answer=flag;
		return answer;
	}
	private static void turn(int[][] key, int[][] copy, int t) {

		double ra=0.0, tx=0, ty=0;
		int center=m/2;
		if(t==0) ra=Math.toRadians(0);
		else if(t==1) ra=Math.toRadians(90);
		else if(t==2) ra=Math.toRadians(180);
		else ra=Math.toRadians(270);
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				tx=(float) (Math.cos(ra)*(j-center)-Math.sin(ra)*(i-center))+center;
				ty=(float) (Math.sin(ra)*(j-center)+Math.cos(ra)*(i-center))+center;
				copy[(int)ty][(int)tx]=key[i][j];

			}
		}

	}
	private static void combi(int pos, int[][] copy, int[][] lock) {
		if(flag) return;
		if(pos==4) {
			if(check(copy, lock)) flag=true;
			return;
		}
		for(int i=0; i<m; i++) {
			counter[pos]=i;
			combi(pos+1, copy, lock);
		}
	}
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	private static boolean check(int[][] copy, int[][] lock) {
		int sx=0, ex=m, sy=0, ey=m;
		boolean find=true;
		if(counter[0]>counter[2]) { // 동쪽
			ex-=(counter[0]-counter[2]);
		}else {
			sx+=(counter[2]-counter[0]);
		}
		if(counter[1]>counter[3]) { //남쪽
			ey-=(counter[1]-counter[3]);
		}else {
			sy+=(counter[3]-counter[1]);
		}
		for(int i=0; i<=n-(ey-sy); i++) {
			loop:for(int j=0; j<=n-(ex-sx); j++) {
				find=true;

				for(int ii=0; ii<n; ii++) {
					for(int jj=0; jj<n; jj++) {
						if(lock[ii][jj]==0) {
							if(jj<j||jj>=j+(ex-sx)||ii<i||ii>=i+(ey-sy)||copy[sy+(ii-i)][sx+(jj-j)]==0) {
								find=false;
								continue loop;
							}
						}
					}
				}
				for(int ii=sy; ii<ey; ii++) {
					for(int jj=sx; jj<ex; jj++) {
						if(copy[ii][jj]==1 && lock[i+(ii-sy)][j+(jj-sx)]==1) {
							find=false;
							continue loop;
						}
					}
				}
				if(find) {
					return true;
				}
				sx-=j; ex-=j; sy-=i; ey-=i;
			}
		}
		return false;
	}

}

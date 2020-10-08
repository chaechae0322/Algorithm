package Programmers.CodeChallenge2;

import java.util.Arrays;

public class sol2 {

	public static void main(String[] args) {
		//int [][] arr= {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int [][] arr= {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},
					{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		solution(arr);

	}
	static int one, zero, map[][];
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        map=arr;
        solve(0, map.length, 0, map.length);
        
        answer[0]=zero; answer[1]=one;
        return answer;
    }
	private static void solve(int xs, int xe, int ys, int ye) {
		int pre = map[ys][xs];
		for(int i=ys; i<ye; i++) {
			for(int j=xs; j<xe; j++) {
				if(map[i][j]!=pre) {
					int xm = (xs+xe)/2;
					int ym = (ys+ye)/2;
					solve(xs, xm, ys, ym);
					solve(xm, xe, ys, ym);
					solve(xs, xm, ym, ye);
					solve(xm, xe, ym, ye);
					return;
				}
			}
		}
		if(pre==1) one++;
		else zero++;
	}

}

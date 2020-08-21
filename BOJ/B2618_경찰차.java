package BOJ;
import java.util.ArrayList;
import java.util.Scanner;

public class B2618_경찰차 {
	static int n, num;
	static int[][] map;
	static int[][] dp;
	static ArrayList<int[]> acc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		num=sc.nextInt();
		
		map=new int[n][n];
		dp=new int[4][num];
		int[] tmp=new int[2];
		for(int i=0; i<num; i++) {
			for(int j=0; j<2; j++)
				tmp[j]=sc.nextInt()-1;
			acc.add(tmp.clone());
		}

	}

}

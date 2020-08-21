package SWEA;
import java.util.Scanner;

public class SimpleBinaryCode {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		/////
		int[][] ref= {
				{3,2,1,1},{2,2,2,1},{2,1,2,1},{1,4,1,1},{1,1,3,2},
				{1,2,3,1},{1,1,1,4},{1,3,1,2},{1,2,1,3},{3,1,1,2}
		};
		////
		
		int height, width;
		int [][] area;
		int [] cnt;
		for(int test=1; test<=testcase; test++) {
			height=sc.nextInt();
			width=sc.nextInt();
			area=new int[height][width];
			
			for(int j=0; j<height; j++)
				for(int i=0; i<width; i++)
					area[j][i]=sc.nextInt();

			int idx=0;
			int tmp, num=1, cntidx=0;
			cnt=new int[4];
			while(idx < 8) {
				tmp=area[0][idx*7];
				num=1; cntidx=0;
				for(int i=1; i<7; i++) {
					if(tmp != area[0][i]) {//different
						cnt[cntidx]=num;
						cntidx+=1;
						num=1;
					}
					num+=1;
					tmp=area[0][i];
				}
				cnt[cntidx]=num;
				
				for(int i=0; i<ref.length; i++) {
					for(int j=0; j<4; j++) {
						
					}
				}
				
				
				
				idx+=1;
			}
			
		}

	}

}

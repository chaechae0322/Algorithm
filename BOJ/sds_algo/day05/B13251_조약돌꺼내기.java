package BOJ.sds_algo.day05;

import java.util.Scanner;

public class B13251_조약돌꺼내기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] color=new int[M];
		int total=0;
		for(int i=0; i<M; i++) {
			color[i]=sc.nextInt();
			total+=color[i];
		}
		int K=sc.nextInt();
		if(M==1||K==1) {
			System.out.println(1.0);
			return;
		}
		
		//double res=0.0;
		double ans=0.0;
		for(int i=0; i<M; i++) {
			//int tmp=total;
			double res=1;
			double c=color[i];
			double t=total;
			for(int j=0; j<K; j++) {
				res *= c--/t--;
				
				//System.out.println(res);
			}
			ans+=res;
		}
		System.out.println(ans);
	}

}

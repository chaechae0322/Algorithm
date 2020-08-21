package BOJ.sds_algo.day04;
import java.util.Scanner;

public class B2960_에라토스테네스의체 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		
		int[] map=new int[N+1];
		int cnt=0;
		for(int i=2; i<=N; i++) {
			if(map[i]==0) {
				map[i]=1;
				cnt++;
				if(cnt==K) {
					System.out.println(i);
					return;
				}
				for(int j=2; i*j<=N; j++) {
					if(map[i*j]==0) {
						map[i*j]=1;
						cnt++;
						if(cnt==K) {
							System.out.println(i*j);
							return;
						}
					}
				}
			}
		}

	}

}

package BOJ;

import java.util.Scanner;
/*
 * int 범위 벗어남 주의 => 2^31-1 까지 들어오기때문에 +1만해도 오버플로우남 그래서 left, right도 long 해야한다
 * ans 도 벗어남
 * 0으로 나누기 주의 => start=1 부터 
 * max가 답일때 주의 => max+1 까지
 * 훠...도라방
 */

public class Main {
	static int K,N,lan[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K=sc.nextInt(); N=sc.nextInt(); lan=new int[K];
		int max=0;
		for(int i=0; i<K; i++) {
			lan[i]=sc.nextInt();
			max=Math.max(max, lan[i]);
		}
		binary(1, (long)max+1);  // 까다롭네.. 
		System.out.println(ans);
	}
	static long ans=-1;
	private static void binary(long l, long r) {
		if(l>=r) return;
		
		long mid=(l+r)/2, res=0;
		for(int i=0; i<K; i++) {
			res+=lan[i]/mid;
		}
		
		if(res>=N) {
			ans=mid;
			l=mid+1;
		}else {
			r=mid;
		}
		
		binary(l, r);
	}

}

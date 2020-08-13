package sds_algorithm.day02;

import java.util.Scanner;

public class B2003_수들의합2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		int low=0, high=0;
		int sum=arr[0];
		int ans=0;
		while(low!=N) { // high < N 이걸로 해도 된다 . high가 넘어가면 어차피 정답이 나올수없으므로
			if(M>=sum) {
				if(M==sum) {
					System.out.println(low+" "+high);
					ans++;
				}
				if(high<N-1) {
					high++;
					sum+=arr[high];
				}else {
					sum-=arr[low];
					low++;
				}
			}else {
				sum-=arr[low];
				low++;
			}
		}
		System.out.println(ans);
	}

}

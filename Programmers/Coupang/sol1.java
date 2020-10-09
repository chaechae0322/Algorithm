package Programmers.Coupang;

import java.util.Arrays;

public class sol1 {

	public static void main(String[] args) {
		solution(1000000);

	}
	public static int[] solution(int N) {
		int[] answer = new int[2];
		int max=1, maxk=0;
		for(int k=2; k<10; k++) {
			String res = t(k,N);
			
			int n = 1;
			for(int i=0; i<res.length(); i++) {
				if(res.charAt(i)!='0') {
					n*=(res.charAt(i)-'0');
				}
			}
			System.out.println("k:"+k+" res:"+res+" n:"+n);
			if(max <= n) {
				max=n;
				maxk=k;
			}
		}
		answer[0]=maxk; answer[1]=max;
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	private static String t(int k, int n) {
		int p=1;
		while(p<n) {
			p*=k;
		}
		if(p>k) p/=k;
		StringBuilder sb = new StringBuilder();
		while(true) {
			for(int i=k-1; i>=0; i--) {
				if(p*i<=n) {
					n-=(p*i);
					sb.append(i);
					break;
				}
			}
			if(p==1) break;
			p/=k;
		}
		return sb.toString();
	}

}

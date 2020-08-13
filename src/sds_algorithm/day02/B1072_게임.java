package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int X=Integer.parseInt(token.nextToken());
		int Y=Integer.parseInt(token.nextToken());
		
		if(X==Y) {
			System.out.println(-1);
			return;
		}
		if(X<=10) {
			System.out.println(1);
			return;
		}
		double t=100.0*Y/X;
		long Z=(long)(t);
		long low=0, high=X;
		long tmpz=0;
		long res=Integer.MAX_VALUE;
		while(low<=high) {

			long mid=(low+high)/2;
			System.out.println(low+" "+mid+" "+high);

			t=100.0*(Y+mid)/(X+mid);
			tmpz=(long)(t);
			System.out.println("tmpz:"+tmpz+" Z:"+Z);
			if(Z<tmpz) {
				res=mid;
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		if(res==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}


}

package sds_algorithm.day04;

import java.util.Scanner;

public class B1735_분수의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt();
		int c=sc.nextInt(); int d=sc.nextInt();
		
		int x=a*d+b*c;
		int y=b*d;
		int g=gcd(x, y);
		System.out.println(x/g+" "+y/g);

	}
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return Math.abs(a);
	}

}

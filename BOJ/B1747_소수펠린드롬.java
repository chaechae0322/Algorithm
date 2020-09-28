package BOJ;

import java.util.Scanner;
/*
 * 소수판별
 * 펠린드롬 판별
 */
public class B1747_소수펠린드롬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		while(true) {
			if(prime(n) && perlin(n)) {
				System.out.println(n);
				break;
			}
			n++;
		}

	}

	private static boolean perlin(int n) {
		String in=String.valueOf(n);
		int l=0, r=in.length()-1;
		while(l<=r) {
			if(in.charAt(l)!=in.charAt(r)) {
				return false;
			}
			l++; r--;
		}
		return true;
	}

	private static boolean prime(int n) {
		if(n<2) return false;
		for(int i=2; i<=(int)(Math.sqrt(n)); i++) {	
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}

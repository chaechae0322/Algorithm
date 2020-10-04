package BOJ;

import java.util.Arrays;
/*
 * 순열 연습
 */
public class permutation {
	public static void main(String[] args) {
		perm("hello","");
		myperm("hello");
	}

	private static void myperm(String str) {
		char[] crr=str.toCharArray();
		p(crr, 0, 0);

	}

	private static void p(char[] crr, int pos, int cnt) {
		if(pos==crr.length) System.out.println(Arrays.toString(crr));
		else {
			for(int i=pos; i<crr.length; i++) {
				swap(pos,i,crr);
				p(crr,pos+1,cnt+1);
				swap(pos,i,crr);
			}
		}
	}

	private static void swap(int pos, int i, char[] crr) {
		char t=crr[pos];
		crr[pos]=crr[i];
		crr[i]=t;

	}

	private static void perm(String str, String pre) {
		if(str.length()==0) System.out.println(pre);
		else {
			for(int i=0; i<str.length(); i++) {
				String rem=str.substring(0,i)+str.substring(i+1);
				perm(rem, pre+str.charAt(i));
			}
		}
	}

}

package programmers;

import java.util.Arrays;

public class problem1_11╧Ь╟║ {

	public static void main(String[] args) {
		String S= "wreawerewa";
		String pattern = "ware";
		
		int front = 0; int end=pattern.length()-1;
		int[] pmark = new int[26];
		for(int i=0; i<pattern.length(); i++) {
			pmark[pattern.charAt(i)-'a']++;
		}
		
		int[] mark = new int[26];
		for(int i=front; i<=end; i++) {
			if(pmark[S.charAt(i)-'a']>0) {
				mark[S.charAt(i)-'a']++;
			}
		}
		
		System.out.println((Arrays.toString(pmark)));
		System.out.println((Arrays.toString(mark)));
		
		
		int answer=0;
		boolean isSame=true;
		for(int i=0; i<pmark.length; i++)
			if(pmark[i]>0) {
				if(mark[i]!=1) {
					System.out.println("╬ф╢оющ╬ф");
					isSame=false;
					break;
				}
				
			}
		
		if(isSame) answer++;
		
		for(int i=end+1; i<S.length(); i++) {
			System.out.println(S.charAt(i));
			isSame=true;
			
			if(pmark[S.charAt(i)-'a']>0) { //front
				mark[S.charAt(i)-'a']++;
			}
			System.out.println(S.charAt(i-pattern.length()));
			if(mark[S.charAt(i-pattern.length())-'a']>0)mark[S.charAt(i-pattern.length())-'a']--; //queue
			
			System.out.println((Arrays.toString(mark)));
			
			for(int j=0; j<pmark.length; j++)
				if(pmark[j]>0) {
					if(mark[j]!=pmark[j]) {
						System.out.println("╬ф╢оющ╬ф");
						isSame=false;
						break;
					}
					
				}
			
			if(isSame) {
				System.out.println("same");
				answer++;
			}
		}
		
		System.out.println(answer);

	}
	
	

}

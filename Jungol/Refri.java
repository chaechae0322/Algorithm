package Jungol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Refri{
	static int n;
	static class info implements Comparable<info>{
		int start,end;

		public info(int start, int end) {
			this.start=start;
			this.end=end;
		}
		
		@Override
		public int compareTo(info o) {
			return this.end>o.end? 1: -1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		ArrayList<info> list=new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int st=sc.nextInt();
			int et=sc.nextInt();
			list.add(new info(st,et));
		}
		
		//����
		Collections.sort(list);
		
		int ans=0;
		for(int i=0; i<list.size(); i++) {
			System.out.println("���� st:"+list.get(i).start +" et:"+list.get(i).end);
			int et=list.get(i).end;
			for(int j=i+1; j<list.size(); j++) {
				int st2=list.get(j).start;
				int et2=list.get(j).end;
				
				if(et>=st2 && et<=et2) {
					System.out.println("���Եȴ� st2:"+st2+" et2:"+et2);
					list.remove(j);
					j--;
				}
			}
			ans++;
		}
		System.out.println(ans);
		
	}
}
package CtCILibrary.Ch03_StackAndQueue;

import java.util.Stack;
/*
 * stack
 */
public class Q3_05_StackSort {

	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random()*1000+1);
			s.push(r);
		}
		
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

	private static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while(!s.isEmpty()) {
			
			int t=s.pop();
			int cnt=0;
			while(!r.isEmpty()&&r.peek()>t) {
				cnt++;
				s.add(r.pop());
			}
			r.push(t);
			while(cnt>0) {
				r.push(s.pop());
				cnt--;
			}			
		}
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
	}

}

package BOJ;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class B1406_에디터 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int m=sc.nextInt();
		Deque<Character> st1=new LinkedList<>(); 
		Stack<Character> st2=new Stack<>(); 
		for(int i=0; i<s.length(); i++) st1.add(s.charAt(i));
		for(int i=0; i<m; i++) {
			char ins=sc.next().charAt(0);
			if(ins=='P') {
				char x=sc.next().charAt(0);
				st1.add(x);
			}else {
				if(ins=='L') { // 커서를 왼쪽으로 옮김
					if(!st1.isEmpty()) {
						st2.add(st1.pollLast());
					}
				}else if(ins=='D') { // 커서를 오른쪽으로
					if(!st2.isEmpty()) {
						st1.add(st2.pop());
					}
				}else if(ins=='B') { // 커서왼쪽꺼 삭제
					if(!st1.isEmpty()) {
						st1.pollLast();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!st1.isEmpty()) {
			sb.append(st1.pollFirst());
		}
		while(!st2.isEmpty()) {
			sb.append(st2.pop());
		}
		System.out.println(sb.toString());
	}

}

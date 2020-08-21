package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10828_스택 {
	static int[] st;
	static int top=-1;
	static void push(int x) {
		st[++top]=x;
	}
	static int empty() {
		if(top==-1) return 1;
		else return 0;
	}
	static int pop() {
		if(top==-1) return -1;
		else return st[top--];
	}
	static int top() {
		if(top==-1) return -1;
		else return st[top];
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st=new int[N+1];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			switch (input) {
			case "pop":
				System.out.println(pop());
				break;
			case "top" :
				System.out.println(top());
				break;
			case "size":
				System.out.println(top+1);
				break;
			case "empty":
				System.out.println(empty());
				break;
			default:
				push(Integer.parseInt(input.split(" ")[1]));
				break;
			}
			
		}

	}

}

package sds_algorithm.day01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class B3425_고스택 {
	static List<String> oper;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\sds_algorithm\\day01\\p3425_input.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			oper=new ArrayList<>();
			st=new Stack<>();
			String tmp=br.readLine();
			if(tmp.equals("QUIT")) break;
			
			while(!tmp.equals("END")) {
				oper.add(tmp);
				tmp=br.readLine();
			}
			int N=Integer.parseInt(br.readLine());
			if(N==0) {
				solve();
			}
			for(int i=0; i<N; i++) {
				st.add(Integer.parseInt(br.readLine()));
				solve();
				st.clear();
			}
			br.readLine();
			System.out.println();
		}

	}
	static Stack<Integer> st;
	private static void solve() {
		if(oper.size()==0) {
			System.out.println(st.pop());
			return;
		}
		
		for(int i=0; i<oper.size(); i++) {
			String op=oper.get(i);
			//System.out.println(op);
			if(op.contains("NUM")) {
				//System.out.println(op);
				st.add(Integer.parseInt(op.split(" ")[1]));
			}else if(op.equals("POP")) {
				if(st.isEmpty()) {
					System.out.println("ERROR");
					return;
				}
				st.pop();
			}else if(op.equals("SWP")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				st.add(x);
				st.add(y);
			}else if(op.equals("DUP")) {
				if(st.isEmpty()) {
					System.out.println("ERROR");
					return;
				}
				
				st.add(st.peek());
				
			}else if(op.equals("INV")) {
				if(st.isEmpty()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				st.add((-1)*x);
			}else if(op.equals("ADD")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				long res=(long)x+(long)y;
				if(Math.abs(res)>Math.pow(10, 9)) {
					System.out.println("ERROR");
					return;
				}
				st.add((int)res);
				
			}else if(op.equals("SUB")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				long res=y-x;
				if(Math.abs(res)>Math.pow(10, 9)) {
					System.out.println("ERROR");
					return;
				}
				st.add((int)res);
			}else if(op.equals("MUL")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				long res=(long)x*(long)y;
				if(Math.abs(res)>Math.pow(10, 9)) {
					System.out.println("ERROR");
					return;
				}
				st.add((int)res);
			}else if(op.equals("DIV")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				boolean minus=false;
				if(x==0) {
					System.out.println("ERROR");
					return;
				}
				if(x<0&&y>0 || x>0&&y<0) minus=true; 
				long res=Math.abs(y)/Math.abs(x);
				if(Math.abs(res)>Math.pow(10, 9)) {
					System.out.println("ERROR");
					return;
				}
				if(minus)
					st.add((int)res*(-1));
				else 
					st.add((int)res);
			}else if(op.equals("MOD")) {
				if(!isSize()) {
					System.out.println("ERROR");
					return;
				}
				int x=st.pop();
				int y=st.pop();
				boolean minus=false;
				if(x==0) {
					System.out.println("ERROR");
					return;
				}
				if(y<0) minus=true; 
				long res=Math.abs(y)%Math.abs(x);
				if(Math.abs(res)>Math.pow(10, 9)) {
					System.out.println("ERROR");
					return;
				}
				if(minus)
					st.add((int)res*(-1));
				else 
					st.add((int)res);
			}
		}
		if(st.size()!=1) {
			System.out.println("ERROR");
			return;
		}
		else
			System.out.println(st.pop());
	}
	static boolean isSize() {
		return st.size()>=2;
	}

}
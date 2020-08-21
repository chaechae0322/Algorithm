package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static class Node{
		String data;
		int left, right;
		public Node(String data, int left, int right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	static int n;
	static Node[] list;
	static boolean isValid=true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=10;
		for(int t=1; t<=tc; t++) {
			isValid=true;
			String line=br.readLine();
			n=Integer.parseInt(line);
			
			list= new Node[n+1];
			
			String[] tmp=null;
			for(int i=0; i<n; i++) {
				line=br.readLine();
				tmp=line.split(" ");
				
				if(tmp.length == 4) {
					
					if(tmp[1].charAt(0)>='0' && tmp[1].charAt(0)<='9') {
//						System.out.println("testcase:"+tc+" "+line);
						isValid=false;
//						break;
					}
					
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
				}else if(tmp.length == 3) {
//					System.out.println("testcase:"+tc+" "+line);
					isValid=false;
//					break;
					
				}
				else {
					if(tmp[1] =="+" || tmp[1] =="-" || tmp[1] =="*" || tmp[1]=="/") {
//						System.out.println("testcase:"+tc+" "+line);
						isValid=false;
//						break;
					}
					
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1], -1, -1);
				}
			}
			
//			int ans = postOrderArithmetic(1);
			
			if(isValid)
				System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}

	}
	static int postOrderArithmetic(int idx) {
		
		boolean leaf = true;
		
		int left=0, right=0;
		if(list[idx].left != -1) {
			leaf = false;
			left = postOrderArithmetic(list[idx].left);
			right = postOrderArithmetic(list[idx].right);
		}
		
		

		
		int res;
		String data = list[idx].data;
		switch(data) {
		case "+": 
			if(leaf) {isValid=false; return -1;} 
			res = left+right; break;
		case "-": 
			if(leaf) {isValid=false; return -1;} 
			res = left-right; break;
		case "*": 
			if(leaf) {isValid=false; return -1;} 
			res = left*right; break;
		case "/": 
			if(leaf) {isValid=false; return -1;} 
			try {
			res = left/right; break;
			}catch(ArithmeticException e) {
				isValid=false;
				return -1;
			}
		default : res=Integer.parseInt(list[idx].data);
		}
		
		return res;

	}

}

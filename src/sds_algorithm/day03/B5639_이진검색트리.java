package sds_algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639_이진검색트리 {
	static class Node{
		int value;
		Node left, right, parent;
		public Node(int value) {
			this.value=value;
		}
	}
	static Node head;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		int num=0;
		head=new Node(0);
		Node pos=head;
		int N=0;
		//Node parent=head;
		//try {
			while((input = br.readLine())!=null && input.length() != 0) {
				num=Integer.parseInt(input);
				if(N==0) {
					head = new Node(num);
					N++;
					continue;
				}
				insert(head, num);
			}
		//} catch (Exception e) {
			//System.out.println(head.left.value);
			postOrderTravers(head);
		//	return;
		//} 

	}
	private static void insert(Node pos, int num) {
		//System.out.println("insert "+num);
		if(pos.value > num) {
			
			if(pos.left==null) {
				pos.left=new Node(num);
			}else {
				insert(pos.left, num);
			}
		}else {
			if(pos.right==null) {
				pos.right=new Node(num);
			}else {
				insert(pos.right, num);
			}
		}
		
	}
	private static void postOrderTravers(Node n) {
		
		if(n.left!=null)postOrderTravers(n.left);
		if(n.right!=null)postOrderTravers(n.right);
		visit(n);
	}
	private static void visit(Node n) {
		System.out.println(n.value);
	}

}

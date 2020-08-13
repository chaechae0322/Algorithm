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
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		int num=0;
		head=new Node(0);
		Node pos=head;
		int N=0;
		//Node parent=head;
		try {
			while((input = br.readLine())!=null) {
				//System.out.println("dd");
				num=Integer.parseInt(input);
				if(N==0) {
					pos.left=new Node(num);
					pos=pos.left;
					pos.parent=head;
				}else {
					if(pos.value>num) {
						pos.left = new Node(num);
						pos.left.parent = pos;
						pos=pos.left;
						
						System.out.println("parent:"+pos.parent.value+" pos:"+pos.value);
					}else {
						insert(num, pos);
					}
				}
				
				N++;
			}
		} catch (Exception e) {

			/*pos=pos.right;
			System.out.println(pos.value);
			pos=pos.right;
			System.out.println(pos.value);
			pos=pos.right;
			System.out.println(pos.left+" "+pos.right);*/
			postOrderTravers(head.left);
			return;
		} 

	}
	private static void insert(int num, Node pos) {
		if(pos.left==null && pos.right==null) {
			pos=new Node(num);
			pos.parent=pos;
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

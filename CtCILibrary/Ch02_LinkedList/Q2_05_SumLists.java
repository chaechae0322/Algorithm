package CtCILibrary.Ch02_LinkedList;

public class Q2_05_SumLists {
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
		}
		public Node(int data, Node prev) {
			prev.next=this;
			this.data=data;
		}
		public void printForward() {
			Node t=this;
			while(t!=null) {
				System.out.print(t.data+" -> ");
				t=t.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Node lA1 = new Node(3);
		Node lA2 = new Node(1, lA1);
		
		Node lB1 = new Node(5);
		Node lB2 = new Node(9, lB1);
		Node lB3 = new Node(1, lB2);	
		
		Node list3 = addLists(lA1, lB1);
		
		lA1.printForward(); 		
		lB1.printForward(); 		
		list3.printForward(); 		
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
	private static int linkedListToInt(Node lA1) {
		int res=0;
		Node cu=lA1;
		while(cu!=null) {
			res+=cu.data;
			res*=10;
			cu=cu.next;
		}
		return res/10;
	}
	private static Node addLists(Node lA1, Node lB1) {
		int lenA=len(lA1);
		int lenB=len(lB1);
		if(lenA>lenB) {
			while(lenB<lenA) {
				lB1=padding(lB1,0);
				lenB++;
			}
		}else if(lenB>lenA) {
			while(lenA<lenB) {
				lA1=padding(lA1,0);
				lenA++;
			}
		}
		
		int carry = addListHelper(lA1,lB1);
		if(carry>0) {
			Node t=new Node(carry);
			t.next=result;
			result=t;
		}
		return result;
	}
	static Node result;
	private static int addListHelper(Node lA1, Node lB1) {
		if(lA1==null&&lB1==null) return 0;
		int val=lA1.data+lB1.data+addListHelper(lA1.next, lB1.next);
		int carry=val/10;
		Node t=new Node(val%10);
		t.next=result;
		result=t;
		return carry;
	}
	private static Node padding(Node lA1, int data) {
		Node tmp=new Node(data);
		tmp.next=lA1;
		return tmp;
	}
	private static int len(Node lB1) {
		if(lB1==null) return 0;
		return len(lB1.next)+1;
	}
}

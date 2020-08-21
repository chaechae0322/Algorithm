package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inorder {
	static class Node{
		char data;
		int left, right;
		public Node(char data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	
	static int n;
	static Node[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for(int t=1; t<=tc; t++) {
			String line=null;
			line=br.readLine();
			
			n=Integer.parseInt(line);
			list=new Node[n+1];
			
			String[] tmp=null;
			for(int i=0; i<n; i++) {
				line=br.readLine();
				tmp=line.split(" ");
				
				if(tmp.length == 4) {
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1].charAt(0), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
				} else if(tmp.length == 3){
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1].charAt(0), Integer.parseInt(tmp[2]), -1);
				} else {
					list[Integer.parseInt(tmp[0])] = new Node(tmp[1].charAt(0), -1, -1);
				}
			}
			
			System.out.print("#"+t+" ");
			inOrderTravers(1);
			System.out.println();
		}
		

	}
	private static void inOrderTravers(int idx) {
		
		if(idx < 0) return;
		
		inOrderTravers(list[idx].left);
		System.out.print(list[idx].data);
		inOrderTravers(list[idx].right);
	}

}

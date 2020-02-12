import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arithmetic {
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=10;
		for(int t=1; t<=tc; t++) {
			String line=br.readLine();
			n=Integer.parseInt(line);
			
			list= new Node[n+1];
			
			String[] tmp=null;
			for(int i=0; i<n; i++) {
				line=br.readLine();
				tmp=line.split(" ");
				
				if(tmp.length == 4) {
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
				}
//				}else if(tmp.length == 3) {
//					list[Integer.parseInt(tmp[0])] = 
//							new Node(tmp[1], Integer.parseInt(tmp[2]), -1);
//				}
				else {
					list[Integer.parseInt(tmp[0])] = 
							new Node(tmp[1], -1, -1);
				}
			}
			
			int ans = postOrderArithmetic(1);
			System.out.println("#"+t+" "+ans);
			
			
		}

	}
	static int postOrderArithmetic(int idx) {
		
		
		
		int left=0, right=0;
		if(list[idx].left != -1) {
			left = postOrderArithmetic(list[idx].left);
			right = postOrderArithmetic(list[idx].right);
		}
		
		

		
		int res;
		String data = list[idx].data;
		switch(data) {
		case "+": res = left+right; break;
		case "-": res = left-right; break;
		case "*": res = left*right; break;
		case "/": res = left/right; break;
		default : res=Integer.parseInt(list[idx].data);
		}
		
		return res;

	}

}

package SWEA;
import java.util.Scanner;

public class Solution3289 {
	static int n;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();	
		
		
		for(int t=1; t<=tc; t++) {
			
			System.out.print("#"+t+" ");
			
			n=sc.nextInt();
			int m=sc.nextInt();
			
			p=new int[n+1];
			makeSet();
			
			int[] oper=new int[3];
			for(int i=0; i<m; i++) {
				
				for(int j=0; j<3; j++) {
					oper[j]=sc.nextInt();
				}
				
				if(oper[0]==0) {
					unionSet(oper[1],oper[2]);
				} 
				else {
					if(p[findSet(oper[1])] == p[findSet(oper[2])]) {
						System.out.print("1");
					} else {
						System.out.print("0");
					}
				}
			}
			
			System.out.println();
		}

	}
	private static void makeSet() {
		for(int i=1; i<=n; i++)
			p[i]=i;
		
	}
	private static int findSet(int i) {
		if(i==p[i]) return i;
		
		int idx=findSet(p[i]);
		p[i]=idx;
		return idx;
	}
	private static void unionSet(int i, int j) {
		i=findSet(i);
		j=findSet(j);
		p[j]=i;
	}

}

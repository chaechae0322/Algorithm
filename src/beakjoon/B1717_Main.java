import java.util.Scanner;

public class B1717_Main {
	static int n,m;
	static int[] r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		r=new int[n+1];
		for(int i=0; i<=n; i++) {
			r[i]=i;
		}
		
		int sel=0, a=0, b=0;
		for(int i=0; i<m; i++) {
			sel=sc.nextInt();
			a=sc.nextInt();
			b=sc.nextInt();
			
			if(sel==0) {
				if(a>b) {
					int tmp=a;
					a=b;
					b=tmp;
				}
				
				unionSet(a,b);
			}
			else {// check
				if(findSet(a)==findSet(b)) {
					System.out.println("YES");
				}
				else
					System.out.println("NO");
				
			}
			
			
			
			
		}

	}
	private static void unionSet(int a, int b) {
		a=findSet(r[a]);
		b=findSet(r[b]);
		if(a==b) return;
		r[b]=a;
		
	}
	private static int findSet(int x) {
		if(r[x]==x) return x;
		r[x]=findSet(r[x]);
		return r[x];
	}

}

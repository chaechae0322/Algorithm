package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;

public class B1043_Liar {
	static int N,M;
	static int[] r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		r=new int[N+1];
		for(int i=0; i<=N; i++) r[i]=i;
		
		int num=sc.nextInt();
		
		int tmp=0, a=0, b=0;
		ArrayList<Integer> know=new ArrayList<>();
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int i=0; i<num; i++) {
			tmp=sc.nextInt();
			know.add(tmp);
			//r[tmp]=-tmp;
		}
		
		for(int i=0; i<M; i++) {
			party[i]=new ArrayList<>();
			tmp=sc.nextInt();
			if(tmp==0) continue;
			
			a=sc.nextInt();
			party[i].add(a);
			
			if(tmp<2) continue;
			
			for(int j=0; j<tmp-1; j++) {
				b=sc.nextInt();
				party[i].add(b);
				
				if(findSet(r[a])!=findSet(r[b])) {
					unionSet(a,b);
				}
			}
		}
		
		boolean[] check = new boolean[N+1];
		for(int i=0; i<know.size(); i++) {
			check[findSet(r[know.get(i)])]=true;
		}
		
		boolean flag=true;
		int res=0;
		for(int i=0; i<M; i++) {
			if(party[i].size()==0) {
				res++;
				continue;
			}
			flag=true;
			for(int j=0; j<party[i].size(); j++) {
				tmp=party[i].get(j);
				if(check[findSet(r[tmp])]){
					flag=false;
					break;
				}
			}
			
			if(flag) res++;
		}
		System.out.println(res);

		sc.close();
	}
	
	private static void unionSet(int a, int b) {
		a=findSet(r[a]);
		b=findSet(r[b]);
		if(a==b) return;
		r[b]=a;
	}
	private static int findSet(int a) {
		if(a==r[a]) return a;
		int idx=findSet(r[a]);
		r[a]=idx;
		return r[a];
	}

}

package beakjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B2623_음악프로그램 {
	static int N,M;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		
		list=new ArrayList[M];
		boolean[] check = new boolean[N+1];
		
		int tmp=0;
		for(int i=0; i<M; i++) {
			int n = sc.nextInt();
			list[i]=new ArrayList<>();
			for(int j=0; j<n; j++) {
				tmp=sc.nextInt();
				check[tmp]=true;
				list[i].add(tmp);
			}
		}
		
		solve(check);

	}

	private static void solve(boolean[] check) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> dellist = new ArrayList<>();
		boolean[] anscheck=new boolean[N+1];
		for(;;) {
			int front=0;
			boolean isdel=true;
			boolean out=true;
			for(int i=0; i<M; i++) {
				if(list[i].size()==0) {
					out=true;
					continue;
				}
				front=list[i].get(0);
				isdel=true;
				System.out.println("i:"+i+" front:"+front);
				
				for(int j=0; j<M; j++) {
					System.out.println("j:"+j);
					if(i==j) continue;
					
					if(list[j].size()==0) {
						System.out.println("size 0 break");
						continue;
					}
					
					System.out.println("j:"+j+" front:"+list[j].get(0));
					
					if((list[j].contains(front) && list[j].get(0)==front)) {
						dellist.add(j);
						isdel=true;
					}
					if(list[j].contains(front) && list[j].get(0)!=front) {
						isdel=false;
					}
				}
				System.out.println("isdel:"+isdel);
				if(isdel) {
					out=false;
					dellist.add(i);
					anscheck[front]=true;
					ans.add(front);
					for(int j=0; j<dellist.size(); j++) {
						list[dellist.get(j)].remove(0);
					}
					
					System.out.println("after delete");
					for(int tt=0; tt<M; tt++) {
						for(int ttt:list[tt]) System.out.print(ttt+" ");
						System.out.println();
					}
				}
				dellist.clear();
			}
			System.out.println("out:"+out);
			
			
			if(out) break;
		}
		
		for(int t : ans) {
			//System.out.println(t);
			check[t]=false;
		}
		for(int i=1; i<=N; i++) {
			if(check[i]) {
				System.out.println(0); return;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!anscheck[i])
				ans.add(i);
		}
		
		for(int t : ans) 
			System.out.println(t);
		
		
		
		
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1062_Teach{
	static int n,k;
	static ArrayList<Character> list;
	static String[]	words;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		System.out.println("n:"+n+" k:"+k);
		if(k<5) {
			System.out.println("0");
			return;
		}else if(k==26) {
			System.out.println(n);
			return;
		}
		words=new String[n];
		list=new ArrayList<>();
		char c='\u0000';
		for(int i=0; i<n; i++) { //자율주행, 
			String tmp=sc.next();
			words[i]=tmp;
			for(int j=0; j<tmp.length(); j++) {
				c=tmp.charAt(j);
				if(!list.contains(c)) list.add(c);
			}
			//System.out.println();
		} 
		
		boolean[] visited=new boolean[list.size()];
		comb(0,visited,0, new ArrayList<Character>());
		System.out.println(answer);
	}
	static int answer;
	private static void comb(int idx, boolean[] visited, int cnt, ArrayList<Character> clist) {
		if(cnt==k) {
			for(int i=0; i<clist.size(); i++) System.out.print(clist.get(i));
			System.out.println();
			
			int res=0;
			outer:for(int i=0; i<n; i++) {
				String tmp=words[i];
				for(int j=0; j<tmp.length(); j++) {
					if(!clist.contains(tmp.charAt(j))) {
						continue outer;
					}
				}
				System.out.println("되는 단어:"+tmp);
				res++;
			}
			answer=Math.max(answer, res);
			
			return;
		}
		if(idx==visited.length) return;
		
		visited[idx]=true;
		clist.add(list.get(idx));
		comb(idx+1, visited, cnt+1, clist);
		visited[idx]=false;
		clist.remove(clist.size()-1);
		comb(idx+1, visited, cnt, clist);
		
	}
}
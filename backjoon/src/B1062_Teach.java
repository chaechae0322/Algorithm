import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class B1062_Teach{
	static int n,k;
	static ArrayList<Character> list;
	static String[]	words;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
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
		for(int i=0; i<n; i++) {
			String tmp=sc.next();
			words[i]=tmp;
			for(int j=0; j<tmp.length(); j++) {
				c=tmp.charAt(j);
				if(!list.contains(c)) list.add(c);
			}
		} 
		
		boolean[] visited=new boolean[list.size()];
		HashMap<Character, Integer> map= new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)=='a' || list.get(i)=='c' || list.get(i)=='i' || list.get(i)=='t' || list.get(i)=='n') {
				map.put(list.get(i), 1);
				visited[i]=true;
			}
		}
		
		
		comb(0,visited,0, map);
		System.out.println(answer);
	}
	static int answer;
	private static void comb(int idx, boolean[] visited, int cnt, HashMap<Character, Integer> map) {
		//System.out.println("idx:"+idx);
		if(cnt>k-5) {
			return;
		}
		
		if(idx==visited.length) {
			//Set<Character> keyset = map.keySet();
			//System.out.println(keyset.toString());
			int res=0;
			outer:for(int i=0; i<n; i++) {
				String tmp=words[i];
				for(int j=0; j<tmp.length(); j++) {
					if(!map.containsKey(tmp.charAt(j))) {
						continue outer;
					}
				}
				res++;
			}
			answer=Math.max(answer, res);
			
			return;
		}
		
		if(visited[idx]) {
			comb(idx+1, visited, cnt, map);
			return;
		}
		
		visited[idx]=true;
		map.put(list.get(idx), 1);
		comb(idx+1, visited, cnt+1, map);
		visited[idx]=false;
		map.remove(list.get(idx));
		comb(idx+1, visited, cnt, map);
		
	}
}
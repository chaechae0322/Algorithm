import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class B16638_BraketAdd2 {
	static int n,N;
	static int[] arr;
	static char[] oper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		n=N/2+1;
		arr=new int[n];
		oper=new char[n-1];
		
		String str=br.readLine();
		if(str.length()==1) {
			System.out.println(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(i%2==0) arr[i/2]=str.charAt(i)-'0';
			else oper[i/2]=str.charAt(i);
		}
		
		ans=Integer.MIN_VALUE;
		for(int i=1; i<=n/2; i++) {
			int[] visited=new int[n];
			dfs(0,0,i,visited); 
		}
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos, int cnt, int limit, int[] visited) {
		if(cnt==limit) {
			//System.out.println(Arrays.toString(visited));
			ans=Math.max(ans, makeNumber(visited));
			return;
		}
		if(pos==n) return;

		if(pos<n-1) {
			visited[pos]=1;
			visited[pos+1]=2;
			dfs(pos+2, cnt+1, limit, visited);
		}
		visited[pos]=0;
		dfs(pos+1, cnt, limit, visited);
	}
	private static int makeNumber(int[] visited) {
		//System.out.println(Arrays.toString(oper));
		ArrayList<Character> list=new ArrayList<>();
		for(int i=0; i<N; i++) {
			//System.out.println("i:"+i);
			if(i%2==0) {
				if(visited[i/2]==1) {
					//System.out.println("dd");
					list.add('(');
					list.add((char)(arr[i/2]+'0'));
				}
				else if(visited[i/2]==2) {
					list.add((char)(arr[i/2]+'0'));
					list.add(')');
				}
				else list.add((char)(arr[i/2]+'0'));
					
			}
			else {
				list.add(oper[i/2]);
			}
		}
		
		/*for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();*/
		
		long res=0, prior=-1;
		long s1=0, s2=0;
		char oper='\u0000';
		Stack<String> st=new Stack<>();
		for(int i=0; i<list.size(); i++) {
			String tmp=list.get(i)+"";
			//System.out.println(tmp);
			
			if(tmp.equals("(")) {
				prior=-1;
				st.push(tmp);
			}
			else if(tmp.equals("+")||tmp.equals("-")) {
				if(prior>=1) {
					s1=Integer.parseInt(st.pop());
					oper=st.pop().charAt(0);
					s2=Integer.parseInt(st.pop());
					
					if(oper=='+') res=s1+s2;
					else if(oper=='-') res=s2-s1;
					else if(oper=='*') res=s1*s2;
					
					st.push(res+"");
				}
				st.push(tmp);
				prior=1;
			}
			else if(tmp.equals("*")) {
				st.push(tmp);
				prior=2;
			}
			
			else if(tmp.equals(")")) {
				s1=Integer.parseInt(st.pop());
				oper=st.pop().charAt(0);
				s2=Integer.parseInt(st.pop());
				st.pop();
				
				if(!st.isEmpty()) {
					if(st.peek().equals("*")) {
						prior=2;
					}
					else if(st.peek().equals("+")||st.peek().equals("-")) {
						prior=1;
					}
				}
				else prior=-1;
				
				if(oper=='+') res=s1+s2;
				else if(oper=='-') res=s2-s1;
				else if(oper=='*') res=s1*s2;
				
				st.push(res+"");
			}
			
			else st.push(tmp);
		}
		
		while(st.size()>1) {
			s1=Integer.parseInt(st.pop());
			oper=st.pop().charAt(0);
			s2=Integer.parseInt(st.pop());
			//st.pop();

			if(oper=='+') res=s1+s2;
			else if(oper=='-') res=s2-s1;
			else if(oper=='*') res=s1*s2;

			st.add(res+"");
		}
		//System.out.println("res:"+res);
		return (int)res;
	}

}

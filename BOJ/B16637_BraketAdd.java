package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B16637_BraketAdd {
	static int n, N;
	static int[] arr;
	static char[] oper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		n=N/2+1;
		arr=new int[n];
		oper=new char[n-1];
		
		String str=br.readLine();
		if(str.length()==1) {
			System.out.println(str);
			return;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(i%2==0) {//수
				arr[i/2]=str.charAt(i)-'0';
			}else {//연산자
				oper[i/2]=str.charAt(i);
			}
		}
		
		ans=Integer.MIN_VALUE;
		for(int i=1; i<=n/2; i++) {
			int[] visited=new int[n];
			dfs(0, 0,i,visited, false);
		}
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos, int cnt, int limit, int[] visited, boolean isopen) {
		if(cnt==limit) {
			ans=Math.max(ans, makeNumber(visited));
			return;
		}
		
		if(pos==n) return;
		
		/*if(!isopen) {
			visited[pos]=1;
			dfs(pos+1, cnt, limit, visited, true);
		}else {
			visited[pos]=2;
			dfs(pos+1, cnt+1, limit, visited, false);
		}*/
		if(pos<n-1) {
			visited[pos]=1;
			visited[pos+1]=2;
			dfs(pos+2, cnt+1, limit, visited, true);
		}
		visited[pos]=0;
		dfs(pos+1, cnt, limit, visited, isopen);
	}
	
	private static int makeNumber(int[] visited) {
		//System.out.println(Arrays.toString(visited));
		
		ArrayList<Character> crr=new ArrayList<>();
		//System.out.println("수식:"+crr);
		
		int s1=0, s2=0, res=arr[0];
		int idx=0;
		while(idx<N) {
			if(idx%2==0) {
				res=arr[idx/2];
				if(visited[idx/2]==1) {
					
					while(true) {
						s1=res;
						s2=arr[idx/2+1];
						if(oper[idx/2]=='+') {
							res=s1+s2;
						}
						else if(oper[idx/2]=='-') {
							res=s1-s2;
						}
						else if(oper[idx/2]=='*') {
							res=s1*s2;
						}
						else if(oper[idx/2]=='/') {
							res=s1/s2;
						}
						idx+=2;
						if(visited[idx/2]==2) break;
					}
				}
				crr.add((char)(res+'0'));
			}
			else {
				crr.add(oper[idx/2]);
			}
			idx++;
		}
		
		res=crr.get(0)-'0';
		for(int i=0; i<crr.size()-2; i+=2) {
			s1=res;
			char oper=crr.get(i+1);
			s2=crr.get(i+2)-'0';
			
			if(oper=='+') {
				res=s1+s2;
			}
			else if(oper=='-') {
				res=s1-s2;
			}
			else if(oper=='*') {
				res=s1*s2;
			}
			else if(oper=='/') {
				res=s1/s2;
			}
			
		}
		
		//System.out.println("res:"+res);
		return res;
	}

}

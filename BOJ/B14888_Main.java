package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14888_Main {
	static int n;
	static int[] su;
	static char[] oper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		su=new int[n];
		oper=new char[n-1];
		
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			su[i]=Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(br.readLine());
		int idx=0;
		for(int i=0; i<4; i++) {
			int tmp=Integer.parseInt(token.nextToken());
			for(int j=0; j<tmp; j++) {
				if(i==0) oper[idx++]='+';
				else if(i==1) oper[idx++]='-';
				else if(i==2) oper[idx++]='*';
				else if(i==3) oper[idx++]='/';
			}
		}
		
		//System.out.println(Arrays.toString(oper));
		
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		
		perm(0,0);
		//System.out.println("cnt:"+cnt);
		System.out.println(max);
		System.out.println(min);
	}
	static int min;
	static int max;
	static int cnt;
	public static void perm(int pos, int depth) {
		if(pos==n-1) {
			cnt++;
			//System.out.println(Arrays.toString(oper));
			
			int res=cal();
			min=Math.min(min, res);
			max=Math.max(max, res);
			
			return;
		}
		for(int i=pos; i<n-1; i++) {
			//System.out.println("pos:"+pos+" i:"+i);
			if(pos!=depth && oper[pos]==oper[i]) continue;
			swap(pos,i);
			perm(pos+1, depth+1);
			swap(pos,i);
		}
		
	}
	private static void swap(int pos, int i) {
		char tmp=oper[i];
		oper[i]=oper[pos];
		oper[pos]=tmp;
		
	}
	private static int cal() {
		int s1=su[0];
		int s2=0;
		char op='\u0000';
		int res=s1;
		for(int i=0; i<n-1; i++) {
			op=oper[i];
			s2=su[i+1];
			
			if(op=='+') res=s1+s2;
			else if(op=='-') res=s1-s2;
			else if(op=='*') res=s1*s2;
			else if(op=='/') res=s1/s2;
			
			//System.out.println("s1:"+s1+" s2:"+s2+" res:"+res);
			
			s1=res;
		}
		return res;
	}


}

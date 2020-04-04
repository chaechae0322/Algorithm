import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution1244_2 {
	static int ans;
	static HashMap<String , Integer> memo;
	static int[] D;
	public static void main(String[] args) {
		
		// ¿ÏÅ½ memo
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int limit=0;
		String str="";
		for(int test=1; test<=testcase; test++) {
			memo = new HashMap<String, Integer>();
			str=sc.next();
			limit=sc.nextInt();
			D=new int[limit];

			bp(str, 0, limit);
			System.out.println("#"+test+" "+ans);
			ans=0;

		}

	}
	
	static void bp(String s, int cnt, int limit) {

		int calc=0;
		for(int i=0; i<s.length(); i++) {
			calc+=(s.charAt(i)-'0')*Math.pow(10, s.length()-i-1);
		}
		
		
		if(cnt==limit) {
			
			
			if(memo.containsKey(s)) {
				calc=memo.get(s);
			}
			else {
				memo.put(s, calc);
			}
			if(calc > ans)
				ans=calc;
			return;
		}
		
		if(D[cnt] < calc)
			D[cnt]=calc;
		else
			return;
		

		
		//ºñÆ® Å½»ö
		int tmp,tmp2, two=0;
		int[] idxs=new int[s.length()];
		for(tmp =1; tmp<(1<<s.length()); tmp++) {
			two=0; 
			tmp2=tmp;
			
			//System.out.println(tmp);
			for(int i=0; i<s.length(); i++) {
				if(two > 2) break;
				if((tmp2 & 1)==1) {
					idxs[two]=i;
					two+=1;
				}
				tmp2 >>= 1;
			}
			
			if(two==2) {
				//swap
				char[] tmpch=s.toCharArray();
				char t=tmpch[idxs[0]];
				tmpch[idxs[0]]=tmpch[idxs[1]];
				tmpch[idxs[1]]=t;
				
				String copys="";
				for(int i=0; i<tmpch.length; i++)
					copys+=tmpch[i];
				bp(copys, cnt+1, limit);
			}
		}
	}
}

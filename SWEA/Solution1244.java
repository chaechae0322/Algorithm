package SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1244 {
	static int ans;
	public static void main(String[] args) {
		
		// �׸��� ���
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int limit=0;
		String str="";
		for(int test=1; test<=testcase; test++) {
			str=sc.next();
			limit=sc.nextInt();
			char[] chars=str.toCharArray();
			//System.out.println(Arrays.toString(chars));
			
			recursiveGreedy(chars, 0, 0, limit);
			
			System.out.println("#"+test+" "+ans);
			ans=0;
		}

	}
	
	static void recursiveGreedy(char[] chars, int idx, int cnt, int limit) {
		//System.out.println(Arrays.toString(chars));
		if(cnt == limit) {
			//calc
			//System.out.println(Arrays.toString(chars));
			int calc=0;
			for(int i=0; i<chars.length; i++) {
				calc+=(chars[i]-'0')*Math.pow(10, chars.length-i-1);
			}
			if(calc > ans)
				ans=calc;
			return;
		}
		
		if(idx >= chars.length-2) {
			char[] tmp=chars.clone();
			if(idx==chars.length-2) {
				char t=tmp[idx];
				tmp[idx]=tmp[idx+1];
				tmp[idx+1]=t;
			}
			else if(idx==chars.length-1){
				char t=tmp[idx];
				tmp[idx]=tmp[idx-1];
				tmp[idx-1]=t;
			}
			//System.out.println(Arrays.toString(tmp));
			recursiveGreedy(tmp, idx, cnt+1, limit);
		}
		
		int max=-1;
		for(int i=idx; i<chars.length; i++) {
			if(chars[i]-'0' > max)
				max=chars[i]-'0';
		}
		//System.out.println("idx: "+idx +" max: "+max);
		
		if(idx < chars.length-1 && chars[idx]-'0' == max)
			recursiveGreedy(chars, idx+1, cnt, limit);
		
		for(int i=idx+1; i<chars.length; i++) {
			if(chars[i]-'0'==max) {
				//System.out.println(i);
				//swap
				char[] tmp=chars.clone();
				char t=tmp[idx];
				tmp[idx]=tmp[i];
				tmp[i]=t;
				//System.out.println(Arrays.toString(tmp));
				recursiveGreedy(tmp, idx+1, cnt+1, limit);
			}
		}
		
	}

}

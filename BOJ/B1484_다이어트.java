package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1484_다이어트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g=sc.nextInt();
		int l=1, r=g;
		ArrayList<Integer> ans=new ArrayList<Integer>();
		while(l<r) {
			long res=l*r;
			if(res==g) {
				if((l+r)%2==0) {
					ans.add((l+r)/2);
				}
				l++;
			}else if(res>g) {
				r--;
			}else {
				l++;
			}
		}
		if(ans.size()==0) {
			System.out.println(-1);
		}
		else {
			Collections.sort(ans);	
			for(int res: ans)
				System.out.println(res);
		}
	}

}

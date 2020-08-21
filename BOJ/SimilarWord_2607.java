package BOJ;
import java.util.ArrayList;
import java.util.Scanner;

public class SimilarWord_2607 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String ref=null;
		ref=sc.next();

		String tmp=null;
		int ans=0;
		for(int i=0; i<n-1; i++) {
			tmp = sc.next();

			if(compare(tmp, ref)) {
//				System.out.println(tmp);
				ans+=1;
			}
		}
		System.out.println(ans);


	}

	static boolean compare(String tmp, String ref) {
		int lendiff=tmp.length()-ref.length();

		boolean similar=true;

		if(lendiff < -1 || lendiff > 1) 
			return false;

		
		ArrayList<Character> refarr=new ArrayList<>();
		ArrayList<Character> tmparr=new ArrayList<>();
		
		for(int i=0; i<ref.length(); i++)
			refarr.add(ref.charAt(i));
		
		for(int i=0; i<tmp.length(); i++)
			tmparr.add(tmp.charAt(i));
		
		if(refarr.size() >= tmparr.size()) {
			for(int i=0; i<tmparr.size(); i++) {
				for(int j=0; j<refarr.size(); j++) {
					if(refarr.get(j) == tmparr.get(i)) {
						refarr.remove(j); break;
					}
				}
			}
			
			if(refarr.size() > 1) {
				similar=false;
			}
		}else {
			// ref
			for(int i=0; i<ref.length(); i++) {
				for(int j=0; j<tmparr.size(); j++) {
					if(tmparr.get(j) == refarr.get(i)) {
						tmparr.remove(j); break;
					}
				}
			}
			if(tmparr.size() > 1) {
				similar=false;
			}
		}
	

		return similar;
	}

}

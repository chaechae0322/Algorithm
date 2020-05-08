package programmers;

public class 현카3 {

	public static void main(String[] args) {
		String[] a = {
				"bird99", "bird98", "bird101", "gotoxy"
		};

		solution(a, "bird98");
	}

	static String[] ref;
	public static String solution(String[] registered_list, String new_id) {
		String answer = "";
		ref = registered_list;

		String S ="";
		int n=0;
		
		int idx=0;

		for(int k=0; k<new_id.length(); k++) {
			idx=k;
			
			if( new_id.charAt(k)>='a' && new_id.charAt(k)<='z') {
				idx++;
			}
			else {
				
				System.out.println(new_id.charAt(k));
				//break;
				
				//S = new_id.substring(0, k);

				
				n = Integer.parseInt(new_id.substring(k, new_id.length()));
				break;
				
			}
		}
		
		S = new_id.substring(0, idx);
		if(idx == new_id.length()-1) n=0;

		System.out.println(S+Integer.toString(n));

		ans = new_id;
		for(int i=0; i<registered_list.length; i++) {
			if(registered_list[i].equals(new_id)) {
				dfs(S, n+1);
			}
		}
		
		System.out.println(ans);
		answer = ans;
		return answer;
	}
	static boolean flag = false;
	static String ans;
	private static void dfs(String S, int n) {
		//if(flag) return;

		String new_id = S+Integer.toString(n);
		
		System.out.println("dfs new_id:"+new_id);
		
		for(int i=0; i<ref.length; i++) {
			if(ref[i].equals(new_id)) {
				dfs(S, n+1);
			}
		}
		
		if(flag) return;

		flag = true;
		ans = new_id;
	}

}

package programmers;

public class 괄호변환 {

	public static void main(String[] args) {
		System.out.println(solution(")("));

	}

    public static String solution(String p) {
        String answer = "";
        int open=0;
        for(int i=0; i<p.length(); i++) {
        	if(p.charAt(i)=='(') {
        		open++;
        	}else if(p.charAt(i)==')') {
        		open--;
        	}
        	if(open==0) {
        		answer = solve(p.substring(0, i+1), p.substring(i+1, p.length()));
        		break;
        	}
        }
        return answer;
    }

	private static String solve(String u, String v) {
		System.out.println(u+" "+v);
		
		if(u.charAt(0)==')' || u.charAt(u.length()-1)=='(') { //균형잡힌
			StringBuilder br = new StringBuilder();
			br.append("(");
			if(v.length()>0) {
				int open=0;
				String res="";
		        for(int i=0; i<v.length(); i++) {
		        	if(v.charAt(i)=='(') {
		        		open++;
		        	}else if(v.charAt(i)==')') {
		        		open--;
		        	}
		        	if(open==0) {
		        		res = solve(v.substring(0, i+1), v.substring(i+1, v.length()));
		        		br.append(res);
		        		break;
		        	}
		        }
			}
			br.append(")");
			for(int i=1; i<u.length()-1; i++) {
				if(u.charAt(i)=='(') br.append(")");
				else br.append("(");
			}
			System.out.println("check");
			System.out.println(br.toString());
			return br.toString();
			
		}else { //올바른
			if(v.length()==0) {
				return u;
			}
			
			int open=0;
			String res="";
	        for(int i=0; i<v.length(); i++) {
	        	if(v.charAt(i)=='(') {
	        		open++;
	        	}else if(v.charAt(i)==')') {
	        		open--;
	        	}
	        	if(open==0) {
	        		res = solve(v.substring(0, i+1), v.substring(i+1, v.length()));
	        		break;
	        	}
	        }
	        System.out.println("check2 : "+(u+res));
	        return u+res;
		}
		//return "";
	}
}

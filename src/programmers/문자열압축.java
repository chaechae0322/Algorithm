package programmers;

public class 문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("xababcdcdababcdcd"));

	}
	static public int solution(String s) {
		int answer = 0;
		if(s.length()==1) {
			return 1;
		}
		StringBuilder br= new StringBuilder();
		int start=0;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=s.length()/2; i++) {
			
			int st=0;
			int cnt=1;
			String ref=s.substring(st, st+i);
			for(int j=i; j<s.length(); j+=i) {
				if(j+i>s.length()) {
					System.out.println("j:"+j);
					if(cnt>1) {
						br.append(Integer.toString(cnt));
						br.append(ref);
						br.append(s.substring(j, s.length()));
					}else {
						br.append(ref);
						br.append(s.substring(j, s.length()));
					}
					
					break;
				}
				String tmp=s.substring(j, j+i);
				
				if(ref.equals(tmp)) {
					cnt++;
					if(i+j==s.length()) {
						if(cnt>1) {
							br.append(Integer.toString(cnt));
						}
						br.append(ref);
					}
				}else {
					if(cnt>1) {
						br.append(Integer.toString(cnt));
					}
					cnt=1;
					br.append(ref);
					ref=tmp;
					
					if(i+j==s.length()) {
						
						br.append(ref);
					}
					
					System.out.println("new ref:"+ref);
				}
				System.out.println("ref:"+ref+" tmp:"+tmp+" cnt:"+cnt);
			}
			System.out.println("i:"+i+"  compression:"+br.toString());
			min=Math.min(min, br.length());
			br.delete(0, br.length());
		}
		
		return min;
	}

}

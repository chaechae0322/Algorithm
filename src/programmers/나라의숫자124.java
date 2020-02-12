package programmers;

public class 나라의숫자124 {

	public static void main(String[] args) {
		
		for(int i=1; i<=20; i++)
			solution(i);

	}

	public static String solution(int n) {
		String answer = "";

		int moc=0,nam=0;
		while(n>0) {
			moc=n/3;
			nam=n%3;
			System.out.println("moc:"+moc+" nam:"+nam+" n:"+n);
			if(nam==0) {
				moc-=1;
				nam=4;
			}
			n=moc;
			answer = Integer.toString(nam)+answer;
			
		}
		System.out.println(answer);
		return answer;
	}

}

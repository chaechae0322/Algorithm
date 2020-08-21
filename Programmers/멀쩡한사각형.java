package Programmers;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8,12));

	}
	
	public static long solution(int w, int h) {
		long answer = 0;
		long lined =0 ;
		
		int gcd = findgcd(w,h);
		System.out.println("gcd: "+gcd);
		if(gcd == -1) {
			lined = (long)(w+h-1);
		}else {
			long tmp = (long)(w/gcd+h/gcd-1);
			lined = tmp*(w/(w/gcd));
			
			System.out.println("lined:"+lined);
		}
		answer = (long)w*(long)h - lined;
		return answer;
	}

	private static int findgcd(int w, int h) {
		for(int i=(w>h)?h:w; i>=0; i--) {
			if(w%i==0 && h%i==0) {
				return i;
			}
		}
		return -1;
	}

}

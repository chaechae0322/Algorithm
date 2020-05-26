package programmers;

public class 썸머코딩2 {

	public static void main(String[] args) {
		long n = (long) Math.pow(10, 10);
		System.out.println(solution(n));

	}
	
	public static long solution(long n) {
        long answer = 0;
        String binary = Long.toBinaryString(n);
        long len = binary.length();
        
        for(int i=0; i<len; i++) {
        	if(binary.charAt(i)=='1') {
        		answer += Math.pow(3, len-1-i);
        	}
        	 
        }
        
        return answer;
    }

}

package Programmers;

public class 키패드누르기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));

	}
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int lx=0, ly=3, rx=2, ry=3;
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
        	
        	if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
        		lx=0; ly=numbers[i]/3;
        		sb.append("L");
        		
        	}else if(numbers[i]==2||numbers[i]==5||numbers[i]==8||numbers[i]==0) {
        		int h=0;
        		switch(numbers[i]) {
        		case 2: h=0; break;
        		case 5: h=1; break;
        		case 8: h=2; break;
        		default: h=3; break;
        		}
        		
        		int ld=Math.abs(1-lx)+Math.abs(h-ly), rd=Math.abs(1-rx)+Math.abs(h-ry);
        		if(ld>rd) {
        			rx=1; ry=h;
        			sb.append("R");
        		}else if(ld<rd) {
        			lx=1; ly=h;
        			sb.append("L");
        		}else {
        			if(hand.equals("left")) {
        				lx=1; ly=h;
        				sb.append("L");
        			}
        			else {
        				rx=1; ry=h;
        				sb.append("R");
        			}
        		}
        	}else {
        		rx=2; ry=(numbers[i]-1)/3;
        		sb.append("R");
        	}
        }
        answer=sb.toString();
        return answer;
    }

}

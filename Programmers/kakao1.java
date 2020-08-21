package Programmers;

public class kakao1 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));

	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
        String answer = "";
        
        
        int leftx = 0, lefty=3;
        int rightx = 2, righty=3;
        
        for(int i=0; i<numbers.length; i++) {
        	int tmp = numbers[i]-1;
        	if(tmp == 0||tmp==3||tmp==6) {
        		leftx = tmp%3;
        		lefty = tmp/3;
        		sb.append("L");
        	}else if(tmp == 2||tmp==5||tmp==8) {
        		rightx = tmp%3;
        		righty = tmp/3;
        		sb.append("R");
        	}
        	else {
        		if(tmp==-1) tmp = 10;
        		System.out.println("tmp:"+tmp);
        		System.out.println("left x, y :"+leftx+" "+lefty);
        		System.out.println("right x, y :"+rightx+" "+righty);
        		int leftdist = Math.abs(leftx-tmp%3)+Math.abs(lefty-tmp/3);
        		int rightdist = Math.abs(rightx-tmp%3)+Math.abs(righty-tmp/3);
        		System.out.println(leftdist+" "+rightdist);
        		
        		if(leftdist > rightdist) { //오른쪽이 더 가까울때
        			rightx = tmp%3;
            		righty = tmp/3;
            		sb.append("R");
        		}else if (leftdist < rightdist) {
        			leftx = tmp%3;
            		lefty = tmp/3;
            		sb.append("L");
        		}else { //거리 같을때
        			if(hand.equals("right")) {
        				rightx = tmp%3;
                		righty = tmp/3;
                		sb.append("R");
        			}else {
        				leftx = tmp%3;
                		lefty = tmp/3;
                		sb.append("L");
        			}
        		}
        	}
        }
        
        answer = sb.toString();
        return answer;
    }
}

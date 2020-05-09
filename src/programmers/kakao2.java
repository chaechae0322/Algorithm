package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class kakao2 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));

	}
	
	static String expre;
	
	public static long solution(String expression) {
        long answer = 0;
        
        expre = expression;
        /*boolean[] oper = new boolean[3]; // * + -
        int cnt =0;
        for(int i=0; i<expression.length(); i++) {
        	if(expression.charAt(i)=='*') {
        		oper[0]=true;
        		cnt++;
        	}else if(expression.charAt(i)=='+') {
        		oper[1]=true;
        		cnt++;
        	}else if(expression.charAt(i)=='-') {
        		oper[2]=true;
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
        char[] operlist = new char[cnt];
        int idx=0;
        for(int i=0; i<oper.length; i++) {
        	if(oper[i]) {
        		if(i==0) operlist[idx++]='*';
        		else if(i==1) operlist[idx++]='+';
        		else if(i==2) operlist[idx++]='-';
        	}
        }
        
        System.out.println(Arrays.toString(operlist));*/
        char[] operlist = {'*','+','-'};
        
        doPerm(operlist, 0);
        answer = ans;
        
        return answer;
    }
	static long ans;
	public static void doPerm(char[] arr, int loc) {
		//Kick
		if(loc == arr.length) {
			//calc(arr);
			System.out.println(Arrays.toString(arr));
			
			long res = calc(arr);
			ans = Math.max(res, ans);
			
			return; 
		}
		
		for(int i=loc; i<arr.length; i++) {
			swap(arr, loc, i);
			doPerm(arr, loc+1);
			swap(arr, loc, i);   
		}
	}

	private static long calc(char[] arr) {
		String[] su = expre.split("\\*|\\+|\\-");
		System.out.println(expre);
		Queue<Character> operq= new LinkedList<>();
		for(int i=0; i<expre.length(); i++) {
			//System.out.println(expre.charAt(i));
			if(expre.charAt(i)=='*'||expre.charAt(i)=='+'||expre.charAt(i)=='-') {
				operq.add(expre.charAt(i));
			}
		}
		System.out.println(operq.size());
		
		String[] exp = new String[su.length+operq.size()];
		exp[0]=su[0];
		int idx=0;
		while(!operq.isEmpty()) {
			exp[++idx] = (operq.poll()).toString();
			exp[++idx] = su[idx/2];
		}
		
		System.out.println(Arrays.toString(exp));
		
		
		
		Stack<Long> sust = new Stack<>();
		Stack<Character> operst = new Stack<>();
		
		for(int i=0; i<exp.length; i++) {
			String tmp = exp[i];
			
			if(tmp.equals("*")||tmp.equals("+")||tmp.equals("-")) {
				if(operst.isEmpty()) {
					operst.add(tmp.charAt(0));
				}
				else if(!operst.isEmpty() && getPriority(operst.peek(), arr) >= getPriority(tmp.charAt(0), arr)) {
					long su1 = Long.parseLong(exp[i+1]);
					long su2 = sust.pop();
					
					char p = tmp.charAt(0);
					if(p=='*') sust.add(su1*su2);
					else if(p=='+') sust.add(su1+su2);
					else if(p=='-') sust.add(su2-su1);
					continue;
				}
			}
			else {
				sust.add(Long.parseLong(tmp));
			}
		}
		
		/*sust.add(Integer.parseInt(su[0]));
		while(!operq.isEmpty()) {
			char tmp = operq.poll();
			if(operst.isEmpty()) {
				operst.add(tmp);
			}
			else if(!operst.isEmpty() && getPriority(operst.peek(), arr) > getPriority(tmp, arr)) {
				
			}
			
			operst.add(operq.poll());
		}*/
		
		
		return 0;
	}

	private static int getPriority(char tmp, char[] arr) {
		int res=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==tmp) {
				res=i; break;
			}
				
		}
		return res;
	}


	private static void swap(char[] arr, int loc, int i) {
		char tmp = arr[loc];
		arr[loc]=arr[i];
		arr[i]=tmp;
	}
	
	

}

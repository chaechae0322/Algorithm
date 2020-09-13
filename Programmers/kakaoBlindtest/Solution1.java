package Programmers.kakaoBlindtest;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution("abcdefghijn....p"));

	}
    public static String solution(String new_id) {
    	//String match="[^0-9a-z.p{-} \\p{_}]";
    	//String match="~!@#$%^&*()=+[{]}:?,<>";
        //String answer = new_id.toLowerCase().trim().replaceAll("~!@#[$]%\\^&[*]\\(\\)=[+]\\[\\{\\]\\}:?,<>", "");
    	String answer = new_id.trim().toLowerCase();//.replaceAll("\\p{match}", "");
        StringBuilder sb = new StringBuilder();
        int idx=0, n=answer.length();
        while(idx<n) {
        	System.out.println(idx+" "+answer.charAt(idx));
        	if(answer.charAt(idx)=='.') {
        		if(sb.length()==0||sb.charAt(sb.length()-1)!='.') {
        			System.out.println("dd");
        			sb.append(".");
        			idx++;
        		}else {
        			System.out.println("이미");
        			idx++;
        		}
        	}else if(answer.charAt(idx)-'a'>=0 && answer.charAt(idx)-'a'<26){
        		sb.append(answer.charAt(idx));
        		idx++;
        	}else if(answer.charAt(idx)-'0'>=0 && answer.charAt(idx)-'0'<10) {
        		sb.append(answer.charAt(idx));
        		idx++;
        	}else if(answer.charAt(idx)=='-'||answer.charAt(idx)=='_') {
        		sb.append(answer.charAt(idx));
        		idx++;
        	}else {
        		idx++;
        	}
        }
        System.out.println(sb.toString());
        if(sb.toString().length()==0) {
        	sb.append("a");
        }else {
        	if(sb.charAt(0)=='.') {
        		sb.deleteCharAt(0);
        	}
        	if(sb.toString().length()>1 && sb.charAt(sb.length()-1)=='.') {
        		sb.deleteCharAt(sb.length()-1);
        	}
        	if(sb.toString().length()==0) {
            	sb.append("a");
            }
        }
        System.out.println(sb.toString());
        if(sb.toString().length()>=16) {
        	
        	answer=sb.toString().substring(0,15);
        	if(answer.charAt(answer.length()-1)=='.') {
        		answer=answer.substring(0,14);
        	}
        }else if(sb.length()<=2) {
        	System.out.println(sb.length());
        	char t=sb.charAt(sb.length()-1);
        	while(sb.toString().length()<3) {
        		sb.append(t);
        	}
        	answer=sb.toString();
        }else {
        	answer=sb.toString();
        }
        
        return answer;
    }

}

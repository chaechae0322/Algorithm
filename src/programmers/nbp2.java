package programmers;

import java.util.Stack;

public class nbp2 {

	public static void main(String[] args) {
		System.out.println(solution("2(2(hi)2(co))x2(bo)"));

	}


	static public String solution(String compressed) {

		String answer = "";

		Stack<String> st = new Stack<>();

		int n = compressed.length();
		boolean start = false;
		StringBuilder strsb = new StringBuilder();
		StringBuilder intsb = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder answersb = new StringBuilder();

		int open = 0;
		//int close = 0;

		Stack<String> tmpst = new Stack<>();
		for(int i=0; i<n; i++) {
			if(compressed.charAt(i) == ')') {

				open--;

				if(strsb.length() !=0) {
					System.out.println("넣을 str: "+strsb.toString());

					st.add(strsb.toString());
					strsb.delete(0, strsb.length());
				}

				//꺼내기
				System.out.println("st size: "+st.size());
				while(!st.isEmpty()) {
					String tmp = st.pop();
					System.out.println(tmp);

					if(tmp.charAt(0) >= '0' && tmp.charAt(0) <= '9') {
						//숫자
						while(!tmpst.isEmpty()) {
							sb.append(tmpst.pop());
						}

						int times = Integer.parseInt(tmp);

						String ttstr = sb.toString();
						System.out.println("ttstr : "+ ttstr);
						System.out.println("times : "+times);
						sb.delete(0, sb.length());
						for(int j=0; j<times; j++) {
							sb.append(ttstr);
						}
						//strsb.append(sb.toString());
						System.out.println("만들어진 단어: "+sb.toString());
						st.add(sb.toString());

						/*if(open == 0) {
							System.out.println("term done");
							answersb.append(sb.toString());
							st.clear();
						}*/

						sb.delete(0, sb.length());

						break;

					}else {
						tmpst.add(tmp);
					}
				}
			}

			else if(compressed.charAt(i) == '(') {

				open++;

				System.out.println("넣을 int: "+intsb.toString());
				st.add(intsb.toString());
				intsb.delete(0, intsb.length());

				continue;
			}else if(compressed.charAt(i) >= 'a' && compressed.charAt(i) <= 'z'){

				/*if(open == 0) {
					//st.add(compre)
					answersb.append(compressed.charAt(i));
					continue;
				}*/
				//start = true;
				strsb.append(compressed.charAt(i));
			} else if(compressed.charAt(i) >= '0' && compressed.charAt(i) <= '9') {
				intsb.append(compressed.charAt(i));

				if(strsb.length() != 0) {
					st.add(strsb.toString());
					strsb.delete(0, strsb.length());
				}
			}


		}

		//answersb.append(st.pop());

		while(!st.isEmpty()) {

			answersb.insert(0, st.pop());
			//answersb.append(tmp, idx, tmp.length());
			//answersb.append

		}

		if(strsb.length()!=0) {
			answersb.append(strsb.toString());
		}

		//answer = st.pop();
		answer = answersb.toString(); 

		return answer;
	}

}

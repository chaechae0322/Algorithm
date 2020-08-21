package Programmers;

public class Line1 {

	public static void main(String[] args) {
		String inputString = ">_<";
		char[] open = {'(','{','[','<'};
		char[] close = {')','}',']','>'};
		int[] opencheck = new int [4];
		int[] closecheck = new int [4];
		int[] check=new int[4]; //1:open, 2:close
		boolean[] order = new boolean[4];
		int answer=0;
		
		loop:for(int i=0; i<inputString.length(); i++) {
			char tmp = inputString.charAt(i);
			for(int j=0; j<4; j++) {
				if(tmp==open[j]) {
					opencheck[j]+=1;
				}
				else if(tmp==close[j]) {
					if(closecheck[j]<opencheck[j])
						closecheck[j]+=1;
					else {
						//return -1
						answer=-1;
						break loop;
					}
				}
			}
		}
		
		for(int i=0; i<4; i++) {
			if(opencheck[i]!=closecheck[i]) {
				answer=-1;
				break;
			}
			else {
				answer+=opencheck[i];
			}
		}
		
		System.out.println(answer);

	}

}

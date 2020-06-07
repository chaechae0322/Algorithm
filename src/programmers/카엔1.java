package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카엔1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		boolean[] type= new boolean[5]; //0 : 열자리이상, 1:영어 대, 2:영어 소, 3: 숫자, 4: 특수문자
		
		if(input.length>=10) type[0]=true;
		for(int i=0; i<input.length; i++) {
			if(input[i]>='a'&& input[i]<='z')
				type[2]=true;
			else if(input[i]>='A'&& input[i]<='Z')
				type[1]=true;
			else if(input[i]>='0'&& input[i]<='9')
				type[3]=true;
			else type[4]=true;
		}
		
		int level = 0;
		for(int i=0; i<5; i++) {
			if(type[i]) level++;
		}
		System.out.print("LEVEL"+level);
		System.out.println();

	}

}

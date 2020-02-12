package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B1157_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		line=line.toUpperCase();

		int[] alpa=new int['z'-'a'+2];
		for(int i=0; i<line.length(); i++) {
			alpa[line.charAt(i)-'A']++;
		}
		
		//System.out.println(Arrays.toString(alpa));
		
		int max=0,idx=-1;
		for(int i=0; i<alpa.length; i++) {
			if(max<alpa[i]) {
				max=alpa[i];
			}
		}
		//System.out.println("max:"+max);
		
		
		for(int i=0; i<alpa.length; i++) {
			if(max==alpa[i]) {
				//System.out.println(i+" "+idx);
				if(idx!=-1) {
					System.out.println("?");
					return;
				}else {
					idx=i;
				}
			}
		}
		
		System.out.println((char)(idx+'A'));
	}

}

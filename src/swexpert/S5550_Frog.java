import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5550_Frog {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		loop:for(int t=1; t<=tc; t++) {
			String line=br.readLine();
			char[] crr=line.toCharArray();
			int[] frog=new int[11];
			int cnt=0;
			
			int tmp=0;
			boolean correct=false;
			for(int i=0; i<crr.length; i++) {
				correct=false;
				if(crr[i]=='c') tmp=1;
				else if(crr[i]=='r') tmp=2;
				else if(crr[i]=='o') tmp=3;
				else if(crr[i]=='a') tmp=4;
				else if(crr[i]=='k') tmp=5;
				
				for(int j=0; j<cnt; j++) {
					if(frog[j]==tmp-1) {
						correct=true;
						frog[j]++;
						if(frog[j]==5) frog[j]=0;
						break;
					}
				}
				if(!correct && tmp==1) {
					frog[cnt++]=1;
				}
				else if(!correct && tmp>1) {
					System.out.println("#"+t+" -1");
					continue loop;
				}
				
				//System.out.println("crr:"+crr[i]+" tmp:"+tmp+" frog"+Arrays.toString(frog));
			}
			
			for(int i=0; i<cnt; i++) {
				if(frog[i]!=0) {
					System.out.println("#"+t+" -1");
					continue loop;
				}
			}
			System.out.println("#"+t+" "+cnt);
			
		}
		
	}

}

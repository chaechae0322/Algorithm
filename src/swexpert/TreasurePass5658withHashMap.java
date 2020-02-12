import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TreasurePass5658withHashMap {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase=sc.nextInt();
		int n, k;
		
		for(int test=1; test<=testcase; test++) {
			n=sc.nextInt();
			k=sc.nextInt();
			String pass=sc.next();
			
			char[] passchar=pass.toCharArray();
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			int[] numbers=new int[4*(n/4)];
			char tmp; String tmp2;
			int sum=0, idx=0;
			System.out.println(pass);
			
			for(int i=0; i<n/4; i++) { //for ratation
				for(int j=0; j<n; j+=(n/4)) { //4 times
					sum=0;
					tmp2="";
					for(int l=0; l<n/4; l++) { //make number
						tmp2+=passchar[j+l];
						tmp=passchar[j+l];
						if(tmp>='0' && tmp<='9') {sum+=(Math.pow(16, n/4-l-1) * (tmp-'0'));}
						else {sum += (Math.pow(16, n/4-l-1)*(tmp-'A'+10));}

					}
					//System.out.println(Arrays.toString(tmp));
					if(map.containsKey(tmp2)==false) {
						map.put(tmp2, 1); numbers[idx++]=sum;
					}
					//System.out.println(Arrays.toString(numbers));
				}
				rotate(passchar);
			}
			selectSortRev(numbers);
			System.out.println(Arrays.toString(numbers));
			System.out.println("#"+test+" "+numbers[k-1]);
		}
		

	}

	private static void rotate(char[] tmp) {
		
		char t=tmp[tmp.length-1];
		for(int i=tmp.length-1; i>0; i--) {
			tmp[i]=tmp[i-1];
		}
		tmp[0]=t;
		//return Arrays.toString(tmp);
	}
	
	private static void selectSortRev(int[] numbers) {
		int max, maxidx,tmp;
		for(int i=numbers.length-1; i>0; i--) {
			max=numbers[i];
			maxidx=i;
			for(int j=i; j>=0; j--) {
				if(max > numbers[j])
				{
					max=numbers[j];
					maxidx=j;
				}
			}
			if(maxidx != i) {
				//System.out.println("i:"+i+" minidx:"+maxidx);
				tmp=numbers[i];
				numbers[i]=numbers[maxidx];
				numbers[maxidx]=tmp;
			}
		}
		
	}

}

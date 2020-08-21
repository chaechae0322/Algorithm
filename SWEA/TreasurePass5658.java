package SWEA;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 
12 10
1B3B3B81F75E
16 2
F53586D76286B2D8
 */
public class TreasurePass5658 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase=sc.nextInt();
		int n, k;
		
		for(int test=1; test<=testcase; test++) {
			n=sc.nextInt();
			k=sc.nextInt();
			String pass=sc.next();
			char[] passchar=new char[pass.length()];
			
//			System.out.println(n/4);
			
			for(int i=0; i<pass.length(); i++)
				passchar[i]=pass.charAt(i);
			
			int[] numbers=new int[4*(n/4)];
			int n1,idx=0;
			
			//extrack numbers
			boolean equal=false;
			for(int ro=0; ro<n/4; ro++) {
				for(int i=0; i<4; i++) {
					int tmp=0;
					equal=false;
					for(int j=0; j<n/4; j++) {
						n1=getnumber(passchar[i*(n/4)+j]);
						//System.out.println(n1);
//						System.out.println(n1*(16^j));
						tmp+=n1*(Math.pow(16, n/4-1-j));
						//System.out.println(tmp);
					}
					//System.out.println(tmp);
					for(int j=0; j<idx; j++)
						if(numbers[j]==tmp) {
							equal=true;
							break;
						}
					if(equal==false)
						numbers[idx++]=tmp;
				}
				rotationString(passchar);
			}
			//sort
			//Arrays.sort(numbers, Comparator.reverseOrder());
			selectSortRev(numbers);
			//System.out.println(Arrays.toString(numbers));
			System.out.println("#"+test+" "+numbers[k-1]);
		}

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

	private static void rotationString(char[] pass) {
		char tmp=pass[pass.length-1];
		for(int i=pass.length-1; i>0; i--) 
			pass[i]=pass[i-1];
		pass[0]=tmp;
		
	}

	static int getnumber(char c) {
		int out=0;
		if(c>='0' && c<='9')
			out=c-'0';
		else if(c>='A' && c<='F')
			out=c-'A'+10;
		return out;
	}

}

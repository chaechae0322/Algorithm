package SWEA;
import java.util.Scanner;

public class View_solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase=10;
		
		int[] arr;
		int width=0, ans=0;
		for(int test=1; test<=testcase; test++) {
			width=sc.nextInt();
			arr=new int[width];
			
			for(int i=0; i<width; i++) {
				arr[i]=sc.nextInt();
			}
			
			int view=0;
			for(int i=2; i<width-2; i++) {
				view=0;
				for(int j=i-2; j<=i+2; j++) {
					if(i != j) {
						if(arr[j] > view)
							view=arr[j];
					}
				}
				ans+=((view < arr[i])? (arr[i]-view) : 0);
			}
			
			System.out.println("#"+test+" "+ans);
			ans=0;
			
		}

	}

}

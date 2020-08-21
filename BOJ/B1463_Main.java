package BOJ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1463_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		//boolean[] visited=new boolean[1000000+1];
		//visited[n]=true;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {n,0});
		
		int ans=0;
		int t=0;
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			System.out.println(Arrays.toString(tmp));
			
			if(tmp[0]==1) {
				ans=tmp[1];
				break;
			}
			
			if(tmp[0]%3==0) {
				t=tmp[0]/3;
				q.add(new int[] {t, tmp[1]+1});
			}
			if(tmp[0]%2==0) {
				t=tmp[0]/2;
				q.add(new int[] {t, tmp[1]+1});
			}
			
			t=tmp[0]-1;
			q.add(new int[] {t, tmp[1]+1});
			
		}
		
		System.out.println(ans);
		
	}

}

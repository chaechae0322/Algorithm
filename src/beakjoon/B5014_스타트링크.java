package beakjoon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014_스타트링크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F=sc.nextInt();
		int S=sc.nextInt();
		int G=sc.nextInt();
		int U=sc.nextInt();
		int D=sc.nextInt();
		
		if(S==G) {
			System.out.println("0");
			return;
		}
		
		Queue<int[]> q=new LinkedList<>();
		boolean[] visited=new boolean[1000001];
		visited[S]=true;
		q.add(new int[] {S,0});
		int answer=-1;
		
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			System.out.println(Arrays.toString(tmp));
			
			int ts = tmp[0]+U;
			if(ts==G) {
				answer=tmp[1]+1;
				break;
			}
			if(ts<=F  && !visited[ts]) {
				q.add(new int[] {ts, tmp[1]+1});
				visited[ts]=true;
			}
			ts= tmp[0]-D;
			if(ts==G) {
				answer=tmp[1]+1;
				break;
			}
			if(ts>0 && !visited[ts]) {
				q.add(new int[] {ts, tmp[1]+1});
				visited[ts]=true;
			}
		}
		
		if(answer>0) System.out.println(answer);
		else System.out.println("use the stairs");

	}

}

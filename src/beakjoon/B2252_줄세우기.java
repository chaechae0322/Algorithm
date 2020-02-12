package beakjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * B2252_줄세우기
 * 2020.02.03
 */
public class B2252_줄세우기 {
	static int N,M;
	static ArrayList<Integer>[] tograph; //->
	static ArrayList<Integer>[] fromgraph; //<-
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());

		tograph=new ArrayList[N+1];
		fromgraph=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			tograph[i]=new ArrayList<>();
			fromgraph[i]=new ArrayList<>();
		}

		int src=0, dst=0;
		for(int i=0; i<M; i++){
			token = new StringTokenizer(br.readLine());
			src=Integer.parseInt(token.nextToken());
			dst=Integer.parseInt(token.nextToken());

			tograph[src].add(dst);
			fromgraph[dst].add(src);

		}

		boolean[] visited=new boolean[N+1];
		boolean isOver=true;

		for(;;) {
			isOver=true;
			for(int i=1; i<=N; i++) {
				if(fromgraph[i].size()==0 && !visited[i]) {
					System.out.print(i+" ");
					visited[i]=true;
					
					for(int j: tograph[i]) {
						fromgraph[j].remove((Integer)(i));
					}
					tograph[i].clear();
					isOver=false;
				}
			}
			if(isOver) break;
		}
	}

}
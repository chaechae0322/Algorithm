package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RBYpang {
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		int[] map=new int[n];
		
		for(int i=0; i<n; i++) {
			map[i]=Integer.parseInt(br.readLine());
		} // �Է¿Ϸ�
	
		ans=n;
		int color=0;
		System.out.println("ans:"+ans);
	
		for(int i=0; i<n; i++) {
			
			color=map[i];
			System.out.println("start:"+i+" color:"+color);
			
			if(color==1) {
				pang(i, 2, map);
				pang(i, 3, map);
			}
			else if(color==2) {
				pang(i, 1, map);
				pang(i, 3, map);
			}
			else if(color==3) {
				pang(i, 1, map);
				pang(i, 2, map);
			}
		}
		System.out.println(ans);
	}
	static int ans=n;
	private static void pang(int pos, int color, int[] map) {
		int[] tmpmap=map.clone();

		int up=pos;
		int down=pos;
		int cnt=0;
		
		tmpmap[pos]=color;
		int refcolor=color;
		
		int c=0;
		
		while(up >= 0 && down < n && tmpmap[down] == tmpmap[up])  {
			cnt=0;
			refcolor=tmpmap[up];
//			System.out.println(Arrays.toString(tmpmap));
			
			System.out.println("before up:"+up +" down: "+down);
			System.out.println(map[up]+" "+map[down]);
			
			while(up>=0 && refcolor==tmpmap[up]) {
				
				cnt+=1;
				up-=1;
				
				System.out.println(up);
				
			}
			while(down<n && refcolor==tmpmap[down]) {
				cnt+=1;
				down+=1;
			}
			
			System.out.println("after up:"+up +" down: "+down);
	
			if(cnt >= 4) {
				System.out.println("cnt: "+cnt);
				c += cnt;
			}
			
				
		}
		
		ans=Math.min(ans, n-c+1);
		
		
	}
}

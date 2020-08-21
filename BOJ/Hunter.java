package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Hunter {

	static class pos implements Comparable<pos>{
		int x,y;
		public pos() {}
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(pos o) {
			return this.x > o.x ? 1: -1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token= new StringTokenizer(br.readLine());
		int m=Integer.parseInt(token.nextToken());
		int n=Integer.parseInt(token.nextToken());
		int l=Integer.parseInt(token.nextToken());

		int[] gun=new int[m];
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			gun[i]=Integer.parseInt(token.nextToken());
		}
		pos[] animal=new pos[n];
		for(int i=0; i<n; i++) {
			animal[i]=new pos();
			token=new StringTokenizer(br.readLine());

			animal[i].x=Integer.parseInt(token.nextToken());
			animal[i].y=Integer.parseInt(token.nextToken());
		}

		Arrays.sort(gun);
		Arrays.sort(animal);

		int left=0;
		int right=0;
		int x=0, y=0;
		int cnt=0;

		boolean isin=false;

	
		
		
		for(int i=0; i<n; i++) { // ���� ��������

			x=animal[i].x;
			y=animal[i].y;

			
			isin=false;

			while(right<m && x>gun[right]) right++;
			left=right-1;
			
			if(right < m && x> gun[right] && y<=l && x-gun[right] <= l-y) {
				isin=true;
			}
			else if(right < m && x <= gun[right] && y<=l && gun[right]-x <= l-y) {
				isin=true;
			}
			
			if(left >=0 && x>=gun[left] && y<=l && x-gun[left] <= l-y) {
				isin=true;
			}
			
			if(isin)
				cnt++;
			
			

		}




		System.out.println(cnt);

	}

}
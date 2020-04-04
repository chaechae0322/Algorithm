import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1966_PrinterQueue {
	static class Doc {
		int v,idx;

		public Doc(int v, int idx) {
			super();
			this.v = v;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Doc [v=" + v + ", idx=" + idx + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		
		loop:for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(token.nextToken());
			int idx=Integer.parseInt(token.nextToken());
			
			ArrayList<Doc> q=new ArrayList<>();
			token=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				q.add(new Doc(Integer.parseInt(token.nextToken()), i));
			}
			
			boolean isMost = true;
			int cnt=1;
			while(!q.isEmpty()) {
				Doc ref=q.get(0);
				isMost=true;
				for(int i=1; i<q.size(); i++) {
					if(q.get(i).v > ref.v) {
						q.remove(0);
						q.add(ref);
						isMost=false;
						break;
					}
				}
				if(isMost) {
					if(ref.idx==idx) {
						System.out.println(cnt);
						continue loop;
						
					}else {
						cnt++;
						q.remove(0);
					}
				}
			}
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TwoSticker {
	static class square implements Comparable<square>{
		int h, w;
		public square(int h, int w) {
			this.h=h;
			this.w=w;
		}
		@Override
		public int compareTo(square o) {
			if(this.w* this.h == o.w*o.h) return 0;
			else return (this.w*this.h > o.w*o.h)? -1: 1;	
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token= new StringTokenizer(br.readLine());
		
		int h=Integer.parseInt(token.nextToken());
		int w=Integer.parseInt(token.nextToken());
		int n=Integer.parseInt(br.readLine());
		
		ArrayList<square> li=new ArrayList<>();
		int tx=0, ty=0;
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			ty=Integer.parseInt(token.nextToken());
			tx=Integer.parseInt(token.nextToken());
			
			if((tx>h && tx>w) || (ty>h && ty>w)) continue;
			
			li.add(new square(ty, tx));
		}
		
		Collections.sort(li);
		
		square sone=new square(0,0);
		square stwo=new square(0,0);
		int ow=0, oh=0, tw=0, th=0;
		int res=0;
		int ans=0;
		for(int i=0; i<li.size(); i++) {
			sone=li.get(i);
			ow=sone.w;
			oh=sone.h;
		
			
			for(int j=0; j<li.size(); j++) {
				if(i==j) continue;
				
				stwo=li.get(j);
				tw=stwo.w;
				th=stwo.h;
				
				ow=sone.w;
				oh=sone.h;
				
				for(int k=0; k<4; k++) { // 4가지 경우에 대하여
					if(k==1) {
						ow=sone.h;
						oh=sone.w;
					}
					else if(k==2) {
						tw=stwo.h;
						th=stwo.w;
					}
					else if(k==3) {
						ow=sone.h;
						oh=sone.w;
						
						tw=stwo.h;
						th=stwo.w;
					}
					
					if(ow>w || tw>w || oh>h || th>h) continue;
					
					if(ow+tw<=w && oh+th<=h) {
						ans=ow*oh+tw*th;
						res=Math.max(res, ans);
					}
					else if(oh+th<=h) {
						ans=ow*oh+tw*th;
						res=Math.max(res, ans);
					}
					else if(ow+tw<=w) {
						ans=ow*oh+tw*th;
						res=Math.max(res, ans);
					}
				}
			}
		}
		
		System.out.println(res);

	}

}
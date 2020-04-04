package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J1103_Secure {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int m=Integer.parseInt(token.nextToken());
		int n=Integer.parseInt(token.nextToken());
		
		int num=Integer.parseInt(br.readLine());
		ArrayList<int[]> list=new ArrayList<>();
		int dir=0, dis=0;
		for(int i=0; i<num; i++) {
			token = new StringTokenizer(br.readLine());
			dir=Integer.parseInt(token.nextToken());
			dis=Integer.parseInt(token.nextToken());
			
			list.add(new int[] {dir,dis});
		}
		
		token = new StringTokenizer(br.readLine());
		dir=Integer.parseInt(token.nextToken());
		dis=Integer.parseInt(token.nextToken());
		
		int cost=0;
		for(int i=0; i<list.size(); i++) {
			int[] tmp=list.get(i);
			
			if(tmp[0]==dir) {
				cost+=Math.abs(dis-tmp[1]);
			}
			else if(tmp[0]+dir==3) {
				cost+=Math.min(dis+tmp[1], (m-dis)+(m-tmp[1]));
				cost+=n;
			}
			else if(tmp[0]+dir==7) {
				cost+=Math.min(dis+tmp[1], (n-dis)+(n-tmp[1]));
				cost+=m;
			}
			else if(dir<=2) {
				if(dir==1 && tmp[0]==3) {
					cost+=dis+tmp[1];
				}
				else if(dir==1 && tmp[0]==4) {
					cost+=(m-dis+tmp[1]);
				}
				else if(dir==2 && tmp[0]==3) {
					cost+=dis+(n-tmp[1]);
				}
				else if(dir==2 && tmp[0]==4) 	{
					cost+=(n-dis+n-tmp[1]);
				}
			}
			else {
				if(dir==3 && tmp[0]==3) {
					cost+=dis+tmp[1];
				}
				else if(dir==3 && tmp[0]==4) {
					cost+=(n-dis+tmp[1]);
				}
				else if(dir==4 && tmp[0]==3) {
					cost+=dis+(m-tmp[1]);
				}
				else if(dir==4 && tmp[0]==4) {
					cost+=(n-dis+m-tmp[1]);
				}
			}
			
		}
		
		System.out.println(cost);
	}

}

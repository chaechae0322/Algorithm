package swexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S8275_햄스터 {
	static int N,X,M;
	static ArrayList<Record> recordList;  // 기록 리스트들 여기에 저장한다
	static class Record {  // 기록 클래스
		int i, r, s;

		public Record(int i, int r, int s) {
			super();
			this.i = i;
			this.r = r;
			this.s = s;
		}


		@Override
		public String toString() {
			return "Record [i=" + i + ", r=" + r + ", s=" + s + "]";
		}


	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=1; t<=tc; t++) {
			N=sc.nextInt();
			X=sc.nextInt();
			M=sc.nextInt();

			recordList=new ArrayList<>();
			for(int i=0; i<M; i++) {
				recordList.add(new Record(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}

			int[] batch = new int[N];
			ans=new int[N];
			flag=false;
			solve(0, batch);
			
			
			if(!flag) {
				System.out.println("#"+t+" -1");
				continue;
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<N; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}

	}
	static int[] ans;
	static boolean flag;
	private static void solve(int idx, int[] batch) {
		
		if(idx==N) { 
			
			int cnt=0;
			for(int i=0; i<M; i++) {
				cnt=0;
				for(int k=recordList.get(i).i-1; k<=recordList.get(i).r-1; k++) { //i~r
					cnt+=batch[k];
				}
				if(recordList.get(i).s!=cnt) { //기록 틀릴때 
					return;
				}
			}

			int anscnt=0;
			cnt=0;
			for(int i=0; i<N; i++) {  // 햄스터 갯수세기
				anscnt+=ans[i];
				cnt+=batch[i];
			}
            if(cnt == 0) {  // 모두 0일때 예외상황  
				flag=true;
				ans=batch.clone();
				return;
			}
            
			if(anscnt<cnt) { // 갯수 더 많으면 ans 바꾸기
				flag=true;
				ans = batch.clone();
			}
			else if(anscnt==cnt) { // 같으면 자릿수 순서로 비교
				for(int i=0; i<N; i++) {
					if(batch[i]<ans[i]) {
						flag=true;
						ans=batch.clone();
						break;
					}
					else if(ans[i]<batch[i]) {
						break;
					}
				}
			}
			return;
		}

		for(int i=0; i<=X; i++) {
			batch[idx]=i;
			solve(idx+1, batch);
		}
	}
}

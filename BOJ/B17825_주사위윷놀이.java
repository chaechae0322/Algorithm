
package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class B17825_주사위윷놀이 {
	
	static int[] ten= {10,13,16,19,25};
	static int[] two= {2,4,6,8,10,12,14,16,18,20,22,24,25,26,28,30,32,34,36,38,40};
	static int[] twenty= {20,22,24,25};
	static int[] twentyfive= {25,30,35,40};
	static int[] thirty= {30, 32, 34, 36, 38,40};
	
	static int[] dice;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		visited= new int[41];
		dice= new int[10];
		
		for(int i=0; i<10; i++)
			dice[i]=sc.nextInt();
		
		
		dfs(0, 0, 0);
	}
	static int[] mal = {0, 0, 0, 0};
	static int ans;
	private static void dfs(int idx, int turn, int sum) {
		if(sum==10) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(mal[i]==40) continue;
			
			int go = move(idx, turn); // 이동가능한지 안한지 체크하고 되면 이동
			if(go!=-1) {
				dfs(idx+1, turn+1, sum+go);  // 턴 + 1
				back(idx, turn); // 이동 되돌리기
			}
		}
		
		
		
	}
	private static void back(int idx, int turn) {
		// TODO Auto-generated method stub
		
	}
	private static int move(int idx, int turn) {
		if(mal[idx]==10) {
			if(dice[turn] > ten.length) {
				
			}else {
				
			}
			
		}else if(mal[idx]==20) {
			
		}else if(mal[idx]==25) {
			
		}else if(mal[idx]==30) {
			
		}else {
			
		}
		
		return 0;
	}

}

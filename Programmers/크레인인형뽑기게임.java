package Programmers;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}
		};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));

	}
	
	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> st = new Stack<>();
		int n = board.length;
		int answer = 0;
		loop: for(int i=0; i<moves.length; i++) {
			int x = moves[i]-1;
			int y=0;
			int tmp=0;
			for(int j=0; j<n; j++) {
				if(board[j][x]!=0) {
					y=j;
					System.out.println("peek:"+board[y][x]);
					tmp = board[y][x];
					board[y][x]=0;
					break;
				}
				if(j==n-1) {
					System.out.println("ddd");
					continue loop;
				}
			}
			
			
			if(!st.isEmpty() && (st.peek() == tmp)) {
				System.out.println("same");
				st.pop();
				answer+=2;
			}
			else {
				st.push(tmp);
			}
		}
		
        return answer;
	}

}

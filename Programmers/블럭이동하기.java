package Programmers;

public class 블럭이동하기 {
	static class Block{
		int x,y,pos;  // pos:1 가로, 2:세로

		public Block() {
			super();
		}

		public Block(int x, int y, int pos) {
			super();
			this.x = x;
			this.y = y;
			this.pos = pos;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getPos() {
			return pos;
		}

		public void setPos(int pos) {
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "Block [x=" + x + ", y=" + y + ", pos=" + pos + "]";
		}
		
	}

	public static void main(String[] args) {
		int[][] board = {
				{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}
		};

	}
	
	
	public static int solution(int[][] board) {
		int answer = 0;
		
		return answer;
	}

}

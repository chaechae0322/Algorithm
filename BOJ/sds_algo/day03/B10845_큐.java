package BOJ.sds_algo.day03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10845_큐 {
	static int[] qu;
	static int front=0, end=0; 
	static void push(int x) {
		qu[end++]=x;
	}
	static int empty() {
		if(end==front) return 1;
		else return 0;
	}
	static int pop() {
		if(end==front) return -1;
		else return qu[front++];
	}
	static int front() {
		if(end==front) return -1;
		else return qu[front];
		
	}
	static int back() {
		if(end==front) return -1;
		else return qu[end-1];
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		qu=new int[N+1];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			System.out.println(input);
			switch (input) {
			case "pop":
				System.out.println(pop());
				break;
			case "front" :
				System.out.println(front());
				break;
			case "back" :
				System.out.println(back());
				break;
			case "size":
				System.out.println(end-front);
				break;
			case "empty":
				System.out.println(empty());
				break;
			default:
				push(Integer.parseInt(input.split(" ")[1]));
				break;
			}
		}
	}

}

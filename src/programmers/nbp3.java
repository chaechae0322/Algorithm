package programmers;

public class nbp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	static public int solution(int num, int[] mark) {
		
        int answer = -1;
        int[] check = new int[mark.length];
        boolean[] visited = new boolean[mark.length];
        
        int pos = 0;
        int term = 0;
        boolean isCycle=false;
        int start = 0;
        int remain = 0;
        int prev = -1;
        for(int i=0;i<num;i++){
            if(visited[pos]){
                start = pos;
                remain = num-i+1;
                pos = mark[pos];
                term++;
                while(pos!=start){
                    term++;
                    pos = mark[pos];
                }
                isCycle=true;
                break;
            }
            check[pos]=i+1;
            visited[pos]=true;
            prev = pos;
            pos = mark[pos];
            answer = pos;
        }
        
        if(isCycle){
            int destPos = remain%term;
            System.out.println(remain+" "+term);
            System.out.println(destPos);
            answer = prev;
            for(int i=0;i<destPos;i++){
                prev = mark[prev];
                answer = prev;
            }
        }
        return answer;
	}


}

package programmers;

public class nbp1 {

	public static void main(String[] args) {
		String p = "<<<<";
		System.out.println(solution(p));

	}
	
	static int[] check;
	static int[] visited;
    static public int solution(String p) {
        
        int n = p.length();
        int answer = n;
        
        check=new int[n];
        visited=new int[n];
        
        boolean openflag = false;
        int open=-1;
        int close=-1;
         
        for(int i=0; i<n; i++) {
        	if(p.charAt(i) == '>' && !openflag) {
        		openflag = true;
        		open = i;
        	}
        	
        	if(p.charAt(i) == '<' && close < i) {
        		close = i;
        	}
        }
        
        System.out.println(open);
        System.out.println(close);
        
        if(open != -1 && close != -1) {
        	//System.out.println("ddd");
        	answer = n - (close-open +1);
        }
        
        return answer;
    }

}

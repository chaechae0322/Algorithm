package Programmers;

public class sol3 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 2, 2, 3}));

	}
    public static int solution(int[] histogram) {
        int answer = 0;
        int n=histogram.length;
        int l=0, r=n-1, pre=0;
        while(l<r){
        	System.out.println("l:"+l+" r:"+r+" histo l:"+histogram[l]+" histo r:"+histogram[r]);
            int tmp=(histogram[l]>histogram[r]?histogram[r]:histogram[l])*(r-l-1);
            System.out.println("tmp:"+tmp);
            answer=Math.max(tmp, answer);
            if(histogram[l] == histogram[r]){ // 둘다 이동
            	System.out.println("둘다이동");
                pre=l;
                while(++l<n && histogram[l]<=histogram[pre]);
                System.out.println("new l:"+l+" "+histogram[l]);
                
                pre=r;
                while(--r>=0 && histogram[r]<=histogram[pre]);
                System.out.println("new r:"+r+" "+histogram[r]);
                
            }else if (histogram[l]>histogram[r]){ // r 이동
            	System.out.println("r 이동");
                pre=r;
                while(--r>=0 && histogram[r]<=histogram[pre]);
                System.out.println("new r:"+r+" "+histogram[r]);
                
            }else{
            	System.out.println("l 이동");
                pre=l;
                while(++l<n && histogram[l]<=histogram[pre]);
                System.out.println("new l:"+l+" "+histogram[l]);

            }
        }
        return answer;
    }

}

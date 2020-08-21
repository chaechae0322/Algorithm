package Programmers;

public class Line2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String answer_sheet = "24551";
		String[] sheets = {"24553", "24553", "24553", "24553"};
		
		int maxindex=0;
		for(int i=0; i<sheets.length-1; i++){
			char[] a =sheets[i].toCharArray();
            for(int j=1; j<sheets.length; j++){
            	if(i==j) continue;
            	int sequence=0;
            	int index=0;
            	int maxseq = 0;
            	int count=0;
            	char[] b = sheets[j].toCharArray();
                for(int k=0; k<answer_sheet.length(); k++){
                    if(b[k]==a[k] && b[k]!=answer_sheet.charAt(k)) {
                    	sequence +=1;
                    	count+=1;
                    	maxseq = Math.max(maxseq, sequence);
                    }
                    else {
                    	sequence =0;
                    }
                    
                }
                
                index = count + maxseq*maxseq;
                maxindex = Math.max(maxindex, index);
            }
        }
		System.out.println(maxindex);
	}

}

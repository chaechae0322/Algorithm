package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Level2추석트래픽 {

	public static void main(String[] args) {
		String[] lines = {
				/*"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"*/
				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"

		};
		solution(lines);

	}

	public static int solution(String[] lines) {
		int answer=0;
		double end=0, start=0;
		double ss=0, ee=0;
		double[][] linesTrans = new double[lines.length][2];
		PriorityQueue<Double> point = new PriorityQueue<>();
		
		for(int i=0; i<lines.length; i++) {
			System.out.println(lines[i]);
			String tmp = lines[i].substring(11,13);
			tmp = tmp.concat(lines[i].substring(14,16));
			tmp = tmp.concat(lines[i].substring(17,23));
			System.out.println("tmp: "+tmp);
			String last = lines[i].substring(24,lines[i].length()-1);
			System.out.println("last: "+last);

			end = Double.parseDouble(tmp);
		
			
			System.out.println(end);
			start = (end*1000-Double.parseDouble(last)*1000 + 1)/1000.0;
			if(Math.round(start)/1000%10==9) {
				start -= 4000;
			}
			if(Math.round(start)/10%10==9) {
				start -= 40;
			}
			
			linesTrans[i][0]=start;
			linesTrans[i][1]=end;
			System.out.println("start:"+start+" end:"+end);

			point.add(start);
			point.add(end);


		}

		System.out.println("point size:"+point.size());
		
		for(int i=0; i<point.size(); i++) {
		//while(!point.isEmpty()) {
			start = point.poll();
			ss=(start*1000+1*1000-1)/1000.0;
			System.out.println("start: "+start+ " ss: "+ss);
			int tmpans=0;
			
			for(int j=0; j<lines.length; j++) {
				if(linesTrans[j][0]>ss||linesTrans[j][1]<start) continue;
				
				System.out.println("포함 j:"+j);
				System.out.println(linesTrans[j][1]);
				tmpans++;
				answer = Math.max(tmpans, answer);
			}
		}
		
		System.out.println("answer: "+answer);

		return answer;
	}

}

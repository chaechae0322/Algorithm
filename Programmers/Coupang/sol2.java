package Programmers.Coupang;

import java.util.ArrayList;

public class sol2 {
	static class Kiosk{
		int year;
		String time;
		ArrayList<Integer> list;
		public Kiosk(int year, String time, ArrayList<Integer> list) {
			super();
			this.year = year;
			this.time = time;
			this.list = list;
		}
		@Override
		public String toString() {
			return "Kiosk [time=" + time + ", list=" + list + "]";
		}
		
	}
	public static void main(String[] args) {
		int n = 2;
		String[] c= {"02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"};
		System.out.println(solution(n, c));
	}
	static Kiosk[] krr;
	public static int solution(int n, String[] customers) {
		int answer=0;
		krr = new Kiosk[n];
		for(int i=0; i<n; i++) krr[i]=new Kiosk(2020,"0", new ArrayList<>());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<customers.length; i++) {
			// 숫자로 변환 "10/01 23:20:25 30"
			sb.append(customers[i].substring(0,2));
			sb.append(customers[i].substring(3,5));
			sb.append(customers[i].substring(6,8));
			sb.append(customers[i].substring(9,11));
			sb.append(customers[i].substring(12,14));
			
			String time = sb.toString();
			String duration = customers[i].substring(15,17);
			sb.delete(0, sb.length());
			System.out.println(time+" "+duration);
			
			matching(time, duration);
		}
		
		for(int i=0; i<n; i++) {
			if(answer<krr[i].list.size()) {
				answer=krr[i].list.size();
			}
		}
		return answer;
	}
	private static void matching(String time, String duration) {
		// 키오스크 찾기
		long mintime=Long.MAX_VALUE; int mink=-1;
		for(int i=0; i<krr.length; i++) {
			System.out.println(krr[i].toString());
			long ktime = Long.parseLong(krr[i].time) + krr[i].year*(long)Math.pow(10, 10);
			System.out.println("ktime:"+ktime);
			if(ktime < mintime) {
				mintime=ktime;
				mink=i;
			}
		}
		krr[mink].time=timecal(mink, time, duration);
		krr[mink].list.add(1);
	}
	private static String timecal(int n, String ctime, String duration) { // 키오스크 , 손님 도착, 지속 시간
		System.out.println("idx:"+n+" ctime:"+ctime+" duration:"+duration);
		String time = "";
		if(krr[n].time.equals("0")) {
			time = ctime;
		}else {
			time = krr[n].time;
		}
		System.out.println("time:"+time);
		
		int month=Integer.parseInt(time.substring(0,2));
		int day=Integer.parseInt(time.substring(2,4));
		int hour=Integer.parseInt(time.substring(4,6));
		int min=Integer.parseInt(time.substring(6,8));
		int sec=Integer.parseInt(time.substring(8,10));
		
		min += Integer.parseInt(duration);
		if(min>=60) {
			hour += 1;
			min -= 60;
		}
		if(hour>=24) {
			day+=1;
			hour-=24;
		}
		if(month==2&&day>28) {
			month+=1;
			day=1;
		}else if((month==4||month==6||month==9||month==11)&&day>30) {
			month+=1;
			day=1;
		}else if(day>31) {
			month+=1;
			day=1;
			if(month==13) {  // 다음해
				krr[n].year+=1;
				month=1;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(month<10) sb.append("0");
		sb.append(month);
		if(day<10) sb.append("0");
		sb.append(day);
		if(hour<10) sb.append("0");
		sb.append(hour);
		if(min<10) sb.append("0");
		sb.append(min);
		if(sec<10) sb.append("0");
		sb.append(sec);
		System.out.println("new time: "+sb.toString());
		return sb.toString();
	}
}

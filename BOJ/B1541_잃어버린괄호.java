package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		String in = sc.next();
		List<Integer> list = new ArrayList<>();
		int f=-1, r=0, num=0;
		for(int i=0; i<in.length(); i++) {
			char ch=in.charAt(i);
			if(ch-'0'>=0 && ch-'0'<=9) {
				if(f==-1) {f=i; r=i;}
				else r++;
			}else if(ch=='+') {
				num+=Integer.parseInt(in.substring(f, i));
				f=-1;
			}else if(ch=='-') {
				num+=Integer.parseInt(in.substring(f, i));
				f=-1;
				list.add(num);
				num=0;
			}
		}
		num+=Integer.parseInt(in.substring(f,in.length()));
		list.add(num);
		num=list.get(0);
		for(int i=1; i<list.size(); i++) {
			num-=list.get(i);
		}
		System.out.println(num);
	}

}

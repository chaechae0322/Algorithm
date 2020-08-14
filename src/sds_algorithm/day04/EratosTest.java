package sds_algorithm.day04;

public class EratosTest {
	static int[] map = new int[1001];
	public static void main(String[] args) {
		System.out.println(7/(-3));
		System.out.println(7%(-3));
		for(int i=2; i<map.length; i++) {
			if(map[i]!=0) {
				for(int j=2; j*i<map.length; j++) {
					if(map[j*i]==0) {
						map[j*i]=1;
					}
				}
			}
		}
		for(int i=2; i<map.length; i++) {
			if(map[i]==0)System.out.println(i);
		}
	}

}


public class BinarySearch {

	public static void main(String[] args) {
		int[] arr= {2,4,7,9,11,19,23};
		
		System.out.println(binarySearch(arr, 20));
	}

	static boolean binarySearch(int[] arr, int key) {
		int start=0, end=arr.length-1,middle;
		while(start <= end) {
			middle=(start+end)/2;
			if(key == arr[middle])
				return true;
			else if(key < arr[middle]) {
				end=middle-1;
			}
			else
				start=middle+1;
		}
		return false;
	}

}

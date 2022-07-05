package test;

public class Program {

	public static void main(String[] args) {
	
		int array[] = {2,3,6,4,5,7,9,1,34,235,565,341};
		int key = 4;
		
		int idx = linearSearch(array,key);
		System.out.println(idx);
	}

	private static int linearSearch(int[] array, int key) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key)
				return i;
		}
		
		return -1;
	}

}

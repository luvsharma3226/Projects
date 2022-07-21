package test;

public class Program {

	public static int pivotInSortedAndRevesedArray(int nums[]) {
		int s = 0, e = nums.length - 1;
		int mid = s+(e-s)/2;
		
		while(s < e) {
			if(nums[mid] > nums[mid+1]) {
				s = mid+1;
			}
			else {
				e = mid;
			}
			
			return s;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int []arr = {7,8,9,1,2,3};
		int res = pivotInSortedAndRevesedArray(arr);
		System.out.println("\n\nPivot index = "+ res);
	}
}

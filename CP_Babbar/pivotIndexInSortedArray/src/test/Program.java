package test;

public class Program {

	
	 public static int pivotIndex(int[] nums) {
	     
	        int sum = 0;
	        for(int i = 0 ; i < nums.length ; i++)
	            sum += nums[i];
	        int lsum = 0;
	        for(int i = 0; i < nums.length ; i++){
	            lsum += nums[i];
	            
	            if(sum == lsum)
	                return i;
	            sum = sum - nums[i];
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,3,2,1};
		int ans = pivotIndex(arr);
		System.out.println("Pivot index is : "+ ans);
	}

}

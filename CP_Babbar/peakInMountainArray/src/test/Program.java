package test;

public class Program {

	
	 public static int peakIndexInMountainArray(int[] arr) {
	        
	        int s = 0, e = arr.length - 1;
	        int mid = s + (e-s) /2;
	        
	        while(s < e){
	            if(arr[mid] < arr[mid + 1]){
	                s = mid + 1;
	            }
	            else{
	                e = mid;               
	            }
	            mid = s+(e-s)/2;
	        
	    }
	        return s;
	}
	 
	 
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,7,3,2,1};
		int ans = peakIndexInMountainArray(arr);
		System.out.println("Peak index is : "+ ans);
	}

}

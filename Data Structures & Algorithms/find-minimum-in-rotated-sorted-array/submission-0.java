class Solution {
    public int findMin(int[] nums) {
        int left = 0 ;
        int n= nums.length ;
        int right = n-1;
        while (left < right ){
            if(nums[left]<nums[right]){
                break ;
            }
            int mid = ((right + left)/2) ;
          if (nums[mid] > nums[right]) {       
                left = mid + 1;
            } else {
                right = mid;                     
            }
        }
        return nums[left] ;
    }
}

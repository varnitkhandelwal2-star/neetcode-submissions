class Solution {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length -1 ;
        int mid = 0 ;
        int left =0 ; 
        while(right >= left){
            mid = left + ((right-left)/2) ;
            if (target== nums[mid] ) return mid ;
            if (target < nums[mid]){
                right = mid-1 ;
            }
            else if(target > nums[mid] ){
                left = mid+1 ;
            }
        }
        return left ;
    }
}
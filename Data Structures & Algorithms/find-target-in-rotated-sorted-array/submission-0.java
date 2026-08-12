class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length ;
        int right = n -1;
        int left =0 ;
        while(left<= right){
            int mid = (left + right)/2 ;
            if(nums[mid]==target){
                 return mid ;
            }
            if (nums[mid]>nums[right]){
                if(target >= nums[left] && target < nums[mid]){
                      right = mid - 1;
                } else {
                  left = mid + 1;
            }
            }
           else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1 ;
    }
}

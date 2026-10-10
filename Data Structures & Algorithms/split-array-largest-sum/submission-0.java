class Solution {
    public int splitArray(int[] nums, int k) {
        
        int maxnums = 0;
        int sum = 0 ;
        for(int i=0 ; i<nums.length ; i++){
             sum+=nums[i] ;
        if(nums[i] > maxnums) maxnums = nums[i];
        }
        int right = sum ;
        int left = maxnums ;
        int mid = 0 ;
        while(right>=left){
            mid = left + (right-left)/2 ;
            if(countdays(nums , mid) <= k) right = mid-1 ;
            else left = mid+1 ;
        }
        return left ;
        
    }
    int countdays(int[] nums, int capacity)  {
            int currentload = 0 ;
            int days = 1 ;
            for(int i=0 ; i<nums.length ; i++ ){
                if(currentload+nums[i] > capacity ){
                    days++ ;
                    currentload = 0 ;
                }
                currentload += nums[i] ;
            }
            return days ;
    }
}


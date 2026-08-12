class Solution {
    public int rob(int[] nums) {
  
             if(nums.length == 1) return nums[0];
        int[] case1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] case2 = Arrays.copyOfRange(nums, 1, nums.length );

        return Math.max(robblinear(case1) , robblinear(case2)) ;
    }
        private int robblinear(int[]nums){
             if(nums.length == 1) return nums[0];
           if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int rob1 = nums[0] ;
        int rob2 = Math.max(nums[0], nums[1]) ;
        for(int i=2 ; i<nums.length;i++){
            int curr = Math.max(nums[i] +rob1 , rob2) ;
            
            rob1 = rob2 ;
            rob2 = curr ;
        } 
        return rob2 ;
        }
}

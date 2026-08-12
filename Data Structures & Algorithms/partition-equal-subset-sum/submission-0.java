class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0 ;
        int totalsum = 0;
        for(int num : nums){
        totalsum += num;  
    }
        target = totalsum/2 ;
        if (totalsum%2!=0 )return false ;
         int[][] memo = new int [nums.length][target+1] ;
         for(int[] row : memo) Arrays.fill(row, -1);  
         return solve(0,target,nums,memo) ;
    }
    
    private boolean solve(int i , int target , int[]nums ,int [][]memo){
    
    if(target==0)return true ;
    if(i>=nums.length) return false ;
    if(target<0) return false ;
    if(memo[i][target]!=-1) return memo[i][target] ==1 ;

    memo[i][target] = solve(i+1, target-nums[i] , nums , memo) || solve(i+1 , target,nums,memo) ? 1: 0 ;
    return memo[i][target]==1 ;
    }
}

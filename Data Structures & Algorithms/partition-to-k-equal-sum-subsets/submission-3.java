class Solution {
        int[]result ;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        result = new int[k] ;
        int sum = 0 ;
        for( int i=0 ; i<nums.length ; i++) {
            sum+=nums[i] ;
        }
        if(sum %k != 0) return false ;
        int target = sum/k ;
        if( backtrack (k,target ,nums,0)) return true ;
        return false ;
    }
    boolean backtrack (int k , int target , int[] nums , int i ){
        if (i==nums.length) return true ;
        for (int j=0 ; j<k ; j++){
            if(result[j]+nums[i] > target) continue ;
            result[j] +=nums[i] ;
            if (backtrack(k,target,nums,i+1)) return true ;
            result[j]-=nums[i] ;
            if(result[j]==0) break ;
        }
        return false ;
    } 
}


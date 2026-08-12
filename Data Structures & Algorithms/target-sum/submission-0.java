class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = 0 ;
        for(int n:nums) totalsum+= n ;
          int[][] memo = new int[nums.length][2*totalsum + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, target, nums, memo,totalsum);
    }

    public int solve(int i, int target, int[] nums, int[][] memo , int totalsum){
        if(i == nums.length) return target== 0 ? 1 :0;
        if(target + totalsum < 0 || target + totalsum > 2*totalsum) return 0;
        if(memo[i][target +totalsum] != -1) return memo[i][totalsum+target];

        int sub = solve(i+1, target - nums[i], nums, memo,totalsum);
        int add = solve(i + 1, target+nums[i], nums, memo,totalsum);
        return memo[i][totalsum+target] = add+sub ;
    }
}

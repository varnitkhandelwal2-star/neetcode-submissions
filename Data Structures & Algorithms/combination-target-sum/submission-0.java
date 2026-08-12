class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, new ArrayList<>(), nums, target);
        return result;
    }

    void dfs(int i, List<Integer> current, int[] nums, int target){
        if(target == 0){
       result.add(new ArrayList<>(current))  ;// ✅ adds a copy!     
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        // INCLUDE nums[i]
        current.add(nums[i]);
        dfs(i, current, nums, target-nums[i]);

        // EXCLUDE nums[i] → backtrack
        current.remove(current.size()-1);
        dfs(i+1, current, nums, target);

    }
}
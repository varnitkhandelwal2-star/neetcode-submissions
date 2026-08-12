class Solution {
   List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return result;
    }
    void dfs(int i, List<Integer> current, int[]nums){
    if(i >= nums.length){
    result.add(new ArrayList<>(current))  ;// ✅ adds a copy!     
    return ;
    }
    
   current.add(nums[i]) ; // include nums[i]
    dfs(i + 1, current ,nums) ;
    
    current.remove(current.size() - 1) ;  // remove last element
    dfs(i + 1, current ,nums) ;
        }
}

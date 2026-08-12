class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {  // add() returns false if already present
                return true;          // duplicate found — stop immediately
            }
        }
        return false;
    }
}
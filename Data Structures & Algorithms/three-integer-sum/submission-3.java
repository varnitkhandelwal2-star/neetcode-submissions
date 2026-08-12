class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {  // Fix 1: for loop, not while; n-2 bound
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;   // Fix 2: left starts at i+1, not 0
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));  // Fix 3: add, don't return
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {  // Fix 4: left-1 not left+1
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;  // Fix 5: return result list, not a new array
    }
}

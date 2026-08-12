class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> temp) {

        // Found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicate elements
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            // No need to continue if current number is greater than target
            if (candidates[i] > target)
                break;

            temp.add(candidates[i]);

            // Move to next index (each element can be used only once)
            backtrack(candidates, target - candidates[i], i + 1, temp);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
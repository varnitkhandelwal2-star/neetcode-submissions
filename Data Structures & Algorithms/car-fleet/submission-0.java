class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int n = position.length;

        // Create index array to sort positions in descending order
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        for (int i = 0; i < n; i++) {
            int j = idx[i];
            double time = (double)(target - position[j]) / speed[j];

            // Only push if this car is slower than the fleet ahead (forms new fleet)
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // else: car catches up to fleet ahead, merges — do nothing
        }

        return stack.size();
    }
}
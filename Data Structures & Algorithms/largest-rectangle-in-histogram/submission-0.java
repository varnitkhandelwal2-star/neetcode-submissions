class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // Stack stores [startIndex, height]
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Sentinel: treat end of array as height 0 to flush remaining bars
            int currHeight = (i == n) ? 0 : heights[i];
            int start = i;

            // Pop all bars taller than current — they can't extend further right
            while (!stack.isEmpty() && stack.peek()[1] > currHeight) {
                int[] top = stack.pop();
                int height = top[1];
                int width  = i - top[0];        // extends from its start up to current i
                maxArea = Math.max(maxArea, height * width);
                start = top[0];                 // current bar can extend back to where top started
            }

            stack.push(new int[]{start, currHeight});
        }

        return maxArea;
    }
}
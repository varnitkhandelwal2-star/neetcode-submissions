public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // This array will act as our Deque storing indices
        int[] deque = new int[n]; 
        int head = 0; // Front of deque
        int tail = 0; // Back of deque

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window range
            if (head < tail && deque[head] <= i - k) {
                head++;
            }

            // 2. Remove indices of elements smaller than the current element
            // because they will never be the maximum in this or future windows
            while (head < tail && nums[deque[tail - 1]] <= nums[i]) {
                tail--;
            }

            // 3. Add current element's index to the back
            deque[tail++] = i;

            // 4. If the window has reached size k, the front of deque is the max
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque[head]];
            }
        }

        return result;
    }
}
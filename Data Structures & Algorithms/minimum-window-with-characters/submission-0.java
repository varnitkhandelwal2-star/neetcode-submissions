public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency array for characters in t
        int[] targetCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetCount[t.charAt(i)]++;
        }

        // Sliding window variables
        int[] windowCount = new int[128];
        int left = 0, right = 0;
        int required = 0; // Number of unique characters in t that are satisfied
        
        // Determine how many unique characters in t we need to match
        int uniqueCharsInT = 0;
        for (int count : targetCount) {
            if (count > 0) uniqueCharsInT++;
        }

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int formed = 0; // Tracks how many unique characters meet the required frequency

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount[c]++;

            // If current char frequency matches the target frequency
            if (targetCount[c] > 0 && windowCount[c] == targetCount[c]) {
                formed++;
            }

            // Try to shrink the window from the left
            while (formed == uniqueCharsInT) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                // If removing this char makes the window invalid
                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
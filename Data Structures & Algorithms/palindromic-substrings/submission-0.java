class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[] count = {0};

        for (int i = 0; i < n; i++) {
            expand(s, i, i, count);      // odd-length
            expand(s, i, i + 1, count);  // even-length
        }

        return count[0];
    }

    private void expand(String s, int left, int right, int[] count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count[0]++;
            left--;
            right++;
        }
    }
}
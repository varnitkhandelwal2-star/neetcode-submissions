class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        // dp[i] = minimum extra chars in s[0...i-1]
        int[] dp = new int[n + 1];
        
        // base case: empty string has 0 extra chars
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            // option 1: treat s[i-1] as extra character
            dp[i] = dp[i-1] + 1;
            
            // option 2: try every word in dictionary ending at i
            for (String word : dictionary) {
                int len = word.length();
                // check if word fits and matches substring ending at i
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    // if match, no extra chars for this word
                    dp[i] = Math.min(dp[i], dp[i - len]);
                }
            }
        }
        
        return dp[n];
    }
}
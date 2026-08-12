class Solution {
    int[][] memo;
    String word1, word2;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return solve(0, 0);
    }

    public int solve(int i, int j) {
        // Base case 1: word1 exhausted → insert remaining word2
        if (i == word1.length()) return word2.length() - j;
        // Base case 2: word2 exhausted → delete remaining word1
        if (j == word2.length()) return word1.length() - i;

        // Already computed?
        if (memo[i][j] != -1) return memo[i][j];

        int result;
        if (word1.charAt(i) == word2.charAt(j)) {
            // No operation needed, both pointers move
            result = solve(i + 1, j + 1);
        } else {
            int replace = 1 + solve(i + 1, j + 1); // match this pos
            int delete  = 1 + solve(i + 1, j);      // remove word1[i]
            int insert  = 1 + solve(i, j + 1);      // match word2[j]
            result = Math.min(replace, Math.min(delete, insert));
        }

        return memo[i][j] = result;
    }
}